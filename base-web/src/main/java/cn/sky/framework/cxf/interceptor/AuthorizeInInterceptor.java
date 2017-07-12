package cn.sky.framework.cxf.interceptor;

import java.util.logging.Logger;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

import cn.sky.framework.cxf.WebServiceAuthorize;
import cn.sky.framework.util.SpringUtil;

/**
 * WebService 请求认证拦截器
 * 
 * @author ligaofu
 *
 */
@Component
public class AuthorizeInInterceptor extends AbstractPhaseInterceptor<Message> {
	private static final Logger log = LogUtils.getLogger(AuthorizeInInterceptor.class);
	protected WebServiceAuthorize wsAuthorize = null;

	public AuthorizeInInterceptor() {
		this(Phase.RECEIVE);
	}

	public AuthorizeInInterceptor(String phase) {
		super(phase);
		try {
			wsAuthorize = SpringUtil.getBean(WebServiceAuthorize.class);
		} catch (Exception e) {
			// ignore
		}
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		if (wsAuthorize != null) {
			StringBuilder soapxml = (StringBuilder) message.get(Item.IN_SOAPXML);
			if (soapxml != null && soapxml.length() != 0) {
				boolean access = wsAuthorize.authorize(soapxml.toString());
				if (!access) {
					log.info("access denied");
					Fault fault = new Fault("access denied", log);
					fault.setFaultCode(Fault.FAULT_CODE_CLIENT);
					throw fault;
				}
			}
		}
	}

}
