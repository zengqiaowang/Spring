/**   
 * 类名：User
 *
 */
package com.cybbj.domain;

import java.io.Serializable;

/** 
 * User: t_user表对应对象
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String passWord;
	private int credits;
	private String lastVisit;
	private String lastIp;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	
	
}
