package cn.sky.meile.system.authority.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.rest.RestMessage;
import cn.sky.framework.util.ServletUtil;
import cn.sky.meile.system.authority.dto.LoginDto;
import cn.sky.meile.system.authority.service.AuthorityService;
import cn.sky.meile.system.authority.vo.AuthorityItem;
import cn.sky.meile.system.authority.vo.UserVo;
import cn.sky.meile.system.verify.controller.VerifyCodeController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("权限接口")
@RestController
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;

	@ApiOperation(value = "登录", notes = "{'entity': {'password': 'abc','username': 'kity','verifyCode': 'at2k'}}")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestMessage<String> login(@RequestBody RestMessage<LoginDto> requestDto) {
		RestMessage<String> reponseDto = new RestMessage<String>();

		HttpSession httpSession = ServletUtil.getSession();
		LoginDto loginDto = requestDto.getEntity();
		// 验证码校验
		String verifyCode = loginDto.getVerifyCode();
		if (!VerifyCodeController.checkVerifyCode(verifyCode)) {
			reponseDto.setFaultstring("验证码错误");
			return reponseDto;
		}
		//
		String username = loginDto.getUsername();
		String password = loginDto.getPassword();
		if (username == null || password == null) {
			reponseDto.setFaultstring("用户名或密码错误");
			return reponseDto;
		}
		UserVo user = new UserVo();
		user.setUsername(username);
		user.setPassword(password);
		if (authorityService.login(user)) {
			httpSession.setAttribute(AuthorityItem.loginUserName, username);
			reponseDto.setSuccess(true);
			return reponseDto;
		} else {
			httpSession.setAttribute(AuthorityItem.loginUserName, null);
			reponseDto.setFaultstring("未登录");
			return reponseDto;
		}
	}

	@ApiOperation(value = "注销", notes = "")
	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public void logout() {
		HttpSession httpSession = ServletUtil.getSession();
		httpSession.setAttribute(AuthorityItem.loginUserName, null);
	}

	@ApiOperation(value = "获取用户信息", notes = "")
	@RequestMapping(value = "/loadUser", method = { RequestMethod.POST, RequestMethod.GET })
	public RestMessage<String> loadUser() {
		RestMessage<String> responeDto = new RestMessage<String>();
		HttpSession httpSession = ServletUtil.getSession();
		String userName = (String) httpSession.getAttribute(AuthorityItem.loginUserName);
		if (userName == null || userName.length() == 00) {
			responeDto.setFaultstring("未登录");
			return responeDto;
		}
		responeDto.setSuccess(true);
		responeDto.setEntity(userName);
		return responeDto;
	}
}
