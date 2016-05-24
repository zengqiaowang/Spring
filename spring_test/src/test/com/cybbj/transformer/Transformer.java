/**   
 * 类名：Transformer
 *
 */
package com.cybbj.transformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/** 
 * Transformer: 向JVM中注册转换器
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-17 v1.0 15989 新建 
 */
public class Transformer implements ClassFileTransformer {

	/** (非 Javadoc) 
	* @param loader
	* @param className
	* @param classBeingRedefined
	* @param protectionDomain
	* @param classfileBuffer
	* @return
	* @throws IllegalClassFormatException 
	* @see java.lang.instrument.ClassFileTransformer#transform(java.lang.ClassLoader, java.lang.String, java.lang.Class, java.security.ProtectionDomain, byte[]) 
	*/
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		
		System.out.println("Hello " + className);
		return null;
	}

}
