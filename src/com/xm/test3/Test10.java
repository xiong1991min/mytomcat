package com.xm.test3;

import java.util.LinkedList;

public class Test10 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(int i : list){
			System.out.println(i);
		}
		list.add(4);
		for(int i : list){
			System.out.println(i);
		}
		list.remove();
		for(int i : list){
			System.out.println(i);
		}
	}
}
