/**   
 * 类名：LocaleTest
 *
 */
package com.cybbj.util.locale;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;

/** 
 * LocaleTest: 国际化测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-29 v1.0 15989 新建 
 */
public class LocaleTest {
	
	/**
	 * 
	 * testLocale: 测试本地化
	 * 
	 * @return 
	 * @throws
	 */
	@Test
	public void testLocale() {
		//带有语言和国家/地区信息的本地化对象
		Locale locale = new Locale("zh", "CN");
		System.out.println(locale.getDisplayCountry(locale) + "\t" + locale.getDisplayLanguage(locale));
		//只有语言信息的本地化对象
		Locale locale2 = new Locale("zh");
		System.out.println(locale2.getDisplayCountry() + "\t" + locale2.getDisplayLanguage());
		//等同于Locale("zh","CN")
		Locale locale3 = Locale.CHINA;
		System.out.println(locale3.getDisplayCountry() + "\t" + locale3.getDisplayLanguage());
		//等同于Locale("zh")
		Locale locale4 = Locale.CHINESE;
		System.out.println(locale4.getDisplayCountry() + "\t" + locale4.getDisplayLanguage());
		//获取本地系统默认的本地化对象
		Locale locale5 = Locale.getDefault();
		System.out.println(locale5.getDisplayCountry() + "\t" + locale5.getDisplayLanguage());
		
	}
	
	/**
	 * 
	 * testLocaleFormat: 测试本地化工具类
	 * 
	 */
	@Test
	public void testLocaleFormat() {
		//NumberFormat
/*		Locale locale = new Locale("zh", "CN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		double amt = 123456.78;
		System.out.println(nf.format(amt));*/
		
		//DateFormat
/*		DateFormat dateFormat = DateFormat.getDateInstance();
		System.out.println(dateFormat.format(new Date()));*/
		
		//MessageFormat
		//信息格式化串
		String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元。";
		String pattern2 = "At{1,time,short} On{1,date,long},{0}paid{2,number,currency}";
		//用于动态替换占位符的参数
		Object[] params = {"John",new GregorianCalendar().getTime(),12345678};
		//使用默认本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		//使用指定的本地化对象格式化信息
		MessageFormat mFormat = new MessageFormat(pattern2, Locale.US);
		String msg2 = mFormat.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}
	
	
	
	
}
