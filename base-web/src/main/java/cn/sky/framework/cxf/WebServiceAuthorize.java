package cn.sky.framework.cxf;

/**
 * WebService 访问认证
 * 
 * @author ligaofu
 *
 */
public interface WebServiceAuthorize {

	/**
	 * WebService 访问认证
	 * 
	 * @param soapXml
	 * @return
	 */
	public boolean authorize(String soapXml);

}
