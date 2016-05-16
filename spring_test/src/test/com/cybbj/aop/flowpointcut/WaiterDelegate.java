/**   
 * 类名：WaiterDelegate
 *
 */
package com.cybbj.aop.flowpointcut;

import com.cybbj.aop.staticpointcut.Waiter;

/** 
 * WaiterDelegate: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-9 v1.0 15989 新建 
 */
public class WaiterDelegate {
	private Waiter waiter;
	
	//waiter的方法通过该方法发起调用
	public void service(String clientName) {
		waiter.greetTo(clientName);
		waiter.serverTo(clientName);
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	
}
