/**   
 * 类名：TestUserService
 *
 */
package com.cybbj.transaction.togethernest;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * TestUserService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-24 v1.0 15989 新建 
 */
public class TestUserService {

	@Test
	public void logonTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.logon("admin");
	}
	
	@Test
	public void getKeyIdTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		System.out.println(userService.getKeyId());
	}
	
	@Test
	public void batchInsertTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.batchInsert();
	}
	
	@Test
	public void queryMapTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.queryForRowCallbackHandler();
	}
	
	@Test
	public void queryForRowMapperTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		List<Map<String, String>> oList = userService.queryForRowMapper();
		System.out.println(oList.size());
	}
	
	@Test
	public void RowCountCallbackHandlerTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		System.out.println(userService.RowCountCallbackHandler());
	}
	
}
