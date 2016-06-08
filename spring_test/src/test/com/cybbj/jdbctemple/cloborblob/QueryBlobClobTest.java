/**   
 * 类名：QueryBlobClobTest
 *
 */
package com.cybbj.jdbctemple.cloborblob;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/** 
 * QueryBlobClobTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class QueryBlobClobTest {

	@Test
	public void getBlob() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("nativeJdbcExtractor.xml");
		QueryBlobClob queryBlobClob = (QueryBlobClob)applicationContext.getBean("queryBlobClob");
		List<Map<String, Object>> oList = queryBlobClob.getBlob();
		if (oList != null && oList.size()>0) {
			for (Map oMap:oList) {
				System.out.println(oMap.get("id"));
				System.out.println(new String((byte[])oMap.get("bBlob")));
			}
		}
	}
}
