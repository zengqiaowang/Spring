/**   
 * 类名：XStreamSample
 *
 */
package com.cybbj.xmlandbean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/** 
 * XStreamSample: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建 
 */
@Component(value="xstreamSample")
public class XStreamSample {
	private static XStream xstream;
	
	static {
		//创建XStream实例并指定一个XML解析器
		xstream = new XStream(new DomDriver());
	}
	
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.200");
		log1.setLoginDate(new Date());
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.setLoginLog(log1);
		return user;
	}
	
	/**
	 * 
	 * objectToXML: java对象转换为xml
	 *
	 * @throws Exception 
	 * @return 
	 * @throws
	 */
	public static void objectToXML() throws Exception {
		User user = getUser();
		//实例化一个文件输出流
		FileOutputStream outputStream = new FileOutputStream("e:/xstreamsample.xml");
		xstream.toXML(user, outputStream);
	}
	
	public static void XMLToObject() {
		try {
			FileInputStream inputStream = new FileInputStream("e:/xstreamsample.xml");
			User user = (User)xstream.fromXML(inputStream);
			LoginLog loginLog = user.getLoginLog();
			if (loginLog != null) {
				System.out.println("访问IP：" + loginLog.getIp());
				System.out.println("访问时间：" + loginLog.getLoginDate());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
