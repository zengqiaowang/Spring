/**   
 * 类名：MysqlIncrementerKeyIdTest
 *
 */
package com.cybbj.incrementerid;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * MysqlIncrementerKeyIdTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class MysqlIncrementerKeyIdTest {

	@Test
	public void sequenceIncrementerIdTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("incrementKeyId.xml");
		MysqlIncrementerKeyId mysqlIncrementerKeyId = (MysqlIncrementerKeyId)applicationContext.getBean("mysqlIncrementerKeyId");
		mysqlIncrementerKeyId.sequenceIncrementerId();
	}
}
