/**   
 * 类名：Boss2
 *
 */
package com.cybbj.resourcce.bean.replaceMethod;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import com.cybbj.resourcce.bean.Car;

/** 
 * Boss2: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-26 v1.0 15989 新建 
 */
public class Boss2 implements MethodReplacer{

	/** (非 Javadoc) 
	* @param arg0
	* @param arg1
	* @param arg2
	* @return
	* @throws Throwable 
	* @see org.springframework.beans.factory.support.MethodReplacer#reimplement(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) 
	*/
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		Car car = new Car();
		car.setBrand("奔驰");
		car.setColor("黑色");
		car.setMaxSpeed(400);
		return car;
	}
}
