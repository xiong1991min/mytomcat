package com.xm.test3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test33 implements Callable<Integer>{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test33 test33 = new Test33();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(test33);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return 1;
	}
}
