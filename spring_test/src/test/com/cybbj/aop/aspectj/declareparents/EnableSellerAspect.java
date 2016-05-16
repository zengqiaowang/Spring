/**   
 * 类名：EnableSellerAspect
 *
 */
package com.cybbj.aop.aspectj.declareparents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/** 
 * EnableSellerAspect: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-12 v1.0 15989 新建 
 */
@Aspect
public class EnableSellerAspect {
	
	@DeclareParents(value="com.cybbj.aop.aspectj.declareparents.NaiveWaiter",  //为NaiveWaiter添加接口实现
				defaultImpl=SmartSeller.class	//默认的接口实现类
			)
	public Seller seller;  //要实现的目标接口
}
