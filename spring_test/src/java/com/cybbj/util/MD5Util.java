/**   
 * 类名：MD5Util
 *
 */
package com.cybbj.util;

import java.security.MessageDigest;

/** 
 * MD5Util: MD5算法
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-27 v1.0 15989 新建 
 */
public class MD5Util {
	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
	  
	private static String toHexString(byte[] b) {  
	    StringBuilder sb = new StringBuilder(b.length * 2);  
	    for (int i = 0; i < b.length; i++) {  
	        sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);  
	        sb.append(HEX_DIGITS[b[i] & 0x0f]);  
	    }  
	    return sb.toString();  
	}  
	  
	public static String Bit32(String SourceString) throws Exception {  
	    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");  
	    digest.update(SourceString.getBytes());  
	    byte messageDigest[] = digest.digest();  
	    return toHexString(messageDigest);  
	}  
	   
	public static String Bit16(String SourceString) throws Exception {  
	    return Bit32(SourceString).substring(8, 24);  
	} 
}
