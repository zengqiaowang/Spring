/**   
 * 类名：GreetingComposablePointcut
 *
 */
package com.cybbj.aop.flowpointcut.composablepointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.cybbj.aop.flowpointcut.WaiterDelegate;

/** 
 * GreetingComposablePointcut: 复合切点切面
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-9 v1.0 15989 新建 
 */
public class GreetingComposablePointcut {
	public Pointcut getIntersectionPointcut() {
		//创建一个复合切点
		ComposablePointcut cp = new ComposablePointcut();
		//创建一个流程切点
		Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");
		//创建一个方法名切点
		NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
		pt2.addMethodName("greetTo");
		
		//不知道为什么会报错
		//return cp.intersection(pt2).intersection(pt1);
		return null;
	}
}
