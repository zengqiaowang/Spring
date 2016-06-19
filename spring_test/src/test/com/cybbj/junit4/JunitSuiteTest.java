/**   
 * 类名：JunitSuiteTest
 *
 */
package com.cybbj.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/** 
 * JunitSuiteTest: 打包(套件)测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-15 v1.0 15989 新建 
 */
//指定suite测试运行器
@RunWith(Suite.class)
@SuiteClasses({ExceptionClassTest.class,JunitSuiteTest.class,JunitParameterTest.class})
public class JunitSuiteTest {
	
	@Test
	public void method1() {
		System.out.println(">>>method1方法");
	}
}
