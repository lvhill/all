package cn.sky.framework.cxf.interceptor;

import java.util.Iterator;
import java.util.Map;

import org.apache.cxf.binding.soap.interceptor.EndpointSelectionInterceptor;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.common.util.UrlUtils;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.WSDLGetUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.interceptor.OutgoingChainInterceptor;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.w3c.dom.Document;

/**
 * @see org.apache.cxf.frontend.WSDLGetInterceptor
 * 
 * @author ligaofu
 *
 */
public class WSDLGetInterceptor extends AbstractPhaseInterceptor<Message> {
	public static final WSDLGetInterceptor INSTANCE = new WSDLGetInterceptor();
	public static final String DOCUMENT_HOLDER = WSDLGetInterceptor.class.getName() + ".documentHolder";
	private static final String TRANSFORM_SKIP = "transform.skip";
	private Interceptor<Message> wsdlGetOutInterceptor = WSDLGetOutInterceptor.INSTANCE;

	public WSDLGetInterceptor() {
		super(Phase.READ);
		getAfter().add(EndpointSelectionInterceptor.class.getName());
	}

	public WSDLGetInterceptor(Interceptor<Message> outInterceptor) {
		this();
		// Let people override the wsdlGetOutInterceptor
		wsdlGetOutInterceptor = outInterceptor;
	}

	public void handleMessage(Message message) throws Fault {
		String method = (String) message.get(Message.HTTP_REQUEST_METHOD);
		String query = (String) message.get(Message.QUERY_STRING);

		if (!"GET".equals(method) || StringUtils.isEmpty(query)) {
			return;
		}

		String baseUri = (String) message.get(Message.REQUEST_URL);
		String ctx = (String) message.get(Message.PATH_INFO);

		WSDLGetUtils utils = (WSDLGetUtils) message.getContextualProperty(WSDLGetUtils.class.getName());
		if (utils == null) {
			utils = new WSDLGetUtils();
			message.put(WSDLGetUtils.class, utils);
		}
		Map<String, String> map = UrlUtils.parseQueryString(query);
		if (isRecognizedQuery(map)) {
			Document doc = getDocument(utils, message, baseUri, map, ctx);

			Endpoint e = message.getExchange().getEndpoint();
			Message mout = new MessageImpl();
			mout.setExchange(message.getExchange());
			mout = e.getBinding().createMessage(mout);
			mout.setInterceptorChain(OutgoingChainInterceptor.getOutInterceptorChain(message.getExchange()));
			message.getExchange().setOutMessage(mout);

			mout.put(DOCUMENT_HOLDER, doc);
			mout.put(Message.CONTENT_TYPE, "text/xml");

			// just remove the interceptor which should not be used
			cleanUpOutInterceptors(mout);

			// notice this is being added after the purge above, don't swap the
			// order!
			mout.getInterceptorChain().add(wsdlGetOutInterceptor);

			message.getExchange().put(TRANSFORM_SKIP, Boolean.TRUE);
			// skip the service executor and goto the end of the chain.
			message.getInterceptorChain().doInterceptStartingAt(message, OutgoingChainInterceptor.class.getName());
		}
	}

	protected void cleanUpOutInterceptors(Message outMessage) {
		Iterator<Interceptor<? extends Message>> iterator = outMessage.getInterceptorChain().iterator();
		while (iterator.hasNext()) {
			Interceptor<? extends Message> inInterceptor = iterator.next();
			Class<?> clazz = inInterceptor.getClass();
			boolean isAccessOutInterceptor = inInterceptor instanceof AccessOutInterceptor;
			if (!clazz.equals(StaxOutInterceptor.class) && !clazz.equals(GZIPOutInterceptor.class)
					&& !clazz.equals(MessageSenderInterceptor.class) && !isAccessOutInterceptor) {
				outMessage.getInterceptorChain().remove(inInterceptor);
			}
		}
	}

	private Document getDocument(WSDLGetUtils utils, Message message, String base, Map<String, String> params,
			String ctxUri) {
		// cannot have two wsdl's being generated for the same endpoint at the
		// same
		// time as the addresses may get mixed up
		// For WSDL's the WSDLWriter does not share any state between documents.
		// For XSD's, the WSDLGetUtils makes a copy of any XSD schema documents
		// before updating
		// any addresses and returning them, so for both WSDL and XSD this is
		// the only part that needs
		// to be synchronized.
		synchronized (message.getExchange().getEndpoint()) {
			return utils.getDocument(message, base, params, ctxUri,
					message.getExchange().getEndpoint().getEndpointInfo());
		}
	}

	private boolean isRecognizedQuery(Map<String, String> map) {
		return map.containsKey("wsdl") || map.containsKey("xsd");
	}
}