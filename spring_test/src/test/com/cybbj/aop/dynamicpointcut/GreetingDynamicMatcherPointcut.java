/**   
 * 类名：GreetingDynamicPointcut
 *
 */
package com.cybbj.aop.dynamicpointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.cybbj.aop.staticpointcut.Waiter;

/** 
 * GreetingDynamicPointcut: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-7 v1.0 15989 新建 
 */
public class GreetingDynamicMatcherPointcut extends DynamicMethodMatcherPointcut {

	private static List<String> specialClientList = new ArrayList<String>();
	static {
		specialClientList.add("John");
		specialClientList.add("Tom");
	}
	
	/**
	 * 对类进行静态切点检查
	* @return 
	* @see org.springframework.aop.support.DynamicMethodMatcherPointcut#getClassFilter()
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {			
			public boolean matches(Class<?> clazz) {
				System.out.println("调用getClassFilter()对" + clazz.getName()+"做静态检查");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
	
	/**
	 * 对方法进行静态切点检查
	* @param method
	* @param clazz
	* @return 
	* @see org.springframework.aop.support.DynamicMethodMatcher#matches(java.lang.reflect.Method, java.lang.Class)
	 */
	public boolean matches(Method method,Class clazz) {
		System.out.println("调用matches(Method method,Class clazz)"+
				clazz.getName()+"."+method.getName()+"做静态方法检查");
		return "greetTo".equals(method.getName());
	}
	
	
	/** 
	* 对方法进行动态切点检查
	* @param method
	* @param clazz
	* @param objects
	* @return 
	* @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class, java.lang.Object[]) 
	*/
	public boolean matches(Method method, Class<?> clazz, Object[] objects) {
		System.out.println("调用matches(Method method, Class<?> clazz, Object[] objects)" +
				clazz.getName()+"." + method.getName()+"进行动态检查");
		String clientName = (String)objects[0];
		return specialClientList.contains(clientName);
	}

}
