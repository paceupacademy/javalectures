package com.paceup.day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Add key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Access a value by key
        System.out.println("Value for key 2: " + map.get(2)); // Output: Banana

        // Iterate through the HashMap
       /* for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }*/
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry<Integer, String> entry = it.next();
        	System.out.println("Key: "+entry.getKey()+" Value:"+entry.getValue());
        	
        	if(entry.getValue().equals("Apple")) {
        		System.out.println("Removing Apple from Hashmap");
        		it.remove();
        		System.out.println(map);
        	}
        }

        // Remove an entry
		/*
		 * map.remove(1); System.out.println("After removal: " + map);
		 */
    }
}

