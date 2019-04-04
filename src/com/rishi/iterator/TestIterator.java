package com.rishi.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestIterator {

	public static void main(String[] args) {
		Map<Integer,String> mymap = new HashMap<>();
		mymap.put(1, "value1");
		mymap.put(2, "value1");
		mymap.put(3, "value1");
		mymap.put(4, "value1");
		
		Iterator<Integer> itr = mymap.keySet().iterator();
		while(itr.hasNext()){
			Integer key = itr.next();
			
			mymap.put(++key, "value "+"_");
		}
		
		for(Integer key1:mymap.keySet()){
			System.out.println(" "+key1+" :"+mymap.get(key1));
		}
	}
}
