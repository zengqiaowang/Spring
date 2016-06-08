/**   
 * 类名：User
 *
 */
package com.cybbj.springmvc.pojo;

/**
 * User: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建
 */
public class User {
	private String userName;

	private String userPwd;

	private String name;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "userName: " + this.userName + "\t userPwd: " + userPwd + "\t name: " + name;
	}

}
