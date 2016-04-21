/**   
 * 类名：ReflectCar
 *
 */
package com.cybbj.reflect.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.cybbj.reflect.domain.Car;

/** 
 * ReflectCar: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-21 v1.0 15989 新建 
 */
public class ReflectCar {
	
	public Car initByDefaultConst() throws Exception {
		//通过类装载器获取Car类对象
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class clazz = classLoader.loadClass("com.cybbj.reflect.domain.Car");
		//获取类的默认构造器对象并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car) cons.newInstance();
		//通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 200);
		return car;
	}
	
	@Test
	public void testInitByDefaultConst () throws Exception {
		Car car = initByDefaultConst();
		car.introduce();
	}
	
	@Test
	public void testClassLoader() {
		ClassLoader clazzLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(" current ClassLoader:" + clazzLoader);
		System.out.println(" parent ClassLoader：" + clazzLoader.getParent());
		System.out.println(" grandparent ClassLoader:" + clazzLoader.getParent().getParent());
	}
}
