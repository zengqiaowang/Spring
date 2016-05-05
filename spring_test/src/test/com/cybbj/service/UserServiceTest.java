/**   
 * 类名：UserServiceTest
 *
 */
package com.cybbj.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybbj.domain.User;

/** 
 * UserServiceTest: UserService类测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-16 v1.0 15989 新建 
 */
@RunWith(SpringJUnit4ClassRunner.class)  //基于JUnit4的spring测试框架
@ContextConfiguration(locations={"/applicationContext.xml"})  //启动spring容器
public class UserServiceTest {
	
	//注入spring容器中的bean
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//标注测试方法
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "123");
		Assert.assertTrue(b1);
		Assert.assertTrue(b2);
	}
	
	@Test
	public void findUserByUserName() {
		User user = userService.findUserByUserName("admin");
		Assert.assertEquals(user.getUserName(), "admin");
	}
	
	@Test
	public void loginSuccess() {
		User user = new User();
		user.setUserId(2);
		user.setUserName("admin");
		user.setPassWord("123456");
		user.setLastVisit("admin");
		user.setLastIp("192.168.1.111");
		user.setCredits(15);
		userService.loginSuccess(user);
	}
}
