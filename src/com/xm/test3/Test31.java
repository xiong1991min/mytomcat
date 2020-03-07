package com.xm.test3;

public class Test31 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("First task started");
				System.out.println("Sleeping for 2 seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task completed");
			}
		});
		// thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
		// 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
		t.start();
		t.join(); //将t加入到当前主线程中，只有当t执行完后主线程才能继续往下执行
		t1.start();
	}

}