/**   
 * 类名：TestAspect
 *
 */
package com.cybbj.aop.aspectj.advance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.cybbj.aop.aspectj.declareparents.Waiter;

/** 
 * TestAspect: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-15 v1.0 15989 新建 
 */
@Aspect
public class TestAspect {

	/**
	 * 与运算
	 * greeToFun: 一个匹配com.baobaotao包中所有greetTo方法的切点
	 * 
	 */
	@After("within(com.baobaotao.*)"
			+ " && execution(* greetTo(..)))")
	public void greeToFun() {
		System.out.println("--greeToFun() executed!--");
	}
	
	/**
	 * 非与运算
	 * notServeInNaiveWaiter: 匹配所有serveTo()方法并该方法不位于NaiveWaiter目标类的切点
	 * 
	 */
	@Before(" !target(com.cybbj.aop.aspectj.declareparents.NaiveWaiter)" +
			" && execution(* serveTo(..))")
	public void notServeInNaiveWaiter() {
		System.out.println("--notServeInNaiveWaiter() executed!--");
	}
	
	/**
	 * 或运算
	 * waiterOrSeller: 匹配Waiter和Seller接口实现类所有连接点的切点
	 * 
	 */
	@AfterReturning("target(com.cybbj.aop.aspectj.declareparents.Waiter) ||" +
						" target(com.cybbj.aop.aspectj.declareparents.Seller)")
	public void waiterOrSeller() {
		System.out.println("--waiterOrSeller() executed!--");
	}
	
	@Before("TestNamePointCut.inPkgGreetTo()")
	public void pkgGreetTo() {
		System.out.println("--pkgGreetTo() executed!--");
	}
	
	@Before("!target(com.cybbj.aop.aspectj.declareparents.NaiveWaiter) && TestNamePointCut.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter() {
		System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
	}
	
	@Around("execution(* greetTo(..)) && target(com.cybbj.aop.aspectj.declareparents.NaiveWaiter)")
	public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("-------joinPointAccess--------");
		System.out.println("args[0]:"+pjp.getArgs()[0]);
		System.out.println("signature:" + pjp.getTarget().getClass());
		pjp.proceed();
		System.out.println("-------joinPointAccess--------");
	}
	
	/**
	 * 
	 * bindJoinPointParams: 绑定连接点方法入参
	 *
	 * @param clientName 
	 */
	@Before("target(com.cybbj.aop.aspectj.declareparents.NaiveWaiter) && args(clientName)")
	public void bindJoinPointParams(String clientName) {
		System.out.println("--bindJoinPointParams(String clientName)--");
		System.out.println("clientName: " + clientName);
		System.out.println("--bindJoinPointParams(String clientName)--");
	}
	
	/**
	 * 
	 * bindProxyObj: 绑定代理对象
	 *
	 * @param waiter 
	 */
	@Before("this(waiter)")
	public void bindProxyObj(Waiter waiter) {
		System.out.println(">>>调用bindProxyObj(Waiter waiter)方法");
	}
	
	/**
	 * 
	 * bindProxyRetVal: 绑定返回值
	 *
	 * @param retVal 拦截的返回值
	 */
	@AfterReturning(value="target(com.cybbj.aop.aspectj.declareparents.SmartSeller)",returning="retVal")
	public void bindProxyRetVal(int retVal) {
		System.out.println("调用bindProxyRetVal(int retVal)方法");
		System.out.println("retVal：" + retVal);
		System.out.println("调用bindProxyRetVal(int retVal)方法结束");
	}
	
	@AfterThrowing(value="target(com.cybbj.aop.aspectj.declareparents.SmartSeller)",throwing="ae")
	public void bindException(ArithmeticException ae) {
		System.out.println("---bindException()---");
		System.out.println("exception:" + ae.getMessage());
		System.out.println("---bindException()---");
	}
	
	
}
