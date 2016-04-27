/**   
 * 类名：Beans
 *
 */
package com.cybbj.resourcce.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cybbj.reflect.domain.Car;

/** 
 * Beans: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-22 v1.0 15989 新建 
 */
//表示是一个配置信息提供类
@Configuration
public class Beans {
	
	@Bean(name="car2")
	public Car buildCar() {
		Car oCar = new Car();
		oCar.setBrand("法拉利");
		oCar.setColor("花色");
		oCar.setMaxSpeed(600);
		return oCar;
	}
}
