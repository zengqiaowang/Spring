/**   
 * 类名：UserDao
 *
 */
package com.cybbj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** 
 * UserDao: 用戶dao
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
@Repository    //通过Spring注解定义一个DAO
public class UserDao {
	
	@Autowired   //自动注入JdbcTemplate的bean
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName,String passWord) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) from t_user where ")
			.append(" user_name=? and password=? ");
		
		return jdbcTemplate.queryForObject(sql.toString(), Integer.class, new Object[]{userName,passWord});
	}
	
}
