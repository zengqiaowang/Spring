/**   
 * 类名：GreetingAdvisor
 *
 */
package com.cybbj.aop.staticpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/** 
 * GreetingAdvisor: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-6 v1.0 15989 新建 
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/** 
	 * serialVersionUID : TODO请填写变量描述
	 */ 
	private static final long serialVersionUID = 1L;

	/** (非 Javadoc) 
	 * @param arg0
	 * @param arg1
	 * @return 
	 * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class) 
	 */
	public boolean matches(Method method, Class<?> class1) {
		//切点方法匹配规则 方法名为greetTo
		return "greetTo".equals(method.getName());
	}
	
	/**
	 * 切点类匹配规则：为Waiter的类或子类
	* @return 
	* @see org.springframework.aop.support.StaticMethodMatcherPointcut#getClassFilter()
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class<?> class1) {
				return Waiter.class.isAssignableFrom(class1);
			}
		};
	}
	

}
