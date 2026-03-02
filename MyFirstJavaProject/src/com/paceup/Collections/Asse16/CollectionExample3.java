// Write a program to store and retrieve values using HashMap.
package com.paceup.Collections.Asse16;
import java.util.HashMap;

public class CollectionExample3 {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		
		System.out.println("Get Map 2 index value: " + map.get(2));
		System.out.println("Map: " + map);
		
	}

}
