package com.paceup.day16;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {

	public static void main(String[] args) {
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "Java");
		table.put(2, "Spring");
		table.put(3, "Hibernate");
		
		System.out.println(table);

		for(Map.Entry<Integer, String> entry : table.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		try {
			table.put(5, null);
			table.put(null, null);
		} catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}

}
