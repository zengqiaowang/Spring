/**   
 * 类名：BbtForumImpl
 *
 */
package com.cybbj.transaction.transactionproxyfactorybean;

/** 
 * BbtForumImpl: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-23 v1.0 15989 新建 
 */
public class BbtForumImpl implements BbtForum {

	/** (非 Javadoc) 
	 * @param obj 
	 * @see com.cybbj.transaction.transactionproxyfactorybean.BbtForum#addTopic(java.lang.Object) 
	 */
	public void addTopic(Object obj) {
		System.out.println("调用addTopic方法");

	}

	/** (非 Javadoc) 
	 * @param object 
	 * @see com.cybbj.transaction.transactionproxyfactorybean.BbtForum#updateForum(java.lang.Object) 
	 */
	public void updateForum(Object object) {

		System.out.println("调用updateForum方法");

	}

	/** (非 Javadoc) 
	 * @param forumId
	 * @return 
	 * @see com.cybbj.transaction.transactionproxyfactorybean.BbtForum#getObj(int) 
	 */
	public Object getObj(int forumId) {

		System.out.println("调用getObj方法");
		return null;
	}

	/** (非 Javadoc) 
	 * @return 
	 * @see com.cybbj.transaction.transactionproxyfactorybean.BbtForum#getForumNum() 
	 */
	public int getForumNum() {

		System.out.println("调用getForumNum方法");
		return 0;
	}

}
