/**   
 * 类名：GreetingBeforeAdvice
 *
 */
package com.cybbj.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/** 
 * GreetingBeforeAdvice: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-4 v1.0 15989 新建 
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	/** (非 Javadoc) 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws Throwable 
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object) 
	 */
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		String clientName = (String)arg1[0];
		System.out.println("How are you! Mr." + clientName);
	}

}
