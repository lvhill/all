package cn.sky.test.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HubService {

	@WebResult(name = "result")
	public String msg(@WebParam(name = "msg") String msg);

	@WebResult(name = "result")
	public String token(@WebParam(name = "token") String token);

	@WebResult(name = "Lest")
	public String Lest(@WebParam(name = "AdaNo") String adaNo);

}