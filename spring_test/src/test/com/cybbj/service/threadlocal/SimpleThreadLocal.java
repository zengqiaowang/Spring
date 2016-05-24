/**   
 * 类名：SimpleThreadLocal
 *
 */
package com.cybbj.service.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** 
 * SimpleThreadLocal: 模拟实现ThreadLocal
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-18 v1.0 15989 新建 
 */
public class SimpleThreadLocal {
	private Map map = Collections.synchronizedMap(new HashMap());
	
	/**
	 * 
	 * set: 设置值
	 *
	 * @param newValue 值
	 */
	public void set(Object newValue) {
		map.put(Thread.currentThread(), newValue);
	}
	
	/**
	 * 
	 * get: 获取值
	 *
	 * @return 返回值
	 */
	public Object get() {
		Thread thread = Thread.currentThread();
		Object object = map.get(thread);
		if (object !=null && !map.containsKey(thread)) {
			object = initialValue();
			map.put(thread, object);
		}
		return object;
	}
	
	
	/**
	 * 
	 * remove: 移除对应线程值
	 * 
	 */
	public void remove() {
		map.remove(Thread.currentThread());
	}
	
	/**
	 * 
	 * initialValue: 初始化
	 *
	 * @return 
	 */
	public Object initialValue() {
		return null;
	}
	
	
}
