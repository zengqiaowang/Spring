/**   
 * 类名：MysqlIncrementerKeyId
 *
 */
package com.cybbj.incrementerid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.stereotype.Repository;

/** 
 * MysqlIncrementerKeyId: mysql自增主键
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
@Repository
public class MysqlIncrementerKeyId {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	@Qualifier(value="seq_t_user_mysql")
	private MySQLMaxValueIncrementer seq_t_user_mysql;
	
	public void sequenceIncrementerId() {
		String sqlString = " insert into t_user(user_id,user_name) values(?,?)";
		jdbcTemplate.update(sqlString, new Object[]{seq_t_user_mysql.nextIntValue(),"测试用户"}, 
				new int[]{java.sql.Types.INTEGER,java.sql.Types.VARCHAR});
	}
	
}
