package cn.sky.test.webservice.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.cxf.tools.java2ws.JavaToWS;
import org.apache.cxf.tools.wsdlto.WSDLToJava;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sky.framework.soap.SoapClient;
import cn.sky.framework.soap.SoapEntity;
import cn.sky.framework.soap.SoapFault;
import cn.sky.test.webservice.client.bizprocess.dto.GetNewestApplication;
import cn.sky.test.webservice.client.bizprocess.dto.GetNewestApplicationResponse;
import cn.sky.test.webservice.client.distributor.dto.QueryCouponAuthorization;
import cn.sky.test.webservice.client.distributor.dto.QueryCouponAuthorizationReq;
import cn.sky.test.webservice.client.distributor.dto.QueryCouponAuthorizationResponse;
import cn.sky.test.webservice.client.ecard.dto.ActivityTicketDTO;
import cn.sky.test.webservice.client.ecard.dto.MeetingTicketCreated;
import cn.sky.test.webservice.client.ecard.dto.MeetingTicketCreatedResponse;
import cn.sky.test.webservice.client.ecard.dto.MeetingTicketDelete;
import cn.sky.test.webservice.client.ecard.dto.MeetingTicketDeleteResponse;
import cn.sky.test.webservice.client.ecard.dto.QRCodeDTO;
import cn.sky.test.webservice.client.ecard.dto.VerifyAdaCardAuthorization;
import cn.sky.test.webservice.client.ecard.dto.VerifyAdaCardAuthorizationResponse;
import cn.sky.test.webservice.client.entity.Head;
import cn.sky.test.webservice.client.entity.HeadOA;
import cn.sky.test.webservice.client.hub.dto.Lest;
import cn.sky.test.webservice.client.hub.dto.LestResponse;
import cn.sky.test.webservice.client.hub.dto.Msg;
import cn.sky.test.webservice.client.hub.dto.MsgResponse;
import cn.sky.test.webservice.client.meeting.dto.GetAttendinfo;
import cn.sky.test.webservice.client.meeting.dto.GetAttendinfoResponse;
import cn.sky.test.webservice.client.meeting.dto.WsSecurityHeader;
import cn.sky.test.webservice.client.order.dto.CancelMiscOrder;
import cn.sky.test.webservice.client.order.dto.CancelMiscOrderReq;
import cn.sky.test.webservice.client.order.dto.CancelMiscOrderResponse;
import cn.sky.test.webservice.client.scws.dto.Info;
import cn.sky.test.webservice.client.scws.dto.InfoResponse;
import cn.sky.test.webservice.client.scws.dto.ScWs;
import cn.sky.test.webservice.client.scws.dto.Schoole;
import cn.sky.test.webservice.client.scws.dto.Space;
import cn.sky.test.webservice.client.scws.dto.SpaceResponse;
import cn.sky.test.webservice.client.scws.dto.Student;

public class Client {
	private static Logger logger = LoggerFactory.getLogger(Client.class);

	public static void callhub() {
		String wsdlUrl = "http://localhost:9090/base-web/ws/Hub?wsdl";

		SoapEntity<Head, Msg> request = new SoapEntity<Head, Msg>(Head.class, Msg.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		Msg msg = new Msg();
		msg.setMsg("黎明");
		request.setBody(msg);
		try {
			SoapEntity<Head, MsgResponse> response = new SoapEntity<Head, MsgResponse>(Head.class, MsgResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			System.out.println(response.getBody().getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void callScWs() {
		String wsdlUrl = "http://localhost:9090/base-web/ws/ScWs?wsdl";

		SoapEntity<Head, Space> request = new SoapEntity<Head, Space>(Head.class, Space.class);
		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		Space space = new Space();
		Schoole schoole = new Schoole();
		schoole.setName("广东金融大学");
		List<Student> students = new ArrayList<Student>();
		Student gf = new Student();
		gf.setName("高甫");
		gf.setGrades("大四");
		Student.Achievement achievement = new Student.Achievement();
		List<Student.Achievement.Entry> list = new ArrayList<Student.Achievement.Entry>();
		Student.Achievement.Entry entry = new Student.Achievement.Entry();
		entry.setKey("计算机原理");
		entry.setValue("良");
		list.add(entry);
		Student.Achievement.Entry c = new Student.Achievement.Entry();
		c.setKey("C语言编程基础");
		c.setValue("优");
		list.add(c);
		Student.Achievement.Entry j = new Student.Achievement.Entry();
		j.setKey("java Web开发");
		j.setValue("优");
		list.add(j);
		achievement.setEntry(list);
		gf.setAchievement(achievement);
		List<String> teacher = new ArrayList<String>();
		teacher.add("董燕玲");
		teacher.add("吴匡威");
		gf.setTeacher(teacher);
		students.add(gf);

		Student wk = new Student();
		wk.setName("王孔");
		wk.setGrades("大六");

		Student.Achievement achievemen = new Student.Achievement();
		List<Student.Achievement.Entry> list2 = new ArrayList<Student.Achievement.Entry>();
		Student.Achievement.Entry s = new Student.Achievement.Entry();
		s.setKey("市场原理");
		s.setValue("良");
		list2.add(s);
		Student.Achievement.Entry sc = new Student.Achievement.Entry();
		sc.setKey("商场基础");
		sc.setValue("优");
		list2.add(sc);
		achievemen.setEntry(list2);
		wk.setAchievement(achievemen);
		wk.setAchievement(achievemen);
		List<String> teachers = new ArrayList<String>();
		teachers.add("王珂");
		teachers.add("洛克");
		wk.setTeacher(teachers);
		students.add(wk);
		schoole.setStudents(students);
		space.setSchoole(schoole);
		request.setBody(space);
		try {
			SoapEntity<Head, SpaceResponse> response = new SoapEntity<Head, SpaceResponse>(Head.class,
					SpaceResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void callScWsinfo() {
		String wsdlUrl = "http://localhost:9090/ws/ScWs?wsdl";

		SoapEntity<Head, Info> request = new SoapEntity<Head, Info>(Head.class, Info.class);
		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		Info info = new Info();
		info.setUsrId("李高甫");
		request.setBody(info);
		try {
			SoapEntity<Head, InfoResponse> response = new SoapEntity<Head, InfoResponse>(Head.class,
					InfoResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			if (response.getFault() != null) {
				SoapFault fault = response.getFault();
				System.out.println("请求接口错误: " + fault.getFaultcode() + " , " + fault.getFaultstring());
			} else {
				InfoResponse r = response.getBody();
				System.out.println(r.getInfo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void soapXmlToEntity() throws Exception {
		String soapxml = "<?xml version='1.0' encoding='UTF-8' ?><soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:tns='http://webservice.test.sky.cn/'><soapenv:Header><osbappid>ebiz</osbappid><osbappkey>ebizkey</osbappkey></soapenv:Header><soapenv:Body><soapenv:Fault><faultcode>soap:Client</faultcode><faultstring>Error reading XMLStreamReader: Undeclared namespace prefix 'nyxt' at [row,col {unknown-source}]: [9,14]</faultstring></soapenv:Fault><tns:space><schoole><name>广东金融大学</name><students><achievement><entry><key>计算机原理</key><value>良</value></entry><entry><key>C语言编程基础</key><value>优</value></entry><entry><key>java Web开发</key><value>优</value></entry></achievement><grades>大四</grades><name>高甫</name><teacher>董燕玲</teacher><teacher>吴匡威</teacher></students><students><achievement><entry><key>市场原理</key><value>良</value></entry><entry><key>商场基础</key><value>优</value></entry></achievement><grades>大六</grades><name>王孔</name><teacher>王珂</teacher><teacher>洛克</teacher></students></schoole></tns:space></soapenv:Body></soapenv:Envelope>";
		SoapEntity<Head, Space> soapEntity = new SoapEntity<Head, Space>(Head.class, Space.class);
		soapEntity.init(soapxml);
		if (soapEntity.getHead() != null) {
			System.out.println("soapEntity head: " + soapEntity.getHead().getOsbappid());
		}
		if (soapEntity.getBody() != null) {
			System.out.println("soapEntity body: " + soapEntity.getBody().getSchoole().getName());
		}
		if (soapEntity.getFault() != null) {
			System.out.println("soapEntity fault: " + soapEntity.getFault().getFaultcode());
		}
		System.out.println(soapEntity.soapXml() + "\n");
		soapEntity.init(soapEntity.soapXml());
		if (soapEntity.getHead() != null) {
			System.out.println("soapEntity head: " + soapEntity.getHead().getOsbappid());
		}
		if (soapEntity.getBody() != null) {
			System.out.println("soapEntity body: " + soapEntity.getBody().getSchoole().getName());
		}
		if (soapEntity.getFault() != null) {
			System.out.println("soapEntity fault: " + soapEntity.getFault().getFaultcode());
		}
		System.out.println(soapEntity.soapXml());

	}

	public static void lest() {
		String wsdlUrl = "http://localhost:9090/ws/Hub?wsdl";

		SoapEntity<Head, Lest> request = new SoapEntity<Head, Lest>(Head.class, Lest.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		Lest lest = new Lest();
		lest.setAdaNo("16808");
		request.setBody(lest);
		try {
			SoapEntity<Head, LestResponse> response = new SoapEntity<Head, LestResponse>(Head.class,
					LestResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			System.out.println(response.getBody().getLest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void WSDLToJava(String url) {
		WSDLToJava.main(new String[] { "-client", "-d", "D:/appdata/_ws",
				"http://10.143.173.61:7103/POS_5G_Services_v1_0_0/order/OrderSrv?wsdl" });
		JavaToWS.main(new String[] { "-o", "D:/appdata/_ws/ScWs.wsdl", "-wsdl", ScWs.class.getName() });
	}

	public static void oaWs() {
		String wsdlUrl = "http://10.143.170.128/OA/MSET/webservice/meetingassistantservice.asmx?wsdl";
		//
		SoapEntity<HeadOA, GetAttendinfo> request = new SoapEntity<HeadOA, GetAttendinfo>(HeadOA.class,
				GetAttendinfo.class);
		//
		WsSecurityHeader header = new WsSecurityHeader();
		header.setAppId("amway");
		header.setAppKey("123456");
		HeadOA head = new HeadOA();
		head.setWsSecurityHeader(header);
		request.setHead(head);
		//
		GetAttendinfo getAttendinfo = new GetAttendinfo();
		getAttendinfo.setAdaCard("72216");
		request.setBody(getAttendinfo);
		//
		try {
			SoapEntity<Head, GetAttendinfoResponse> response = new SoapEntity<Head, GetAttendinfoResponse>(Head.class,
					GetAttendinfoResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			int resutl = response.getBody().getGetAttendinfoResult().getResult();
			System.out.println(resutl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pos5g() {
		String wsdlUrl = "http://10.143.173.61:7103/POS_5G_Services_v1_0_0/distributor/DistributorSrv?wsdl";

		SoapEntity<Head, QueryCouponAuthorization> request = new SoapEntity<Head, QueryCouponAuthorization>(Head.class,
				QueryCouponAuthorization.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		QueryCouponAuthorization queryCouponAuthorization = new QueryCouponAuthorization();
		QueryCouponAuthorizationReq queryCouponAuthorizationReq = new QueryCouponAuthorizationReq();
		// 固定值
		queryCouponAuthorizationReq.setCurrencyCode("RMB");
		queryCouponAuthorizationReq.setLocale("zh_CN");
		queryCouponAuthorizationReq.setRegionCode("360");
		queryCouponAuthorizationReq.setChannel("HUB");
		//
		queryCouponAuthorizationReq.setAuthorizeToAda(16808L);
		queryCouponAuthorizationReq.setDistributorNumber(72216L);
		queryCouponAuthorization.setArg0(queryCouponAuthorizationReq);
		request.setBody(queryCouponAuthorization);
		try {
			SoapEntity<Head, QueryCouponAuthorizationResponse> response = new SoapEntity<Head, QueryCouponAuthorizationResponse>(
					Head.class, QueryCouponAuthorizationResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			System.out.println(response.getBody().getReturn().getResultCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ebiz() {
		String wsdlUrl = "http://10.143.173.61:7103/EB_Ebiz_Services/bizprocess/RenewalSrv_v1_0_0?wsdl";

		SoapEntity<Head, GetNewestApplication> request = new SoapEntity<Head, GetNewestApplication>(Head.class,
				GetNewestApplication.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		GetNewestApplication getNewestApplication = new GetNewestApplication();
		getNewestApplication.setAda(72216L);
		request.setBody(getNewestApplication);
		try {
			SoapEntity<Head, GetNewestApplicationResponse> response = new SoapEntity<Head, GetNewestApplicationResponse>(
					Head.class, GetNewestApplicationResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			System.out.println(response.getBody().getRenewalApply().getReturnCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ecard() {
		String wsdlUrl = "http://10.143.174.105:7003/amway-ecard-hub/ECardService?wsdl";

		SoapEntity<Head, VerifyAdaCardAuthorization> request = new SoapEntity<Head, VerifyAdaCardAuthorization>(
				Head.class, VerifyAdaCardAuthorization.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		VerifyAdaCardAuthorization verifyAdaCardAuthorization = new VerifyAdaCardAuthorization();
		QRCodeDTO qrCodeDTO = new QRCodeDTO();
		qrCodeDTO.setTwoDimensionCode("lgf");
		verifyAdaCardAuthorization.setArgs(qrCodeDTO);
		request.setBody(verifyAdaCardAuthorization);
		try {
			SoapEntity<Head, VerifyAdaCardAuthorizationResponse> response = new SoapEntity<Head, VerifyAdaCardAuthorizationResponse>(
					Head.class, VerifyAdaCardAuthorizationResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
			System.out.println(response.getBody().getAuthVerificationResultDTO().getAuthVerificationResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ecardMeetingTicketDelete() {
		String wsdlUrl = "http://10.143.174.105:7003/amway-ecard-hub/ECardService?wsdl";

		SoapEntity<Head, MeetingTicketDelete> request = new SoapEntity<Head, MeetingTicketDelete>(Head.class,
				MeetingTicketDelete.class);

		MeetingTicketDelete MeetingTicketDelete = new MeetingTicketDelete();
		request.setBody(MeetingTicketDelete);
		try {
			SoapEntity<Head, MeetingTicketDeleteResponse> response = new SoapEntity<Head, MeetingTicketDeleteResponse>(
					Head.class, MeetingTicketDeleteResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ecardOSBMeetingTicketDelete() {
		String wsdlUrl = "http://10.143.173.61:7103/DA_Ecard_Services_v1_0_0/ECardUat/AmwayEcardHubU?wsdl";

		SoapEntity<Head, MeetingTicketDelete> request = new SoapEntity<Head, MeetingTicketDelete>(Head.class,
				MeetingTicketDelete.class);
		Head head = new Head();
		head.setOsbappid("pos5g");
		head.setOsbappkey("amway123");
		request.setHead(head);
		//
		MeetingTicketDelete MeetingTicketDelete = new MeetingTicketDelete();
		request.setBody(MeetingTicketDelete);
		try {
			SoapEntity<Head, MeetingTicketDeleteResponse> response = new SoapEntity<Head, MeetingTicketDeleteResponse>(
					Head.class, MeetingTicketDeleteResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * AEC杂项单冲销(cancelMiscOrder)
	 * 
	 * @param orderVo
	 * @return
	 * @throws Exception
	 */
	public static CancelMiscOrderResponse cancelMiscOrder() throws Exception {
		String wsdlUrl = "http://10.143.173.61:7103/POS_5G_Services_v1_0_0/order/OrderSrv?wsdl";

		SoapEntity<Head, CancelMiscOrder> request = new SoapEntity<Head, CancelMiscOrder>(Head.class,
				CancelMiscOrder.class);
		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);
		//
		CancelMiscOrder cancelMiscOrder = new CancelMiscOrder();
		CancelMiscOrderReq cancelMiscOrderReq = new CancelMiscOrderReq();
		// 固定值
		cancelMiscOrderReq.setCurrencyCode("RMB");
		cancelMiscOrderReq.setLocale("zh_CN");
		cancelMiscOrderReq.setRegionCode("360");
		cancelMiscOrderReq.setChannel("HUB");
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD HH:mm:SS");
		cancelMiscOrderReq.setPayDate(format.format(new Date()));
		cancelMiscOrderReq.setMiscOrderNumber("MM170250007753");
		//
		cancelMiscOrder.setArg0(cancelMiscOrderReq);
		request.setBody(cancelMiscOrder);
		//
		SoapEntity<Head, CancelMiscOrderResponse> response = new SoapEntity<Head, CancelMiscOrderResponse>(Head.class,
				CancelMiscOrderResponse.class);
		try {
			SoapClient.execute(wsdlUrl, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getBody();
	}

	public static void ecardMeetingTicketCreated() {
		String wsdlUrl = "http://localhost:8080/amway-ecard-hub/ECardService?wsdl";

		SoapEntity<Head, MeetingTicketCreated> request = new SoapEntity<Head, MeetingTicketCreated>(Head.class,
				MeetingTicketCreated.class);

		Head head = new Head();
		head.setOsbappid("ebiz");
		head.setOsbappkey("ebizkey");
		request.setHead(head);

		MeetingTicketCreated meetingTicketCreated = new MeetingTicketCreated();
		List<ActivityTicketDTO> list = new ArrayList<ActivityTicketDTO>();
		ActivityTicketDTO dto = new ActivityTicketDTO();
		dto.setAdaNo("12748474");
		dto.setAdaRegionNo("360");
		dto.setInstructions(
				"动力工作坊是公司专门为高级主任及以上营销骨干搭建的纯经验交流平台。主题为“跑在第一线，泡在最基层”的首期动力工作坊启动在即，特邀一线资深领导人—营销总监 张刚 先生带来“领导人该如何做好一线工作”的主题经验分享。与此同时，他山之石可以攻玉，分公司将为您展示全国优秀体验活动成功案例及经验总结，帮助大家践行体验战略，助力市场倍增，期待与您一起在交流和思考中共同成长！日期：2017年4月3日（星期一）时间10:00-12:00（上、下午内容相同）地点：河东店铺二楼会议室;票价：5元/张。本次会议仅限业绩截至2016年12月符合高级主任及以上人员单户籍本人出席，会议当日请凭电子票、安利卡、身份证原件签到，非本人谢绝入场。");
		dto.setIsRealName("1");
		dto.setMeetingId("6378fe70-25ac-4b0d-a5e0-dc45b839a78e");
		dto.setMeetingLocation("天津市河东区海河东路951号安利天津分公司");
		dto.setMeetingName("动力工作坊—暨天津地区营销骨干经验交流会-下午场");
		dto.setMeetingNo("MS170301333");
		dto.setMeetingTimeFrom("2017-04-03 14:00:00");
		dto.setMeetingTimeTo("2017-04-03 16:00:00");
		dto.setPayType("1");
		dto.setPointsPrice(0);
		dto.setSeatNo("");
		dto.setTicketNo("1703013331274847400");
		dto.setTicketPrice(5);
		dto.setTicketTimeOfExpiry("2017-04-05 16:00:00");
		dto.setTicketTimeOfUse("");
		dto.setTicketType("1");
		list.add(dto);

		meetingTicketCreated.setList(list);
		request.setBody(meetingTicketCreated);
		try {
			SoapEntity<Head, MeetingTicketCreatedResponse> response = new SoapEntity<Head, MeetingTicketCreatedResponse>(
					Head.class, MeetingTicketCreatedResponse.class);
			SoapClient.execute(wsdlUrl, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		logger.info("start!");
		for (int i = 0; i < 1; i++) {
			callhub();
		}
		logger.info("end!");
	}
}
