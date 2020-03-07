package com.xm.test3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test12 {

	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
//		Set<String> keySet = map.keySet();
		System.out.println(map.keySet());
		System.out.println(map.entrySet());
		for (String s : map.keySet()) {
			System.out.println(s);
		}
		for(Entry<String, Object> e : map.entrySet()){
			System.out.println(e);
		}
		
		
	}
}
