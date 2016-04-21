/**   
 * 类名：NormalCar
 *
 */
package com.cybbj.reflect.service;

import org.junit.Assert;
import org.junit.Test;

import com.cybbj.reflect.domain.Car;

/** 
 * NormalCar: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-21 v1.0 15989 新建 
 */
public class NormalCar {
	
	@Test
	public void setBrand() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		Assert.assertEquals(car.getBrand(), "红旗CA72");
	}
}
