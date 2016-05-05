/**   
 * 类名：UserDao
 *
 */
package com.cybbj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.cybbj.domain.User;

/** 
 * UserDao: 用戶dao
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-14 v1.0 15989 新建 
 */
@Repository("userDao")    //通过Spring注解定义一个DAO
public class UserDao {
	
	@Autowired   //自动注入JdbcTemplate的bean
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * getMatchCount: 验证用户名、密码是否正确
	 *
	 * @param userName  用户名
	 * @param passWord  密码
	 * @return 1/0
	 * @throws
	 */
	public int getMatchCount(String userName,String passWord) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) from t_user where ")
			.append(" user_name=? and password=? ");
		
		return jdbcTemplate.queryForObject(sql.toString(), Integer.class, new Object[]{userName,passWord});
	}
	
	/**
	 * 
	 * findUserByUserName: 根据用户名查找用户对象
	 *
	 * @param userName 用户名
	 * @return User对象
	 * @throws Exception 
	 */
	public User findUserByUserName(final String userName) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" select user_id,user_name,credits ")
			.append(" from t_user where user_name=?");
		final User user = new User();
		jdbcTemplate.query(sql.toString(),new Object[]{userName} ,
				//匿名类方式实现的回调函数
				new RowCallbackHandler() {					
					public void processRow(ResultSet arg0) throws SQLException {
						user.setUserId(arg0.getInt("user_id"));
						user.setUserName(arg0.getString("user_name"));
						user.setCredits(arg0.getInt("credits"));
					}
				});
		return user;
	}
	
	/**
	 * 
	 * updateLoginInfo: 更新登录信息
	 *
	 * @param user  用户对象
	 * @throws Exception 
	 */
	public void updateLoginInfo(User user) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append(" update t_user set last_visit=?,last_ip=?,credits=? ")
			.append(" where user_id=?");
		jdbcTemplate.update(sql.toString(), new Object[]{
			user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()
		});
	}
}
