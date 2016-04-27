/**   
 * 类名：InjectBoss
 *
 */
package com.cybbj.resourcce.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * InjectBoss: 测试方法注入
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建
 */
public class InjectBoss implements BeanFactoryAware{
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	/** (非 Javadoc) 
	* @param arg0
	* @throws BeansException 
	* @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory) 
	*/
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		
		// TODO Auto-generated method stub
		
	}

}
