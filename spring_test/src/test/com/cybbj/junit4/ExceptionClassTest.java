/**   
 * 类名：ExceptionClassTest
 *
 */
package com.cybbj.junit4;

import org.junit.BeforeClass;
import org.junit.Test;

/** 
 * ExceptionClassTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-15 v1.0 15989 新建 
 */
public class ExceptionClassTest {
	
	private static ExceptionClass exceptionClass;
	
	@BeforeClass
	public static void init() {
		exceptionClass = new ExceptionClass();
	}

	@Test(expected=Exception.class)
	public void testException1() throws Exception{
		exceptionClass.exception1();
	}
	
	public static void destroy() {
		exceptionClass = null;
	}
}
