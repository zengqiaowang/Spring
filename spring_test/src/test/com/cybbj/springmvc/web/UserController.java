/**   
 * 类名：UserController
 *
 */
package com.cybbj.springmvc.web;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cybbj.springmvc.pojo.User;
import com.cybbj.springmvc.service.UserService;

/** 
 * UserController: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建 
 */
@Controller   //使UserController为处理请求的控制器
@RequestMapping(value="/user")   //处理来自 /user   URI的处理请求
@SessionAttributes(value="user") 
//会自动将本处理器中任何处理方法属性名为user的模型属性透明地存储到HttpSession中
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	
	//处理/user的请求,不过请求的方法必须为post
	//user入参说明：将表单值映射到User对象中，调用UserService保存user，返回ModelAndView
	@RequestMapping(method=RequestMethod.POST,value="/createUser")
	public ModelAndView createUser(User user) {
		userService.createUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/createSuccess");
		mav.addObject("user", user);
		return mav;
	}
	
	/**
	 * 通过@RequestParam可以将URL中的占位符参数绑定到控制器处理方法的入参中
	 * createUser2: TODO
	 *
	 * @param userName
	 * @param userPwd
	 * @param name
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createUser2(@RequestParam(value="userName") String userName,
			@RequestParam(value="userPwd") String userPwd,@RequestParam(value="name") String name) {
		System.out.println(">>>userName: " + userName + "\t" + ">>>userPwd: " + userPwd + "\t" + ">>>name: " + name);
		User user = new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setName(name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/createSuccess");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="/receiImage")
	public void receiImage(OutputStream os) {
		Resource resource = new ClassPathResource("/image.jpg");
		try {
			FileCopyUtils.copy(resource.getInputStream(), os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * xmlToUserToXml: 测试xml转User，User转xml
	 *
	 * @param requestEntity  HttpEntity
	 * @return ResponseEntity
	 */
	@RequestMapping(value="/xmlToUserToXml")
	public ResponseEntity<User> xmlToUserToXml(HttpEntity<User> requestEntity) {
		User user = requestEntity.getBody();
		System.out.println(user.toString());
		user.setName("xmlToUserToXml");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * 
	 * jsonToUserToJson: 测试json转User，User转json
	 *
	 * @param requestEntity  HttpEntity
	 * @return ResponseEntity
	 */
	@RequestMapping(value="/jsonToUserToJson")
	public ResponseEntity<User> jsonToUserToJson(HttpEntity<User> requestEntity) {
		User user = requestEntity.getBody();
		System.out.println(user.toString());
		user.setName("jsonToUserToJson");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * 
	 * testModelAttribute: 测试使用@ModelAttribute往返回的模型中设置值
	 *
	 * @param user User对象
	 * @return 模型与视图
	 */
	@RequestMapping(value="testModelAttribute")
	public String testModelAttribute(@ModelAttribute User user) {
		user.setName("方法体内替换值成功");
		return "user/createSuccess";
	}
	
	@ModelAttribute(value="user")
	public User getUser() {
		User user = new User();
		user.setUserName("zengqw");
		return user;
	}
	
	/**
	 * 
	 * testModelMap: 测试ModelMap
	 * 	
	 * @param modelMap  ModelMap
	 * 		可以通过ModelMap带进入参数据
	 * @return user/createSuccess
	 * 		返回值中，不只是有视图逻辑，也会通过ModelMap带模型数据
	 */
	@RequestMapping(value="testModelMap")
	public String testModelMap(ModelMap modelMap) {
		modelMap.addAttribute("testAttr", "value1");
		User user = (User)modelMap.get("user");
		user.setName("zengqiaowang");
		return "user/createSuccess";
	}
	
	@RequestMapping(value="/testSessionAttributes1")
	public String testSessionAttributes1(@ModelAttribute("user") User user) {
		user.setUserName("John");
		//它将发起另一个请求，而这个请求由testSessionAttributes2负责处理。
		/**
		 * testSessionAttributes1()与testSessionAttributes2位于不同的请求上下文中，
		 * testSessionAttributes2中之所以能够获取名为user的模型属性，就是因为@SessionAttributes("user")
		 * 透明地将testSessionAttributes1()的user模型属性存储到HttpSession中，而testSessionAttributes2()
		 * 的隐含模型又自动从HttpSession中获取到这个模型属性的缘故
		 */
		return "redirect:/user/testSessionAttributes2.html";
	}
	
	@RequestMapping(value="/testSessionAttributes2")
	public String testSessionAttributes2(ModelMap modelMap,SessionStatus sessionStatus) {
		//读取模型中的数据
		User user = (User)modelMap.get("user");
		if (user != null) {
			user.setUserName("Jetty");
			//让SpringMVC清除本处理器对应的会话属性
			sessionStatus.setComplete();
		}
		return "user/createSuccess";
	}
	
}
