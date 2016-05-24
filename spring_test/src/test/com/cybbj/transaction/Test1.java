/**   
 * 类名：Test1
 *
 */
package com.cybbj.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * Test1: 测试类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-24 v1.0 15989 新建 
 */
public class Test1 {

	@Test
	public void testConfigFile() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		applicationContext.getBean("txManager");
	}
}
