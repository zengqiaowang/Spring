/**   
 * 类名：ServiceConfig
 *
 */
package com.cybbj.service.annotation.baseonclassconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cybbj.domain.annotation.LogonService;

/** 
 * ServiceConfig: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-27 v1.0 15989 新建 
 */
@Configuration
public class ServiceConfig {
	
	@Autowired
	private Appconf appconf;
	
	@Bean
	public LogonService logonService() {
		LogonService logonService = new LogonService();
		logonService.setLogDao(appconf.logDao());
		logonService.setUserDao(appconf.userDao());
		System.out.println("222222222222");
		return logonService;
	}
	
}
