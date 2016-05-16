/**   
 * 类名：TestAdvisor
 *
 */
package com.cybbj.aop.dynamicpointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybbj.aop.staticpointcut.Waiter;

/** 
 * TestAdvisor: 测试类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-7 v1.0 15989 新建 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})
public class TestAdvisor {
	
	@Autowired
	@Qualifier(value="waiter")
	private Waiter waiter;
	
	@Test
	public void testDynamicAdvisor() {
		waiter.greetTo("Tom");
		waiter.serverTo("Tom");
	}
}
