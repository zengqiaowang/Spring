/**   
 * 类名：DESUtilTest
 *
 */
package com.cybbj.util;

import org.junit.Assert;
import org.junit.Test;

/** 
 * DESUtilTest: 测试DES加解密
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-28 v1.0 15989 新建 
 */
public class DESUtilTest {
	
	@Test
	public void testGetEncryptString() {
		DESUtil oDesUtil = new DESUtil();
		System.out.println(oDesUtil.getEncryptString("spring"));
	}
	
	@Test
	public void testGetDecryptString() {
		DESUtil oDesUtil = new DESUtil();
		System.out.println(oDesUtil.getDecryptString("um461kxL7IU="));
		Assert.assertEquals(oDesUtil.getDecryptString("um461kxL7IU="), "123");
	}
}
