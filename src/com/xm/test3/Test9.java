package com.xm.test3;

public class Test9 {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	private static int value = 0;

	public static class ThreadLocalThread implements Runnable {
		@Override
		public void run() {
			threadLocal.set(10);
			value = (int) (Math.random() * 100);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf(Thread.currentThread().getName()
					+ ": threadLocal=%d, value=%d\n", threadLocal.get(), value);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new ThreadLocalThread());
		Thread thread2 = new Thread(new ThreadLocalThread());
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
	}
}
