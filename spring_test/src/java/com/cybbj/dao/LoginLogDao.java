/**   
 * 类名：LoginLogDao
 *
 */
package com.cybbj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cybbj.domain.LoginLog;

/** 
 * LoginLogDao: 登录日志插入类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * insertLoginLog: 插入登录日志
	 *
	 * @param loginLog 登录日志bean
	 * @return 
	 * @throws
	 */
	public void insertLoginLog(LoginLog loginLog) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t_login_log(LOGIN_LOG_ID,USER_ID,IP,LOGIN_DATETIME) ")
			.append("values(T_LOGIN_LOG_SEQ.nextval,?,?,?)");
		jdbcTemplate.update(sql.toString(), new Object[]{
			loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDateTime()
		});
	}
}
