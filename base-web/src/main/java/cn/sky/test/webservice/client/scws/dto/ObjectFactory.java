
package cn.sky.test.webservice.client.scws.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the cn.sky.test.webservice.client.scws.dto
 * package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _SpaceResponse_QNAME = new QName("http://webservice.test.sky.cn/", "spaceResponse");
	private final static QName _City_QNAME = new QName("http://webservice.test.sky.cn/", "city");
	private final static QName _Info_QNAME = new QName("http://webservice.test.sky.cn/", "info");
	private final static QName _Space_QNAME = new QName("http://webservice.test.sky.cn/", "space");
	private final static QName _Exception_QNAME = new QName("http://webservice.test.sky.cn/", "Exception");
	private final static QName _InfoResponse_QNAME = new QName("http://webservice.test.sky.cn/", "infoResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * cn.sky.test.webservice.client.scws.dto
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link District }
	 * 
	 */
	public District createDistrict() {
		return new District();
	}

	/**
	 * Create an instance of {@link District.LongitudeLatitude }
	 * 
	 */
	public District.LongitudeLatitude createDistrictLongitudeLatitude() {
		return new District.LongitudeLatitude();
	}

	/**
	 * Create an instance of {@link Student }
	 * 
	 */
	public Student createStudent() {
		return new Student();
	}

	/**
	 * Create an instance of {@link Student.Achievement }
	 * 
	 */
	public Student.Achievement createStudentAchievement() {
		return new Student.Achievement();
	}

	/**
	 * Create an instance of {@link City }
	 * 
	 */
	public City createCity() {
		return new City();
	}

	/**
	 * Create an instance of {@link City.LongitudeLatitude }
	 * 
	 */
	public City.LongitudeLatitude createCityLongitudeLatitude() {
		return new City.LongitudeLatitude();
	}

	/**
	 * Create an instance of {@link SpaceResponse }
	 * 
	 */
	public SpaceResponse createSpaceResponse() {
		return new SpaceResponse();
	}

	/**
	 * Create an instance of {@link InfoResponse }
	 * 
	 */
	public InfoResponse createInfoResponse() {
		return new InfoResponse();
	}

	/**
	 * Create an instance of {@link Space }
	 * 
	 */
	public Space createSpace() {
		return new Space();
	}

	/**
	 * Create an instance of {@link Exception }
	 * 
	 */
	public Exception createException() {
		return new Exception();
	}

	/**
	 * Create an instance of {@link Info }
	 * 
	 */
	public Info createInfo() {
		return new Info();
	}

	/**
	 * Create an instance of {@link Schoole }
	 * 
	 */
	public Schoole createSchoole() {
		return new Schoole();
	}

	/**
	 * Create an instance of {@link District.LongitudeLatitude.Entry }
	 * 
	 */
	public District.LongitudeLatitude.Entry createDistrictLongitudeLatitudeEntry() {
		return new District.LongitudeLatitude.Entry();
	}

	/**
	 * Create an instance of {@link Student.Achievement.Entry }
	 * 
	 */
	public Student.Achievement.Entry createStudentAchievementEntry() {
		return new Student.Achievement.Entry();
	}

	/**
	 * Create an instance of {@link City.LongitudeLatitude.Entry }
	 * 
	 */
	public City.LongitudeLatitude.Entry createCityLongitudeLatitudeEntry() {
		return new City.LongitudeLatitude.Entry();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SpaceResponse
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "spaceResponse")
	public JAXBElement<SpaceResponse> createSpaceResponse(SpaceResponse value) {
		return new JAXBElement<SpaceResponse>(_SpaceResponse_QNAME, SpaceResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link City
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "city")
	public JAXBElement<City> createCity(City value) {
		return new JAXBElement<City>(_City_QNAME, City.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Info
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "info")
	public JAXBElement<Info> createInfo(Info value) {
		return new JAXBElement<Info>(_Info_QNAME, Info.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Space
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "space")
	public JAXBElement<Space> createSpace(Space value) {
		return new JAXBElement<Space>(_Space_QNAME, Space.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Exception
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "Exception")
	public JAXBElement<Exception> createException(Exception value) {
		return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link InfoResponse
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webservice.test.sky.cn/", name = "infoResponse")
	public JAXBElement<InfoResponse> createInfoResponse(InfoResponse value) {
		return new JAXBElement<InfoResponse>(_InfoResponse_QNAME, InfoResponse.class, null, value);
	}

}
