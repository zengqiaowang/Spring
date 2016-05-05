/**   
 * 类名：SysConfig
 *
 */
package com.cybbj.util;

import javax.sql.DataSource;

/** 
 * SysConfig: 系统配置
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-28 v1.0 15989 新建 
 */
public class SysConfig {
	private int sessionTimeout;
	private int maxTabPageNum;
	private DataSource dataSource;
	
	/**
	 * 
	 * initFromDB: 模拟从数据库获取配置值并设置相应属性
	 * 
	 */
	public void initFromDB() {
		//模拟从数据库获取配置值
		this.sessionTimeout = 30;
		this.maxTabPageNum = 10;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}

	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
