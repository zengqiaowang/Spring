/**   
 * 类名：ControllablePerformanceMoniter
 *
 */
package com.cybbj.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/** 
 * ControllablePerformanceMoniter: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-6 v1.0 15989 新建 
 */
public class ControllablePerformanceMoniter extends DelegatingIntroductionInterceptor implements Monitorable {
	
	/** 
	 * serialVersionUID : TODO请填写变量描述
	 */ 
	private static final long serialVersionUID = 1L;
	private ThreadLocal<Boolean> moniterStatusMap = new ThreadLocal<Boolean>();
	public void setMonitorActive(boolean active) {
		moniterStatusMap.set(active);
	}

	//拦截方法
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object object = null;
		//对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控功能
		if (moniterStatusMap.get()!=null && moniterStatusMap.get()) {
			System.out.println("性能监控开始");
			object = super.invoke(mi);
			System.out.println("性能监控结束");
		} else {
			object = super.invoke(mi);
		}
		return object;
	}
}
