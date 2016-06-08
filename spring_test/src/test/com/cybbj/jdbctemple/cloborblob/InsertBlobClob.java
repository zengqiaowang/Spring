/**   
 * 类名：InsertBlobClob
 *
 */
package com.cybbj.jdbctemple.cloborblob;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

/** 
 * InsertBlobClob: 插入blob和clob数据
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
@Repository
public class InsertBlobClob {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//注入LobHandler属性
	@Autowired
	private LobHandler lobHandler;
	
	/**
	 * 
	 * insertData: 测试往表CLOB和BLOB字段插入数据
	 * 
	 */
	public void insertData() {
		String sqlString = "insert into t_clob_blob(id,vClob,bBlob) values(?,?,?)";
		jdbcTemplate.execute(sqlString, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {			
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
				ps.setInt(1, 1);
				lobCreator.setClobAsString(ps, 2, "test clob insert");
				lobCreator.setBlobAsBytes(ps, 3, "test blob insert".getBytes());
			}
		});
	}
	
	
	
}
