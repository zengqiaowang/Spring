/**   
 * 类名：LogonService
 *
 */
package com.cybbj.domain.annotation;

/**
 * LogonService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-27 v1.0 15989 新建
 */
public class LogonService {
	private UserDao userDao;

	private LogDao logDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

}
