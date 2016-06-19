/**   
 * 类名：Junit4ZHTest
 *
 */
package com.cybbj.junit4;

import org.junit.Before;
import org.junit.Test;

/** 
 * Junit4ZHTest: Junit4综合测试类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-15 v1.0 15989 新建 
 */
public class Junit4ZHTest {
	private Junit4ZH junit4zh;

	@Before
	public void init() {
		junit4zh = new Junit4ZH();
	}
	
	/**
	 * 
	 * timeOut: timeout单位为毫秒
	 * 
	 * @return 
	 * @throws
	 */
	@Test(timeout=100)
	public void timeOut() {
		junit4zh.timeOut();
	}
	
	public void destroy() {
		junit4zh = null;
	}
}
