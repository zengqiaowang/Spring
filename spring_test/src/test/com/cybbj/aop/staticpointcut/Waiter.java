/**   
 * 类名：Waiter
 *
 */
package com.cybbj.aop.staticpointcut;

/** 
 * Waiter: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-6 v1.0 15989 新建 
 */
public class Waiter {
	
	public void greetTo(String name) {
		System.out.println(" waiter greet to " + name);
	}
	
	public void serverTo(String name) {
		System.out.println(" waiter server to " + name);
	}
}
