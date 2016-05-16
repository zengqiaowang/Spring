/**   
 * 类名：AspectJProxyTest
 *
 */
package com.cybbj.aop.aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybbj.aop.NaiveWaiter;
import com.cybbj.aop.Waiter;

/** 
 * AspectJProxyTest: AspepctJProxyFactory测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-11 v1.0 15989 新建 
 */
public class AspectJProxyTest {

	@Test
	public void testPreGreetingAspect() {
		Waiter target = new NaiveWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标
		factory.setTarget(target);
		//添加切面类
		factory.addAspect(PreGreetingAspect.class);
		//生成植入切面的代理对象
		Waiter proxy = factory.getProxy();
		proxy.greetTo("Jhon");
		proxy.serveTo("Jhon");
	}
	
	@Test
	public void testXMLConfigAspectJ() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspectJBeans.xml");
		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
		waiter.greetTo("Tom");
		waiter.serveTo("Tom");
	}
}
