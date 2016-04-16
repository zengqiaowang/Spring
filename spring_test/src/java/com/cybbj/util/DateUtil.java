/**   
 * 类名：DateUtil
 *
 */
package com.cybbj.util;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/** 
 * DateUtil: 时间
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-15 v1.0 15989 新建 
 */
public class DateUtil {
	
	/**
	 * 
	 * getFormatDateStr: 获取yyyy-MM-dd HH:ss:mm格式日期
	 *
	 * @return yyyy-MM-dd HH:ss:mm格式日期
	 */
	public static String getFormatDateStr() {
		return DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:ss:mm");
	}
}
