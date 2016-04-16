/**   
 * 类名：UserService
 *
 */
package com.cybbj.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybbj.dao.LoginLogDao;
import com.cybbj.dao.UserDao;
import com.cybbj.domain.LoginLog;
import com.cybbj.domain.User;
import com.cybbj.util.DateUtil;

/** 
 * UserService: 用户业务类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
@Service	//将UserService标注为一个服务层的bean
public class UserService {
	private Log log = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	/**
	 * 
	 * hasMatchUser: 查询是否有用户匹配
	 *
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return true/false
	 */
	public boolean hasMatchUser(String userName,String passWord) {
		int matchCount = 0;
		try {
			matchCount = userDao.getMatchCount(userName, passWord);
		} catch (Exception e) {
			log.error(e);
		}
		return matchCount>0;
	}
	
	/**
	 * 
	 * findUserByUserName: 通过用户名查找用户
	 *
	 * @param userName 用户名
	 * @return 用户对象
	 */
	public User findUserByUserName(String userName) {
		User user = new User();
		try {
			user = userDao.findUserByUserName(userName);
		} catch (Exception e) {
			log.error(e);
		}
		return user;
	}
	
	/**
	 * 
	 * loginSuccess: 登录成功操作
	 *
	 * @param user 用户对象
	 */
	public void loginSuccess(User user) {
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setLoginDateTime(DateUtil.getFormatDateStr());
		loginLog.setIp(user.getLastIp());
		try {
			userDao.updateLoginInfo(user);
			loginLogDao.insertLoginLog(loginLog);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
}
