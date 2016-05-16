/**   
 * 类名：TestClass
 *
 */
package com.cybbj.aop.aspectj.declareparents;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * TestClass: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-12 v1.0 15989 新建 
 */
public class TestClass {

	@Test
	public void testEnableSellerAspect() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspectJBeans.xml");
		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
		waiter.greetTo("Tom");
		waiter.serveTo("Tom");
		Seller seller = (Seller)waiter;
		seller.sell("sandwiches");
	}
	
	@Test
	public void testAnnotation() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspectJBeans.xml");
		Waiter naiveWaiter = (Waiter)applicationContext.getBean("naiveWaiter");
		Waiter naughtyWaiter = (Waiter)applicationContext.getBean("naughtyWaiter");
		naiveWaiter.greetTo("tom");
		naiveWaiter.serveTo("tom");
		naughtyWaiter.greetTo("Jhon");
		naughtyWaiter.serveTo("Jhon");
	}
}
