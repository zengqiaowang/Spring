/**   
 * 类名：PreGreetingAspect
 *
 */
package com.cybbj.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/** 
 * PreGreetingAspect: 使用AspectJ定义切面
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-11 v1.0 15989 新建 
 */
@Aspect	//通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect {
	
	//定义切点和增强类型
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {	//增强的横切逻辑
		System.out.println("How are you");
	}
}
