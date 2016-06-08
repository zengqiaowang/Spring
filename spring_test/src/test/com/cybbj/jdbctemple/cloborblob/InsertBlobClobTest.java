/**   
 * 类名：InsertBlobClobTest
 *
 */
package com.cybbj.jdbctemple.cloborblob;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * InsertBlobClobTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class InsertBlobClobTest {

	/**
	 * 
	 * insertDataTest: 测试往表CLOB和BLOB字段插入数据
	 */
	@Test
	public void insertDataTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("nativeJdbcExtractor.xml");
		InsertBlobClob insertBlobClob = (InsertBlobClob)applicationContext.getBean("insertBlobClob");
		insertBlobClob.insertData();
	}
}
