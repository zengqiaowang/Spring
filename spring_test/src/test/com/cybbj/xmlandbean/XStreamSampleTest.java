/**   
 * 类名：XStreamSampleTest
 *
 */
package com.cybbj.xmlandbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * XStreamSampleTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-31 v1.0 15989 新建 
 */
public class XStreamSampleTest {
	
	@Test
	public void objectToXMLTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlandbean.xml");
		XStreamSample xstreamSample = (XStreamSample)applicationContext.getBean("xstreamSample");
		try {
			xstreamSample.objectToXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void xmlToObject() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlandbean.xml");
		XStreamSample xstreamSample = (XStreamSample)applicationContext.getBean("xstreamSample");
		try {
			xstreamSample.XMLToObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
