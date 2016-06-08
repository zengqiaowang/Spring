/**   
 * 类名：UserService
 *
 */
package com.cybbj.transaction.togethernest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	
	/**
	 * 
	 * getKeyId: 得到插入数据的主键值(目前一直有问题！！！！！！)
	 *
	 * @return 
	 * @return 
	 * @throws
	 */
	public int getKeyId() {
		final String sql = " insert into t_user(user_id,user_name,credits) values(T_USER_SEQ.nextval,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {			
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, "test2");
				ps.setInt(2, 20);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	public void batchInsert() {
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", "test3");
		map.put("credits", 10);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("user_name", "test4");
		map.put("credits", 10);
		list.add(map);
		String sql = " insert into t_user(user_id,user_name,credits) values(T_USER_SEQ.nextval,?,?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				
				Map<String, Object> oTempMap = list.get(index);
				ps.setString(1, (String) oTempMap.get("user_name"));
				ps.setInt(2, (Integer)oTempMap.get("credits"));
			}
			
			public int getBatchSize() {
				return list.size();
			}
		});
	}
	
	public Map<String, String> queryForRowCallbackHandler() {
		final Map<String, String> oMap = new HashMap<String, String>();
		String sqlString = " select user_name,credits from t_user ";
		jdbcTemplate.query(sqlString, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				oMap.put("user_name", rs.getString("user_name"));
				oMap.put("credits", rs.getString("credits"));
			}
		});
		System.out.println(oMap.get("user_name"));
		System.out.println(oMap.get("credits"));
		return oMap;
	}
	
	public List<Map<String, String>> queryForRowMapper() {
		String sqlString = " select user_name,credits from t_user ";
		return jdbcTemplate.query(sqlString, new RowMapper(){
			public Map<String, String> mapRow(ResultSet rs, int index) throws SQLException {
				System.out.println(">>>index: " + index);
				Map<String, String> oMap = new HashMap<String, String>();
				oMap.put("user_name", rs.getString("user_name"));
				oMap.put("credits", rs.getString("credits"));
				return oMap;
			}
			
		});
	}
	
	public int RowCountCallbackHandler() {
		String sqlString = "select user_name from t_user";
		RowCountCallbackHandler countCallback  = new RowCountCallbackHandler();
		jdbcTemplate.query(sqlString, countCallback);
		
		return countCallback.getRowCount();
	}
}
