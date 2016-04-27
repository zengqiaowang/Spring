/**   
 * 类名：Car
 *
 */
package com.cybbj.reflect.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Car: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-21 v1.0 15989 新建
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
	private String brand;

	private String color;

	private int maxSpeed;

	// 默认构造函数
	public Car() {

	}

	// 带参数的构造函数
	public Car(String brand, String color, int maxSpeed) {
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	// 未带参的方法
	public void introduce() {
		System.out.println("brand:" + this.brand + ";color:" + this.color + ";maxSpeed:" + this.maxSpeed);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/** (非 Javadoc) 
	* @throws Exception 
	* @see org.springframework.beans.factory.DisposableBean#destroy() 
	*/
	public void destroy() throws Exception {
		System.out.println(">>>destroy()方法");
	}

	/** (非 Javadoc) 
	* @throws Exception 
	* @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet() 
	*/
	public void afterPropertiesSet() throws Exception {
		System.out.println(">>>afterPropertiesSet()方法");
	}

	/** (非 Javadoc) 
	* @param arg0 
	* @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String) 
	*/
	public void setBeanName(String arg0) {
		System.out.println(">>>setBeanName()方法");
	}

	/** (非 Javadoc) 
	* @param arg0
	* @throws BeansException 
	* @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory) 
	*/
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println(">>>setBeanFactory()方法");
	}

}
