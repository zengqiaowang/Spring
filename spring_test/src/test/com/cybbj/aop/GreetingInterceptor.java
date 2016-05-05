/**   
 * 类名：GreetingInterceptor
 *
 */
package com.cybbj.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/** 
 * GreetingInterceptor: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-5 v1.0 15989 新建 
 */
public class GreetingInterceptor implements MethodInterceptor {

	/** (非 Javadoc) 
	 * @param arg0
	 * @return
	 * @throws Throwable 
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation) 
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		//截取目标类方法逻辑,并在前面添加横切逻辑
		Object[] paraObjects = methodInvocation.getArguments();
		String clientName = (String)paraObjects[0];
		System.out.println(" How are you! Mr." + clientName);
		Object object = methodInvocation.proceed();
		System.out.println(" Please enjoy yourself ");
		return object;
	}

}
