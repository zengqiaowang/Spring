/**   
 * 类名：BbtForum
 *
 */
package com.cybbj.transaction.transactionproxyfactorybean;

/** 
 * BbtForum: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-23 v1.0 15989 新建 
 */
public interface BbtForum {
	void addTopic(Object obj);
	void updateForum(Object object);
	Object getObj(int forumId);
	int getForumNum();
}
