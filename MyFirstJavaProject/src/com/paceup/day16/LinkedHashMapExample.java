package com.paceup.day16;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // Add key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        
        //1->2->3

        // Print the map (insertion order is maintained)
        System.out.println("LinkedHashMap: " + map);

        // Access a value
        System.out.println("Value for key 2: " + map.get(2));

        // Remove an entry
        map.remove(1);
        System.out.println("After removal: " + map);
        
        map.put(4, null);
        map.put(6, "Watermelon");
        map.put(7, null);
        map.put(null, "Lemons");
        map.put(null, null);

        System.out.println(map);
        
        // Iterate through the map
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}

