/**   
 * 类名：DESUtil
 *
 */
package com.cybbj.util;

import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** 
 * DESUtil: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-28 v1.0 15989 新建 
 */
public class DESUtil {

	//指定DES加密解密所用的秘钥
	private static Key key;
	private static String KEY_STR="myKey";
	
	//产生加解密随机秘钥
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * getEncryptString: 对字符串进行DES加密,返回BASE64编码的加密字符串
	 *
	 * @param str 待加密字符串
	 * @return 加密后字符串
	 */
	public static String getEncryptString(String str) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		byte[] encryptStrBytes = new byte[]{};
		try {
			byte[] strBytes = str.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encryptStrBytes = cipher.doFinal(strBytes);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64Encoder.encode(encryptStrBytes);
	}
	
	/**
	 * 
	 * getDecryptString: 对BASE64编码的加密字符串进行解密,返回解密后的字符串
	 *
	 * @param str  待解密字符串
	 * @return 解密后字符串
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		String decryptStr = "";
		try {
			byte[] strBytes = base64Decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			decryptStr =  new String(decryptStrBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptStr;
	}
	
}
