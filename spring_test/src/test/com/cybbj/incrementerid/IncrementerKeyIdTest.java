/**   
 * 类名：IncrementerKeyIdTest
 *
 */
package com.cybbj.incrementerid;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * IncrementerKeyIdTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class IncrementerKeyIdTest {

	/**
	 * 
	 * sequenceIncrementerId: oracle自增主键测试
	 * 
	 * @return 
	 * @throws
	 */
	@Test
	public void sequenceIncrementerId() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("incrementKeyId.xml");
		IncrementerKeyId incrementerKeyId = (IncrementerKeyId)applicationContext.getBean("incrementerKeyId");
		incrementerKeyId.sequenceIncrementerId();
	}
	
}
