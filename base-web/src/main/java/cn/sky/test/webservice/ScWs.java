package cn.sky.test.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.sky.test.webservice.client.entity.City;
import cn.sky.test.webservice.client.entity.Schoole;

@WebService
@Component
public class ScWs {
	private static Logger logger = LoggerFactory.getLogger(ScWs.class);

	@WebResult(name = "space")
	public City space(@WebParam(name = "schoole") Schoole schoole) {
		Gson gson = new Gson();
		logger.info("接受参数: " + gson.toJson(schoole));
		return City.getCity();
	}

	@WebResult(name = "info")
	public String info(@WebParam(name = "usrId") String usrId) throws Exception {
		if (usrId == null || usrId.length() == 0) {
			throw new Exception("程序异常");
		}
		return "The info of " + usrId + " is mint";
	}
}
