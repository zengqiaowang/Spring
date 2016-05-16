/**   
 * 类名：TestTool
 *
 */
package com.cybbj.aop.aspectj.definedannotation;

import java.lang.reflect.Method;

import org.junit.Test;

/** 
 * TestTool: 测试工具
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-11 v1.0 15989 新建 
 */
public class TestTool {
	
	@Test
	public void testGetAnnotation() {
		//得到ForumService对应的Class对象
		Class clazz = ForumService.class;
		//得到ForumService对应的Method数组
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(">>>方法数为：" + methods.length);
		for (Method method:methods) {
			//获取注解类
			NeedTest nTest = method.getAnnotation(NeedTest.class);
			if (nTest!=null) {
				if (nTest.value()) {
					System.out.println(method.getName()+"()需要测试");
				} else {
					System.out.println(method.getName()+"()不需要测试");
				}
			}
		}
	}
}
