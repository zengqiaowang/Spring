/**   
 * 类名：GreetingAfterAdvice
 *
 */
package com.cybbj.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/** 
 * GreetingAfterAdvice: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-5 v1.0 15989 新建 
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

	/** (非 Javadoc) 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Throwable 
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object) 
	 */
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println(" please enjoy yourself ");
	}

}
