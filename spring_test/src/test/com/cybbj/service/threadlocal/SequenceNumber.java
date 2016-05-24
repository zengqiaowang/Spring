/**   
 * 类名：SequenceNumber
 *
 */
package com.cybbj.service.threadlocal;

/** 
 * SequenceNumber: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-5-18 v1.0 15989 新建 
 */
public class SequenceNumber {

	/**
	 * 通过匿名内部类覆盖ThreadLocal初始化方法initialValue(),指定初始值
	 */
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue() {
			return 0;
		}		
	};
	
	/**
	 * 
	 * getNextNum: 获取下一个序列号
	 *
	 * @return 序列号
	 */
	public int getNextNum() {
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		SequenceNumber sNumber = new SequenceNumber();
		TestClient testClient1 = new TestClient(sNumber);
		TestClient testClient2 = new TestClient(sNumber);
		TestClient testClient3 = new TestClient(sNumber);
		testClient1.start();
		testClient2.start();
		testClient3.start();
	}
	
	@SuppressWarnings("unused")
	private static class TestClient extends Thread {
		SequenceNumber sn = null;
		public TestClient(SequenceNumber sn) {
			this.sn = sn;
		}
		
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(" Thread Name:" + Thread.currentThread().getName()
						+"\tsn:" + sn.getNextNum());
			}
		}
	}
	
	
}
