/**   
 * 类名：TestFlowAdvisor
 *
 */
package com.cybbj.aop.flowpointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybbj.aop.staticpointcut.Waiter;

/** 
 * TestFlowAdvisor: 测试流程切面
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-9 v1.0 15989 新建 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})
public class TestFlowAdvisor {
	
	@Autowired
	@Qualifier(value="waiter")
	private Waiter waiter;
	
	@Test
	public void testWaiterDelegate() {
		WaiterDelegate waiterDelegate = new WaiterDelegate();
		waiterDelegate.setWaiter(this.waiter);
		waiter.greetTo("张三");
		waiter.serverTo("李四");
		waiterDelegate.service("王五");
	}
}
