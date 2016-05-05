/**   
 * 类名：MailSendListener
 *
 */
package com.cybbj.applicationContext;

import org.springframework.context.ApplicationListener;

/** 
 * MailSendListener: 邮件发送者监听
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {

	/** (非 Javadoc) 
	* @param arg0 
	* @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent) 
	*/
	public void onApplicationEvent(MailSendEvent event) {
		MailSendEvent mse = (MailSendEvent)event;
		System.out.println("MailSendListener:向" + mse.getTo()+"发送完一封邮件");
	}

}
