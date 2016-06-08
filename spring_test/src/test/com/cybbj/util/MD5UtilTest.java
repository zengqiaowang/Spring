/**   
 * 类名：MD5UtilTest
 *
 */
package com.cybbj.util;

import org.junit.Test;

/** 
 * MD5UtilTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-27 v1.0 15989 新建 
 */
public class MD5UtilTest {
	
	@Test
	public void testBit32() throws Exception{
		System.out.println(MD5Util.Bit32("zengqiaowang201605"));
	}
	
	@Test
	public void testBit16() throws Exception{
		System.out.println(MD5Util.Bit16("zengqiaowang201605"));
	}
}
