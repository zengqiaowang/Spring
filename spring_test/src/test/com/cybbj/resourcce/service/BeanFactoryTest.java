/**   
 * 类名：BeanFactoryTest
 *
 */
package com.cybbj.resourcce.service;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.cybbj.reflect.domain.Car;

/** 
 * BeanFactoryTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-22 v1.0 15989 新建 
 */
public class BeanFactoryTest {
	
	@Test
	public void getResource() {
		//BeanFactory 测试
	/*	ResourcePatternResolver oResolver = new PathMatchingResourcePatternResolver();
		Resource oResource = oResolver.getResource("classpath:beans.xml");
		BeanFactory oBeanFactory = new XmlBeanFactory(oResource);
		Car oCar = oBeanFactory.getBean("car1", Car.class);
		System.out.println(oCar);
		oCar.introduce();*/
		
		//ClassPathXmlApplicationContext 测试
/*		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Car oCar = applicationContext.getBean("car1", Car.class);
		System.out.println(oCar);*/
		
		//FileSystemXmlApplicationContext 测试
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repository/github/Spring/spring_test/src/conf/beans.xml");
		Car oCar = applicationContext.getBean("car1", Car.class);
		oCar.introduce();
	}
}
