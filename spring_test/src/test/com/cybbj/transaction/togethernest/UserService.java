/**   
 * 类名：UserService
 *
 */
package com.cybbj.transaction.togethernest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/** 
 * UserService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-24 v1.0 15989 新建 
 */
@Service("userService")
public class UserService extends BaseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ScoreService scoreService;
	
	public void logon(String userName) {
		updateLastLogonTime(userName);
		scoreService.addScore(userName, 20);
	}
	
	public void updateLastLogonTime(String userName) {
		String sqlString = "update t_user u set u.last_logon_time=? where user_name=?";
		jdbcTemplate.update(sqlString, System.currentTimeMillis(),userName);
	}
}
