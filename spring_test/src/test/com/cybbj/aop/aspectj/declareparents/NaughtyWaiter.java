/**   
 * 类名：NaughtyWaiter
 *
 */
package com.cybbj.aop.aspectj.declareparents;

import com.cybbj.aop.aspectj.definedannotation.NeedTest;

/** 
 * NaughtyWaiter: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-12 v1.0 15989 新建 
 */
public class NaughtyWaiter implements Waiter {

	/** (非 Javadoc) 
	 * @param clientName 
	 * @see com.cybbj.aop.aspectj.declareparents.Waiter#serveTo(java.lang.String) 
	 */
	public void serveTo(String clientName) {

		System.out.println("NaughtyWaiter类的serveTo方法");

	}

	/** (非 Javadoc) 
	 * @param clientName 
	 * @see com.cybbj.aop.aspectj.declareparents.Waiter#greetTo(java.lang.String) 
	 */
	@NeedTest
	public void greetTo(String clientName) {

		System.out.println("@NeedTest greetTo方法");

	}

}
