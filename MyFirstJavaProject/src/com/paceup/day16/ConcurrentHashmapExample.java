package com.paceup.day16;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<>();
		
		cmap.put(1, "Java");
		cmap.put(2, "Spring");
		cmap.put(5, "Hibernate");
		cmap.put(4, "Database");
		System.out.println("ConcurrentHashMap entries:" +cmap);
		
		//Iteration
		cmap.forEach((k,v) -> System.out.println(k+" : "+v));
		
		//Safe concurrent update
		cmap.compute(2, (key,value) -> value+ " Boot");
		System.out.println("Update ConcurrentHashMap entries:" +cmap);
		
		try {
			cmap.put(null, "Test");
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}

}
