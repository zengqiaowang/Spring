/**   
 * 类名：MailSenderTest
 *
 */
package com.cybbj.applicationContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * MailSenderTest: MailSender测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class MailSenderTest {
	
	@Test
	public void testSendMail() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
		MailSender mailSender = (MailSender)applicationContext.getBean("mailSender");
		mailSender.sendMail("123@163.com");
	}
}
