package com.xm.test3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test7 {

	public static void main(String[] args) {
		 final C c = new C();
		//如果不重写initialValue方法，会报空指针。
		final ThreadLocal<C> t = new ThreadLocal<C>(){
			@Override
			protected C initialValue() {
				return c;
			}
		};
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			service.execute(new Runnable() {
				@Override
				public void run() {
					t.get().setI(10);
					System.out.println(t.get().getI());
				}
			});
		}
	}
	
	public static class C{
		private int i=0;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
		
	}
}
