/**   
 * 类名：ScoreService
 *
 */
package com.cybbj.transaction.togethernest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

/** 
 * ScoreService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-24 v1.0 15989 新建 
 */
@Service("scoreService")
public class ScoreService extends BaseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addScore(String userName,int toAdd) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("update t_user u set u.score=u.score+? where u.user_name=?");
		jdbcTemplate.update(sqlBuffer.toString(), toAdd,userName);
	}
	
	public void addScore2() {
		String sql = " insert into t_user(user_id,user_name,credits) values(T_USER_SEQ.nextval,?,?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "test2");
				ps.setInt(2, 20);
			}
		});
	}
	

}
