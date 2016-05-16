/**   
 * 类名：TestNamePointCut
 *
 */
package com.cybbj.aop.aspectj.advance;

import org.aspectj.lang.annotation.Pointcut;

/** 
 * TestNamePointCut: 命名切点
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-16 v1.0 15989 新建 
 */
public class TestNamePointCut {

	/**
	 * 
	 * inPackage: 通过注解方法inPackage()对该切点进行命名,方法可视域
	 * 修饰符为private，表明该命名切点只能在本切面类中使用
	 * 
	 */
	@Pointcut("within(com.cybbj.aop.aspectj.declareparents.*)")
	private void inPackage() {
		
	}
	
	/**
	 * 
	 * greetTo: 通过注解方法greetTo()对该切点进行命名,方法可视域修饰符为
	 * protected表明该命名切点可以在当前包中的切面类、子切面类中使用。
	 * 
	 */
	@Pointcut("execution(* greetTo(..))")
	protected void greetTo() {
		
	}
	
	/**
	 * 
	 * inPkgGreetTo: 应用命名切点定义的切点,本切点也是命名切点,它对应
	 * 的可视域为public
	 * 
	 */
	@Pointcut("inPackage() and greetTo()")
	public void inPkgGreetTo() {
		
	}
	
}
