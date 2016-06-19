/**   
 * 类名：JunitParameterTest
 *
 */
package com.cybbj.junit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/** 
 * JunitParameterTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-15 v1.0 15989 新建 
 */
//指定Parameterized的运行器
@RunWith(Parameterized.class)
public class JunitParameterTest {

	private SimpleDateFormat simpleDateFormat;
	private String date;
	private String dateformat;
	private String expectedDate;
	
	public JunitParameterTest(String date,String dateformat,String expectedDate) {
		this.date = date;
		this.dateformat = dateformat;
		this.expectedDate = expectedDate;
	}
	
	//测试数据提供者
	@Parameters
	@SuppressWarnings("unchecked")
	public static Collection getParameters() {
		String[][] object = {
				{"2011-07-01 00:30:59","yyyyMMdd","20110701"},
				{"2011-07-01 00:30:59","yyyy年MM月dd日","2011年07月01日"},
				{"2011-07-01 00:30:59","HH时mm分ss秒","00时30分59秒"},
		};
		
		return Arrays.asList(object);
	}
	
	//测试日期格式化
	@Test
	public void testSimpleDateFormat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(this.date);
		simpleDateFormat = new SimpleDateFormat(this.dateformat);
		String result = simpleDateFormat.format(date);
		Assert.assertEquals(this.expectedDate,result);
	}
	
	
}
