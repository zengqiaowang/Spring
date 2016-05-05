/**   
 * 类名：ResourceTest
 *
 */
package com.cybbj.util.locale;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/** 
 * ResourceTest: ResourceBundle测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class ResourceTest {

	/**
	 * 
	 * testResourceBoundle: 判断加载不同语言属性文件
	 * 
	 */
	@Test
	public void testResourceBoundle() {
		ResourceBundle resourceBundle1 = ResourceBundle.getBundle("locale/resource", Locale.US);
		ResourceBundle resourceBundle2 = ResourceBundle.getBundle("locale/resource", Locale.CHINESE);
		System.out.println(resourceBundle1.getString("param1"));
		System.out.println(resourceBundle2.getString("param1"));
	}
	
}
