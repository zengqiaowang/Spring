/**   
 * 类名：BeanRefTest
 *
 */
package com.cybbj.resourcce.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybbj.resourcce.bean.Boss;
import com.cybbj.resourcce.bean.Car;
import com.cybbj.resourcce.bean.ChildBoss;
import com.cybbj.resourcce.bean.replaceMethod.Boss1;
import com.cybbj.service.injectfun.MagicBoss;

/** 
 * BeanRefTest: bean对象引用测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建 
 */
public class BeanRefTest {
	
	@Test
	public void testRefBean() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Boss boss = (Boss) applicationContext.getBean("boss");
		Car car = boss.getCar();
		System.out.println(car);
	}
	
	//引用父bean 属性
	@Test
	public void testRefParentBean() {
		ApplicationContext parentContext = new ClassPathXmlApplicationContext("parentBean.xml");
		ApplicationContext childContext = new ClassPathXmlApplicationContext(new String[]{"childBean.xml"}, parentContext);
		Boss boss = (Boss)childContext.getBean("boss");
		Car car = boss.getCar();
		car.introduce();
	}
	
	//内部bean测试
	@Test
	public void testInnerBean() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("childBean.xml");
		Boss boss = (Boss)applicationContext.getBean("boss1");
		Car car = boss.getCar();
		car.introduce();
	}
	
	//List 集合测试
	@Test
	public void testSetListValue() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Boss boss = (Boss) applicationContext.getBean("boss");
		System.out.println(boss.getFavorite().toString());
	}
	
	//Map 集合测试
	@Test
	public void testSetMapValue() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Boss boss = (Boss)applicationContext.getBean("boss");
		System.out.println(boss.getJobMap().get("job1") + "\t" + boss.getJobMap().get("job2"));
	}
	
	//Properties 集合测试
	@Test
	public void tesSettPropertiesValue() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Boss boss = (Boss)applicationContext.getBean("boss");
		System.out.println(boss.getProperties().getProperty("mail1") + "\t" + boss.getProperties().getProperty("mail2"));
	}
	
	//集合合并测试
	@Test
	public void testRefParentList() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ChildBoss childBoss = (ChildBoss)applicationContext.getBean("childBoss");
		System.out.println(childBoss);
		System.out.println(childBoss.getFavorite().toString());
	}
	
	//util命名空间测试
	@Test
	public void testUtilName() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		List favoriteList = (List)applicationContext.getBean("favoriteList");
		System.out.println(favoriteList.toString());
	}
	
	//通过 lookup-method 实现每次bean对象都是新的
	@Test
	public void testEveryNewBean() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		MagicBoss magicBoss1 = (MagicBoss)applicationContext.getBean("magicBoss");
		MagicBoss magicBoss2 = (MagicBoss)applicationContext.getBean("magicBoss");
		System.out.println(magicBoss1.getCar().toString());
		System.out.println(magicBoss2.getCar().toString());
	}
	
	//替换其它人的bean
	@Test
	public void replaceOtherBean() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Boss1 boss1 = (Boss1)applicationContext.getBean("boss1");
		Car car = boss1.getCar();
		System.out.println(car.getBrand() + "\t" + car.getColor() + "\t" + car.getMaxSpeed());
	}
	
	//继承
	@Test
	public void testInherit() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Car car2 = (Car)applicationContext.getBean("car2");
		Car car3 = (Car)applicationContext.getBean("car3");
		car2.introduce();
		car3.introduce();
	}
}
