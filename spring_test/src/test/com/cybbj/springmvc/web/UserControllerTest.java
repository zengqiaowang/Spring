/**   
 * 类名：UserControllerTest
 *
 */
package com.cybbj.springmvc.web;

import java.util.Collections;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;

import com.cybbj.springmvc.pojo.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/** 
 * UserControllerTest: UserController类测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-3 v1.0 15989 新建 
 */
public class UserControllerTest {

	@Test
	public void xmlToUserToXmlTest() {
		
		RestTemplate restTemplate = buildRestTemplate();
		
		//创建User对象，它将通过RestTemplate流化为XML请求报文
		User user = new User();
		user.setUserName("tom");
		user.setUserPwd("123");
		user.setName("汤姆");
		
		//指定请求报文头信息
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		
		HttpEntity<User> httpEntity = new HttpEntity<User>(user,httpHeaders);
		ResponseEntity<User> responseEntity = restTemplate.exchange(
				"http://localhost:8081/spring_test/user/xmlToUserToXml.html", 
				HttpMethod.POST, httpEntity, User.class);
		User oTempUser = responseEntity.getBody();
		System.out.println(oTempUser.toString());
	}
	
	@Test
	public void jsonToUserToJsonTest() {
		RestTemplate restTemplate = buildRestTemplate();
		//创建User对象，他将通过RestTemplate流化为json请求报文
		User user = new User();
		user.setUserName("admin");
		user.setUserPwd("dpadmin");
		user.setName("测试测试");
		
		//指定请求报文头信息
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<User> httpEntity = new HttpEntity<User>(user, httpHeaders);
		ResponseEntity<User> responseEntity = restTemplate.exchange(
				"http://localhost:8081/spring_test/user/jsonToUserToJson.html",
				HttpMethod.POST, httpEntity, User.class);
	}
	
	/**
	 * 
	 * buildRestTemplate: 创建restTemplate(添加xml与json消息转换器)
	 *
	 * @return 
	 * @return 
	 * @throws
	 */
	private RestTemplate buildRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		//使用XStream流化器，使用STAX技术处理XML，同时加载使用了XStream注解的User类
		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		xstreamMarshaller.setStreamDriver(new StaxDriver());
		xstreamMarshaller.setAnnotatedClasses(new Class[]{User.class});
		
		//创建处理XML报文的HttpMessageConverter,将其组装到RestTemplate中
		MarshallingHttpMessageConverter xmlMessageConverter = new MarshallingHttpMessageConverter();
		xmlMessageConverter.setMarshaller(xstreamMarshaller);
		xmlMessageConverter.setUnmarshaller(xstreamMarshaller);
		restTemplate.getMessageConverters().add(xmlMessageConverter);
		
		//创建处理json报文的HttpMessageConverter，将其组装到RestTemple中
		MappingJacksonHttpMessageConverter jsonConverter = 
											new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(jsonConverter);
		return restTemplate;
		
	}
}
