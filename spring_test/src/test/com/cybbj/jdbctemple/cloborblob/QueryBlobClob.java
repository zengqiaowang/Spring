/**   
 * 类名：QueryBlobClob
 *
 */
package com.cybbj.jdbctemple.cloborblob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

/** 
 * QueryBlobClob: 查询blob与clob字段数据
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
@Repository
public class QueryBlobClob {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private LobHandler lobHandler;
	
	public List<Map<String, Object>> getBlob() {
		String sqlString = " select id,bBlob from t_clob_blob ";
		final Map<String, Object> oMap = new HashMap<String, Object>();
		return jdbcTemplate.query(sqlString,  new RowMapper() {
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				oMap.put("id", rs.getInt("id"));
				oMap.put("bBlob", lobHandler.getBlobAsBytes(rs, "bBlob"));
				return oMap;
			}
		});
	}
}
