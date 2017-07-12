package cn.sky.framework.cxf.interceptor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;

/**
 * @see org.apache.cxf.frontend.WSDLGetOutInterceptor
 * 
 * @author ligaofu
 *
 */
public class WSDLGetOutInterceptor extends AbstractPhaseInterceptor<Message> {
	public static final WSDLGetOutInterceptor INSTANCE = new WSDLGetOutInterceptor();

	public WSDLGetOutInterceptor() {
		super(Phase.PRE_STREAM);
		getAfter().add(StaxOutInterceptor.class.getName());
	}

	public void handleMessage(Message message) throws Fault {
		Document doc = (Document) message.get(WSDLGetInterceptor.DOCUMENT_HOLDER);
		if (doc == null) {
			return;
		}
		message.remove(WSDLGetInterceptor.DOCUMENT_HOLDER);

		XMLStreamWriter writer = message.getContent(XMLStreamWriter.class);
		if (writer == null) {
			return;
		}
		message.put(Message.CONTENT_TYPE, "text/xml");
		try {
			StaxUtils.writeDocument(doc, writer, true,
					!MessageUtils.getContextualBoolean(message, StaxOutInterceptor.FORCE_START_DOCUMENT, false));
		} catch (XMLStreamException e) {
			throw new Fault(e);
		}
	}
}