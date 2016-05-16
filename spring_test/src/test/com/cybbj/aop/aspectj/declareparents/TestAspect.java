/**   
 * 类名：TestAspect
 *
 */
package com.cybbj.aop.aspectj.declareparents;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/** 
 * TestAspect: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-12 v1.0 15989 新建 
 */
@Aspect
public class TestAspect {
	@AfterReturning("@annotation(com.cybbj.aop.aspectj.definedannotation.NeedTest)")
	public void needTestFun() {
		System.out.println("needTestFun() executed");
	}
}
