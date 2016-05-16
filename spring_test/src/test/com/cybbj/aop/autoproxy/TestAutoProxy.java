/**   
 * 类名：TestAutoProxy
 *
 */
package com.cybbj.aop.autoproxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybbj.aop.staticpointcut.Seller;
import com.cybbj.aop.staticpointcut.Waiter;

/** 
 * TestAutoProxy: 测试自动代理
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-10 v1.0 15989 新建 
 */
public class TestAutoProxy {

	@Test
	public void testBeanNameAutoProxyCreator() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
		Seller seller = (Seller)applicationContext.getBean("seller");
		waiter.greetTo("张三");
		waiter.serverTo("李四");
		seller.greetTo("王五");
	
	}
	
	@Test
	public void testDefaultAdvisorAutoProxyCreator() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
		Seller seller = (Seller)applicationContext.getBean("seller");
		waiter.greetTo("张三");
		waiter.serverTo("李四");
		seller.greetTo("王五");
	}
}
