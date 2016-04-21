/**   
 * 类名：LoginCommand
 *
 */
package com.cybbj.domain;

import java.io.Serializable;

/** 
 * LoginCommand: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-16 v1.0 15989 新建 
 */
public class LoginCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
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
}
