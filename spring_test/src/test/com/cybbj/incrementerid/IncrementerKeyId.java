/**   
 * 类名：IncrementerKeyId
 *
 */
package com.cybbj.incrementerid;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Repository;

/** 
 * IncrementerKeyId: oracle自增主键
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
@Repository
public class IncrementerKeyId {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	@Qualifier(value="seq_t_user_seq")
	private OracleSequenceMaxValueIncrementer seq_t_user_seq;
	
	
	public void sequenceIncrementerId() {
		String sqlString = " insert into t_user(user_id,user_name) values(?,?)";
		jdbcTemplate.update(sqlString, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, seq_t_user_seq.nextLongValue());
				ps.setString(2, "测试sequence");
			}
		});
	}

}
