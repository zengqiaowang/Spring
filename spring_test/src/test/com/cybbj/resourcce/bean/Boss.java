/**   
 * 类名：Boss
 *
 */
package com.cybbj.resourcce.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Boss: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建
 */
@Component(value="boss")
public class Boss {

	@Autowired
	@Qualifier(value="car")
	private Car car;

	private String cellPhoneBrand;

	private List<String> favorite = new ArrayList<String>();

	private Map<String, String> jobMap = new HashMap<String, String>();

	private Properties properties = new Properties();

	public Boss() {
		System.out.println(">>>boss constructor");
	}
	//用于测试方法替换
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCellPhoneBrand() {
		return cellPhoneBrand;
	}

	public void setCellPhoneBrand(String cellPhoneBrand) {
		this.cellPhoneBrand = cellPhoneBrand;
	}

	public List<String> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<String> favorite) {
		this.favorite = favorite;
	}

	public Map<String, String> getJobMap() {
		return jobMap;
	}

	public void setJobMap(Map<String, String> jobMap) {
		this.jobMap = jobMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println(">>>初始化方法,注解为@PostConstruct");
	}
	
	@PreDestroy
	public void finishDestroy() {
		System.out.println(">>>执行销毁方法,注解为@PreDestroy");
	}

}
