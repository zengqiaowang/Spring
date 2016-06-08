/**   
 * 类名：LoginLog
 *
 */
package com.cybbj.xmlandbean;

import java.util.Date;

/** 
 * LoginLog: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建 
 */
public class LoginLog {
	private String ip;
	private Date loginDate;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
}
