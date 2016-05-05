/**   
 * 类名：NaiveWaiter
 *
 */
package com.cybbj.aop;

/** 
 * NaiveWaiter: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-4 v1.0 15989 新建 
 */
public class NaiveWaiter implements Waiter {

	/** (非 Javadoc) 
	 * @param name 
	 * @see com.cybbj.aop.Waiter#greetTo(java.lang.String) 
	 */
	public void greetTo(String name) {
		System.out.println("greet to " + name + "...");
	}

	/** (非 Javadoc) 
	 * @param name 
	 * @see com.cybbj.aop.Waiter#serveTo(java.lang.String) 
	 */
	public void serveTo(String name) {
		System.out.println("serving " + name);
	}

}
