/**   
 * 类名：MailSendEvent
 *
 */
package com.cybbj.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/** 
 * MailSendEvent: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class MailSendEvent extends ApplicationContextEvent {
	private String to;

	/** 
	*
	* @param source 
	*/
	public MailSendEvent(ApplicationContext source,String to) {
		super(source);
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	/** 
	 * serialVersionUID : TODO请填写变量描述
	 */ 
	private static final long serialVersionUID = 1L;

}
