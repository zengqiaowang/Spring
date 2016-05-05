/**   
 * 类名：Appconf
 *
 */
package com.cybbj.service.annotation.baseonclassconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cybbj.domain.annotation.LogDao;
import com.cybbj.domain.annotation.LogonService;
import com.cybbj.domain.annotation.UserDao;


/** 
 * Appconf: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-27 v1.0 15989 新建 
 */
//将一个POJO标注为定义bean的配置类
@Configuration
public class Appconf {
	//以下两个方法定义了两个bean,并提供了bean的实例化逻辑
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	
	@Bean
	public LogDao logDao() {
		return new LogDao();
	}
	
	@Bean
	@Scope("prototype")
	public LogonService logonService() {
		LogonService logonService = new LogonService();
		logonService.setUserDao(userDao());
		logonService.setLogDao(logDao());
		System.out.println("1111111111111");
		return logonService;
	}
	
}
