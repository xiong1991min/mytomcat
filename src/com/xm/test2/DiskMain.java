package com.xm.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiskMain {
	public static void main(String[] args) throws InterruptedException {
		List<String> ss = new ArrayList<String>();
		ss.add("1");
		ss.add("2");
		ss.add("3");
		ss.add("4");
		ss.add("5");
		ss.add("6");
//		final CountDownLatch countDownLatch = new CountDownLatch(4);
		ExecutorService service = Executors.newFixedThreadPool(6);
//		final DiskMemory diskMemory = new DiskMemory();
		for (int i = 0; i < ss.size(); i++) {
			final String string = ss.get(i);
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(string);
//					int timer = new Random().nextInt(5);
//					try {
//						Thread.sleep(timer * 1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					int diskSize = diskMemory.getSize();
//					System.out.printf("完成磁盘的统计任务,耗费%d秒. 磁盘大小为%d.\n", timer,diskSize);
//					diskMemory.setSize(diskSize);
					// 任务完成之后,计数器减一
//					countDownLatch.countDown();
//					System.out.println("count num = " + countDownLatch.getCount());
				}
			});

		}
		// 主线程一直被阻塞,直到count的计数器被置为0
//		countDownLatch.await();
//		System.out.printf("全部磁盘都统计完成,所有磁盘总大小.\n" + ", totalSize = " + diskMemory.getTotalSize());
		service.shutdown();
	}
}
