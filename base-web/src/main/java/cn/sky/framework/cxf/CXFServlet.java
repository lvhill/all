package cn.sky.framework.cxf;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.jws.WebService;
import javax.servlet.ServletConfig;

import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import cn.sky.framework.annotation.AnnotationClassFactory;
import cn.sky.framework.cxf.interceptor.AuthorizeInInterceptor;
import cn.sky.framework.cxf.interceptor.LogInInterceptor;
import cn.sky.framework.cxf.interceptor.LogOutInterceptor;
import cn.sky.framework.util.SpringUtil;

/**
 * 自动扫描WebService并发布
 * 
 * @author gaofu
 *
 */
public class CXFServlet extends CXFNonSpringServlet {
	private static final Logger logger = LoggerFactory.getLogger(CXFServlet.class);

	private static final long serialVersionUID = 7653539899513783845L;

	@Override
	protected void loadBus(ServletConfig sc) {
		super.loadBus(sc);

		publishWebService();
	}

	/**
	 * 自动扫描WebService并发布
	 */
	protected void publishWebService() {
		try {
			LogInInterceptor loggingInInterceptor = SpringUtil.getBean(LogInInterceptor.class);
			AuthorizeInInterceptor authorizeInInterceptor = SpringUtil.getBean(AuthorizeInInterceptor.class);
			LogOutInterceptor loggingOutInterceptor = SpringUtil.getBean(LogOutInterceptor.class);
			Set<Class<?>> annotatedClasses = SpringUtil.getBean(AnnotationClassFactory.class).getAnnotatedClasses();
			for (Class<?> clazz : annotatedClasses) {
				if (!clazz.isInterface()) {
					for (Annotation annotation : clazz.getAnnotations()) {
						if (annotation instanceof WebService) {
							String address = getAddress(clazz, (WebService) annotation);
							WsServerFactoryBean jaxWs = new WsServerFactoryBean();
							jaxWs.setAddress(address);
							jaxWs.setServiceClass(clazz);
							jaxWs.setServiceBean(SpringUtil.getBean(clazz));
							jaxWs.getInInterceptors().add(loggingInInterceptor);
							jaxWs.getInInterceptors().add(authorizeInInterceptor);
							jaxWs.getOutInterceptors().add(loggingOutInterceptor);
							jaxWs.create();
							continue;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 返回WebService的路径
	 * 
	 * @param clazz
	 * @param ws
	 * @return
	 */
	protected String getAddress(Class<?> clazz, WebService ws) {
		String address = "/";
		//
		String name = ws.name();
		String serviceName = ws.serviceName();
		String endpointInterface = ws.endpointInterface();
		//
		if (!StringUtils.isEmpty(name)) {
			address += name;
		} else if (!StringUtils.isEmpty(serviceName)) {
			address += serviceName;
		} else if (!StringUtils.isEmpty(endpointInterface)) {
			String interfaceName = endpointInterface.substring(endpointInterface.lastIndexOf(".") + 1);
			address += interfaceName;
		} else {
			String interfaceName = null;
			Class<?>[] interfaces = clazz.getInterfaces();
			for (Class<?> interfaceClass : interfaces) {
				for (Annotation iAnnotation : interfaceClass.getAnnotations()) {
					if (iAnnotation instanceof WebService) {
						interfaceName = interfaceClass.getName();
						break;
					}
				}
			}
			if (interfaceName != null) {
				address += interfaceName.substring(interfaceName.lastIndexOf(".") + 1);
			} else {
				String className = clazz.getName();
				address += className.substring(className.lastIndexOf(".") + 1);
			}
		}
		return address;
	}

}