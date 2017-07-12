package cn.sky.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class HtmlController {
	private static final Logger logger = LoggerFactory.getLogger(HtmlController.class);

	@RequestMapping(value = "/view", method = { RequestMethod.GET, RequestMethod.POST })
	public String getThemes(HttpServletRequest request, HttpServletResponse response) {
		String go = request.getParameter("go");
		String out = request.getParameter("out");
		boolean forward = false;
		try {
			if (go != null && go.length() != 0) {
				request.getRequestDispatcher("/" + go + ".html").forward(request, response);
				logger.info("forward to " + go + ".html");
				forward = true;
			}
		} catch (ServletException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		if (!forward && out != null && out.length() != 0) {
			String data = "<script>window.top.location = '../" + out + ".html'</script>";
			response.setHeader("content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.write(data);
				logger.info("response PrintWriter writer to " + out + ".html");
				forward = true;
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		if (forward) {
			logger.info("return null");
			return null;
		}
		logger.info("return view");
		return "view";
	}

}
