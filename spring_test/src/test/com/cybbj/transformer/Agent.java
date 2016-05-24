/**   
 * 类名：Agent
 *
 */
package com.cybbj.transformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/** 
 * Agent: 代理类
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-17 v1.0 15989 新建 
 */
public class Agent {
	public static void premain(String agentArgs,Instrumentation inst) {
		//实例化转换器
		ClassFileTransformer t = new Transformer();
		//将转换器注册到JVM中的instrumentation中
		inst.addTransformer(t);
	}
}
