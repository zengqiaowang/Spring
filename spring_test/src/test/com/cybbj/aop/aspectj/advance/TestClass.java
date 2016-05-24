/**   
 * 类名：TestClass
 *
 */
package com.cybbj.aop.aspectj.advance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybbj.aop.aspectj.declareparents.Seller;
import com.cybbj.aop.aspectj.declareparents.Waiter;

/** 
 * TestClass: 测试类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-16 v1.0 15989 新建 
 */
public class TestClass {

	@Test
	public void testAdvanceArround() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("aspectJBeans.xml");
		Waiter naiveWaiter = (Waiter)aContext.getBean("naiveWaiter");
		naiveWaiter.greetTo("Tom");
		naiveWaiter.serveTo("Tom");
		
		Waiter naughtyWaiter = (Waiter)aContext.getBean("naughtyWaiter");
		naughtyWaiter.serveTo("Jhon");
	}
	
	@Test
	public void testAdvanceBindRetVal() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("aspectJBeans.xml");
		Seller smartSeller = (Seller)aContext.getBean("smartSeller");
		smartSeller.sellNum();
		smartSeller.sell("矿泉水");
	}
}
