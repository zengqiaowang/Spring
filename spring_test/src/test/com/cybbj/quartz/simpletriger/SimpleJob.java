/**   
 * 类名：SimpleJob
 *
 */
package com.cybbj.quartz.simpletriger;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/** 
 * SimpleJob: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class SimpleJob implements Job {

	/** (非 Javadoc) 
	 * @param arg0
	 * @throws JobExecutionException 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext) 
	 */
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {

		System.out.println(jobCtx.getTrigger().getName()+"\t" + "triggered time is " + new Date());

	}

}
