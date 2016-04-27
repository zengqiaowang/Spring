/**   
 * 类名：Boss1
 *
 */
package com.cybbj.resourcce.bean.replaceMethod;

import com.cybbj.resourcce.bean.Car;

/** 
 * Boss1: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-26 v1.0 15989 新建 
 */
public class Boss1 {
	public Car getCar() {
		Car car = new Car();
		car.setBrand("宝马");
		car.setColor("白色");
		car.setMaxSpeed(300);
		return car;
	}
}
