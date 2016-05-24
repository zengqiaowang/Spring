/**   
 * 类名：TestUserService
 *
 */
package com.cybbj.transaction.togethernest;

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
}
