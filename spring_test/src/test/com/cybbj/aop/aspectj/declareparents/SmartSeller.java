/**   
 * 类名：SmartSeller
 *
 */
package com.cybbj.aop.aspectj.declareparents;

/** 
 * SmartSeller: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-12 v1.0 15989 新建 
 */
public class SmartSeller implements Seller {

	/** (非 Javadoc) 
	 * @param goods 
	 * @see com.cybbj.aop.aspectj.declareparents.Seller#sell(java.lang.String) 
	 */
	public void sell(String goods) {

		System.out.println(">>>sell：" + goods);

	}

}
