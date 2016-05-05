/**   
 * 类名：TestServiceConfig
 *
 */
package com.cybbj.service.annotation.baseonclassconfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cybbj.domain.annotation.LogonService;

/** 
 * TestServiceConfig: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-27 v1.0 15989 新建 
 */
public class TestServiceConfig {
	
	@Test
	public void logonService() {
		/*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconf.class);
		LogonService logonService = (LogonService)applicationContext.getBean("logonService");
		System.out.println(logonService);*/
/*		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(Appconf.class);
		applicationContext.register(ServiceConfig.class);
		applicationContext.refresh();
		LogonService logonService = (LogonService)applicationContext.getBean("logonService");
		System.out.println(logonService);*/
	}
}
