package cn.sky.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.sky.framework.annotation.AnnotationClassFactory;
import cn.sky.framework.util.ServletUtil;
import cn.sky.framework.util.SpringUtil;
import cn.sky.framework.util.sequence.Sequence;
import cn.sky.test.entity.Test;
import cn.sky.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TestService testService;

	@RequestMapping("/index")
	public String test() {
		logger.info("spring mvc 测试首页");
		return "test";
	}

	@RequestMapping("/query")
	public @ResponseBody String query() {
		logger.info("spring mvc 测试查询数据");
		String json = testService.query();
		//
		logger.info("查询成功!");
		return json;
	}

	@RequestMapping("/delete")
	public @ResponseBody String delete() {
		logger.info("spring mvc 测试删除数据");
		HttpServletRequest request = ServletUtil.getRequest();

		String id = request.getParameter("id");
		if (id == null || id.length() == 0) {
			return "false";
		}

		if (!id.matches("[0-9]+")) {
			return "false";
		}

		boolean rs = testService.delete(id);
		if (!rs) {
			logger.info("删除失败!");
			return "false";
		} else {
			logger.info("删除成功!");
			return "success";
		}
	}

	@RequestMapping("/insert")
	public @ResponseBody String insert() {
		logger.info("spring mvc 测试插入数据");
		HttpServletRequest request = ServletUtil.getRequest();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (name == null || name.length() == 0 || password == null || password.length() == 0) {
			return "false";
		}
		long id = Sequence.getSequence();
		Test test = new Test();
		test.setId(id);
		test.setName(name);
		test.setPassword(password);

		testService.save(test);

		logger.info("插入成功!");
		return "success";
	}

	@RequestMapping(value = "/jsonInsert", method = RequestMethod.POST)
	public @ResponseBody String jsonInsert(@RequestBody Test test) {
		logger.info("spring mvc 测试插入数据");
		Gson gson = new Gson();
		logger.info("入参:" + gson.toJson(test));
		long id = Sequence.getSequence();
		test.setId(id);
		testService.save(test);
		logger.info("插入成功!");
		return "success";
	}

	@RequestMapping("/jsonStreamInsert")
	public @ResponseBody String jsonStreamInsert() {
		logger.info("spring mvc 测试插入数据");
		String requestBody = ServletUtil.getRequestBody();
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, String> paramsMap = gson.fromJson(requestBody, Map.class);

		String name = paramsMap.get("name");
		String password = paramsMap.get("password");
		if (name == null || name.length() == 0 || password == null || password.length() == 0) {
			return "false";
		}
		long id = Sequence.getSequence();
		Test test = new Test();
		test.setId(id);
		test.setName(name);
		test.setPassword(password);

		testService.save(test);

		logger.info("插入成功!");
		return "success";
	}

	@RequestMapping("/annotatedClasses")
	public @ResponseBody String annotatedClasses() {
		String json = "";
		Set<Class<?>> classSet;
		try {
			classSet = SpringUtil.getBean(AnnotationClassFactory.class).getAnnotatedClasses();
			for (Class<?> c : classSet) {
				json += c.getName() + ", ";
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		logger.info("annotatedClasses : " + json);
		return json;
	}

	@RequestMapping(value = "/showImg")
	@ResponseBody
	public void showImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			return;
		}
		FileInputStream fileIs = null;
		try {
			fileIs = new FileInputStream("D:/softwaresData/xxx2.jpg");
		} catch (Exception e) {
			logger.error("系统找不到图像文件：D:/softwaresData/xxx2.jpg");
			return;
		}
		int i = fileIs.available(); // 得到文件大小
		byte data[] = new byte[i];
		fileIs.read(data); // 读数据
		response.setContentType("image/*"); // 设置返回的文件类型
		OutputStream outStream = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
		outStream.write(data); // 输出数据
		outStream.flush();
		outStream.close();
		fileIs.close();
	}

}
