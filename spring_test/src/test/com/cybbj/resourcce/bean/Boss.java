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

/**
 * Boss: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建
 */
public class Boss {

	private Car car = new Car();

	private String cellPhoneBrand;

	private List<String> favorite = new ArrayList<String>();

	private Map<String, String> jobMap = new HashMap<String, String>();

	private Properties properties = new Properties();

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

}
