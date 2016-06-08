/**   
 * 类名：User
 *
 */
package com.cybbj.xmlandbean;

/**
 * User: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建
 */
public class User {
	private int userId;

	private String userName;

	private LoginLog loginLog;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginLog getLoginLog() {
		return loginLog;
	}

	public void setLoginLog(LoginLog loginLog) {
		this.loginLog = loginLog;
	}

}
