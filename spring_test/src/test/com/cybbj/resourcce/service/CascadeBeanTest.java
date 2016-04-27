/**   
 * 类名：CascadeBeanTest
 *
 */
package com.cybbj.resourcce.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybbj.resourcce.bean.Boss;
import com.cybbj.resourcce.bean.Car;

/** 
 * CascadeBeanTest: 级联属性值设置
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建 
 */
public class CascadeBeanTest {
	
	@Test
	public void cascadePropertySet() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascadeBean.xml");
		Boss boss = (Boss)applicationContext.getBean("boss");
		Car car = boss.getCar();
		car.introduce();
	}
}
