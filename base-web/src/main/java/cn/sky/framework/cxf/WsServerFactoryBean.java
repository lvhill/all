package cn.sky.framework.cxf;

import java.util.logging.Logger;

import org.apache.cxf.BusException;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.support.JaxWsServiceFactoryBean;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.factory.FactoryBeanListener;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceModelUtil;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;

import cn.sky.framework.cxf.interceptor.WSDLGetInterceptor;

public class WsServerFactoryBean extends JaxWsServerFactoryBean {
	private static final Logger LOG = LogUtils.getL7dLogger(WsServerFactoryBean.class);
	private ReflectionServiceFactoryBean serviceFactory;

	public WsServerFactoryBean() {
		this(new JaxWsServiceFactoryBean());
	}

	public WsServerFactoryBean(JaxWsServiceFactoryBean serviceFactory) {
		super(serviceFactory);
		this.serviceFactory = super.getServiceFactory();
	}

	protected Endpoint createEndpoint() throws BusException, EndpointException {
		serviceFactory.setFeatures(getFeatures());
		if (serviceName != null) {
			serviceFactory.setServiceName(serviceName);
		}

		if (endpointName != null) {
			serviceFactory.setEndpointName(endpointName);
		}

		Service service = serviceFactory.getService();

		if (service == null) {
			initializeServiceFactory();
			service = serviceFactory.create();
		}

		if (endpointName == null) {
			endpointName = serviceFactory.getEndpointName();
		}
		EndpointInfo ei = service.getEndpointInfo(endpointName);

		if (ei != null) {
			if (transportId != null && !ei.getTransportId().equals(transportId)) {
				ei = null;
			} else {
				BindingFactoryManager bfm = getBus().getExtension(BindingFactoryManager.class);
				bindingFactory = bfm.getBindingFactory(ei.getBinding().getBindingId());
			}
		}

		if (ei == null) {
			if (getAddress() == null) {
				ei = ServiceModelUtil.findBestEndpointInfo(serviceFactory.getInterfaceName(),
						service.getServiceInfos());
			}
			if (ei == null && !serviceFactory.isPopulateFromClass()) {
				ei = ServiceModelUtil.findBestEndpointInfo(serviceFactory.getInterfaceName(),
						service.getServiceInfos());

				if (ei != null) {
					BindingFactoryManager bfm = getBus().getExtension(BindingFactoryManager.class);
					bindingFactory = bfm.getBindingFactory(ei.getBinding().getBindingId());
				}

				if (ei == null) {
					LOG.warning("Could not find endpoint/port for " + endpointName + " in wsdl. Creating default.");
				} else if (!ei.getName().equals(endpointName)) {
					LOG.warning("Could not find endpoint/port for " + endpointName + " in wsdl. Using " + ei.getName()
							+ ".");
				}
			}
			if (ei == null) {
				ei = createEndpointInfo(null);
			} else if (transportId != null && !ei.getTransportId().equals(transportId)) {
				LOG.warning(
						"Transport for endpoint/port " + endpointName + " in wsdl doesn't match " + transportId + ".");
				BindingInfo bi = ei.getBinding();
				ei = createEndpointInfo(bi);
			} else if (getAddress() != null) {
				ei.setAddress(getAddress());
				if (ei.getAddress().startsWith("camel") || ei.getAddress().startsWith("local")) {
					modifyTransportIdPerAddress(ei);
				}

			}
		} else if (getAddress() != null) {
			ei.setAddress(getAddress());
		}

		if (publishedEndpointUrl != null && !"".equals(publishedEndpointUrl)) {
			ei.setProperty("publishedEndpointUrl", publishedEndpointUrl);
		}

		if (endpointReference != null) {
			ei.setAddress(endpointReference);
		}
		Endpoint ep = service.getEndpoints().get(ei.getName());

		if (ep == null) {
			ep = serviceFactory.createEndpoint(ei);
			((EndpointImpl) ep).initializeActiveFeatures(getFeatures());
		} else {
			serviceFactory.setEndpointName(ei.getName());
			if (ep.getActiveFeatures() == null) {
				((EndpointImpl) ep).initializeActiveFeatures(getFeatures());
			}
		}

		if (properties != null) {
			ep.putAll(properties);
		}

		service.getEndpoints().put(ep.getEndpointInfo().getName(), ep);

		if (getInInterceptors() != null) {
			ep.getInInterceptors().addAll(getInInterceptors());
			ep.getInInterceptors().add(WSDLGetInterceptor.INSTANCE);
		}
		if (getOutInterceptors() != null) {
			ep.getOutInterceptors().addAll(getOutInterceptors());
		}
		if (getInFaultInterceptors() != null) {
			ep.getInFaultInterceptors().addAll(getInFaultInterceptors());
		}
		if (getOutFaultInterceptors() != null) {
			ep.getOutFaultInterceptors().addAll(getOutFaultInterceptors());
		}
		serviceFactory.sendEvent(FactoryBeanListener.Event.ENDPOINT_SELECTED, ei, ep, serviceFactory.getServiceClass(),
				getServiceClass());
		return ep;
	}

	private void modifyTransportIdPerAddress(EndpointInfo ei) {
		// get chance to set transportId according to the the publish address
		// prefix
		// this is useful for local & camel transport
		if (transportId == null && getAddress() != null) {
			DestinationFactory df = getDestinationFactory();
			if (df == null) {
				DestinationFactoryManager dfm = getBus().getExtension(DestinationFactoryManager.class);
				df = dfm.getDestinationFactoryForUri(getAddress());
			}

			if (df != null) {
				transportId = df.getTransportIds().get(0);
			} else {
				// check conduits (the address could be supported on
				// client only)
				ConduitInitiatorManager cim = getBus().getExtension(ConduitInitiatorManager.class);
				ConduitInitiator ci = cim.getConduitInitiatorForUri(getAddress());
				if (ci != null) {
					transportId = ci.getTransportIds().get(0);
				}
			}
		}
		if (transportId != null) {
			ei.setTransportId(transportId);
		}
	}

}
