package com.xm.test2;

import java.util.Random;

public class DiskMemory {
	private int totalSize;

	public int getSize() {
		return (new Random().nextInt(3) + 1) * 100;// 加一是为了防止获取磁盘大小为0，不符合常理
	}

	public void setSize(int size) {
		totalSize += size;
	}

	public int getTotalSize() {
		return totalSize;
	}
	
}
