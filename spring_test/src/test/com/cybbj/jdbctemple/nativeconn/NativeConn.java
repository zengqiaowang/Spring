/**   
 * 类名：NativeConn
 *
 */
package com.cybbj.jdbctemple.nativeconn;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/** 
 * NativeConn: 获取本地连接
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-29 v1.0 15989 新建 
 */
@Repository
public class NativeConn {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getConn() {
		//使用DataSourceUtils从模板类中获取连接
		Connection connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
		try {
			//使用模板类的本地Jdbc抽取器获取本地Connection
			connection = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(connection);
			//强制类型转换
			OracleConnection oconn = (OracleConnection)connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
