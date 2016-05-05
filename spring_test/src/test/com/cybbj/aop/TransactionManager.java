/**   
 * 类名：TransactionManager
 *
 */
package com.cybbj.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/** 
 * TransactionManager: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-5 v1.0 15989 新建 
 */
public class TransactionManager implements ThrowsAdvice {
	//定义增强逻辑
	public void afterThrowing(Method method,Object[] args,Object target,Exception ex) throws Throwable {
		System.out.println("---------------------");
		System.out.println("method: " + method.getName());
		System.out.println("抛出异常：" + ex.getMessage());
		System.out.println("成功回滚事务。");
	}
}
