/**   
 * 类名：ForumService
 *
 */
package com.cybbj.aop;

import java.sql.SQLException;

/** 
 * ForumService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-5 v1.0 15989 新建 
 */
public class ForumService {
	
	/*************** 异常通知处理 ********************/
/*	public void removeForum() {
		//do sth
		throw new RuntimeException("运行异常。");
	}
	
	public void updateForum() throws Exception {
		throw new SQLException("数据更新操作异常");
	}*/
	
	/************** 引介通知 ***********************/
	public void removeForum(int forumID) {
		System.out.println("即将移除论坛编号为" + forumID + "记录") ;
	}
	
	public void updateForum(int forumID) {
		System.out.println("即将更新论坛编号为" + forumID + "记录");
	}
}
