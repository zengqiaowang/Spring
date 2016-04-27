/**   
 * 类名：AnnotationApplicationContext
 *
 */
package com.cybbj.resourcce.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cybbj.reflect.domain.Car;
import com.cybbj.resourcce.bean.Beans;

/** 
 * AnnotationApplicationContext: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-22 v1.0 15989 新建 
 */
public class AnnotationApplicationContextTest {
	
	@Test
	public void annotationApplicationContext(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Beans.class);
		Car oCar = applicationContext.getBean("car2", Car.class);
		oCar.introduce();
	}
}
