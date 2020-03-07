package com.xm.test3;

public class Test4 {

	private static A a = new A();
	private static final ThreadLocal<A> threadlocal = new ThreadLocal<A>(){
		protected A initialValue() {
			return a;
		};
	};
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[5];
		for(int i=0; i<threads.length;i++){
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					threadlocal.get().setNum(threadlocal.get().getNum()+5);
					System.out.println(Thread.currentThread().getName()+":"+threadlocal.get().getNum());
				}
			},"Thread-"+i);
		}
		for(Thread thread : threads){
			thread.start();
		}
	}
}
