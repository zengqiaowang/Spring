/**   
 * 类名：TestScoreService
 *
 */
package com.cybbj.transaction.togethernest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * TestScoreService: 测试ScoreService
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-24 v1.0 15989 新建 
 */
public class TestScoreService {
	
	@Test
	public void addScoreTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
		ScoreService scoreService = (ScoreService)applicationContext.getBean("scoreService");
		//scoreService.addScore("admin", 10);
		scoreService.addScore2();
	}
}
