/**   
 * 类名：ForumService
 *
 */
package com.cybbj.aop.aspectj.definedannotation;

/** 
 * ForumService: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-11 v1.0 15989 新建 
 */
public class ForumService {

	@NeedTest(value=true)
	public void deleteForum(int forumId) {
		System.out.println("删除论坛模块：" + forumId);
	}
	
	@NeedTest(value=false)
	public void deleteTopic(int postId) {
		System.out.println("删除论坛主题：" + postId);
	}
	
}
