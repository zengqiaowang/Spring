/**   
 * 类名：MailSender
 *
 */
package com.cybbj.applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
 * MailSender: 邮件发送者(发布事件的能力)
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class MailSender implements ApplicationContextAware {

	private ApplicationContext ctx;
	/** 
	 * ApplicationContextAware的接口方法，以便容器启动时注入容器实例
	 * @param arg0
	 * @throws BeansException 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext) 
	 */
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	
	public void sendMail(String to) {
		System.out.println("MailSender:模拟发送邮件...");
		MailSendEvent mse = new MailSendEvent(this.ctx, to);
		//向容器中的所有事件监听器发送事件
		ctx.publishEvent(mse);
	}

}
