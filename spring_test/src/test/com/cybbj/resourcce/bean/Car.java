/**   
 * 类名：Car
 *
 */
package com.cybbj.resourcce.bean;

import java.io.Serializable;


/**
 * Car: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-21 v1.0 15989 新建
 */
public class Car implements Serializable{
	/** 
	 * serialVersionUID : TODO请填写变量描述
	 */ 
	private static final long serialVersionUID = 1L;

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


}
