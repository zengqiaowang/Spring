/**   
 * 类名：SimpleTriggerRunner
 *
 */
package com.cybbj.quartz.simpletriger;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/** 
 * SimpleTriggerRunner: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-30 v1.0 15989 新建 
 */
public class SimpleTriggerRunner {
	public static void main(String[] args) {
		try {
			JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");
			simpleTrigger.setStartTime(new Date());
			simpleTrigger.setRepeatInterval(2000);
			simpleTrigger.setRepeatCount(5);
			
			//通过SchedulerFactory获取一个调度器实例
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			//注册并进行调度
			scheduler.scheduleJob(jobDetail, simpleTrigger);
			//调度启动
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
