/**   
 * 类名：LoginLog
 *
 */
package com.cybbj.domain;

import java.io.Serializable;

/** 
 * LoginLog: t_login_log表对应实例
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
public class LoginLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int loginLogId;
	private int userId;
	private String ip;
	private String loginDateTime;
	
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

}
