/**   
 * 类名：LoginController
 *
 */
package com.cybbj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybbj.domain.LoginCommand;
import com.cybbj.domain.User;
import com.cybbj.service.UserService;
import com.cybbj.util.DateUtil;

/** 
 * LoginController: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-16 v1.0 15989 新建 
 */
//标注成为一个springmvc的Controller
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	//负责处理/index.html的请求
	@RequestMapping(value="/index.html")
	public String loginPage() {
		return "login";
	}
	
	//负责处理/loginCheck.html的请求
	@RequestMapping(value="/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassWord());
		if (!isValidUser) {
			//(login 试图逻辑名)    (error 数据模型名称)    (用户名或密码错误 数据模型对象)
			//通过springmvc_test-servlet.xml配置文件解析后的路径为/WEB-INF/jsp/login.jsp
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(DateUtil.getFormatDateStr());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
	
	
}
