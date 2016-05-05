/**   
 * 类名：ApplicationManager
 *
 */
package com.cybbj.service;

/**
 * ApplicationManager: 应用管理
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-28 v1.0 15989 新建
 */
public class ApplicationManager {
	private int sessionTimeout;

	private int maxTabPageNum;

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

}
