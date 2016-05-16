/**   
 * 类名：TestAdvice
 *
 */
package com.cybbj.aop;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * TestAdvice: 测试类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-4 v1.0 15989 新建 
 */
public class TestAdvice {
	
	@Test
	public void testBeforeAdvice() {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		Waiter waiter = (Waiter)factory.getProxy();
		waiter.greetTo("张三");
		waiter.serveTo("李四");
	}
	
	@Test
	public void testXMLBeforeAdvice() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
		waiter.greetTo("张三3");
		waiter.serveTo("李四3");
	}
	
	@Test
	public void testThrowingAdvice() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ForumService forumService = (ForumService)applicationContext.getBean("forumService");
		//forumService.removeForum();
		try {
			//forumService.updateForum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIntroductionInterceptor() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ForumService forumService = (ForumService)applicationContext.getBean("forumService");
		forumService.removeForum(10);
		forumService.updateForum(20);
		
		Monitorable monitorable = (Monitorable)forumService;
		monitorable.setMonitorActive(true);
		forumService.removeForum(30);
		forumService.updateForum(40);
	}
	
	@Test
	public void testPoinCut() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		com.cybbj.aop.staticpointcut.Waiter waiter = (com.cybbj.aop.staticpointcut.Waiter)applicationContext.getBean("waiter");
		//Seller seller = (Seller)applicationContext.getBean("seller");
		waiter.greetTo("张三");
		waiter.serverTo("张三");
		//seller.greetTo("李四");
	}
}
