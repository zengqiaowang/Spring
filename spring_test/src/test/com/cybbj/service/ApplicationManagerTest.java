/**   
 * 类名：ApplicationManagerTest
 *
 */
package com.cybbj.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * ApplicationManagerTest: 应用管理测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-28 v1.0 15989 新建 
 */
public class ApplicationManagerTest {
	
	private ApplicationContext applicationContext = null;
	
	@Before
	public void loadPropertyFile() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testGetSessionTimeout() {
		ApplicationManager applicationManager = (ApplicationManager)applicationContext.getBean("applicationManager");
		System.out.println(applicationManager.getMaxTabPageNum());
		System.out.println(applicationManager.getSessionTimeout());
	}
}
