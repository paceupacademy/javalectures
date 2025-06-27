package com.paceup.day16;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        // Adding key-value pairs
        map.put(3, "Apple");
        map.put(1, "Banana");
        map.put(2, "Cherry");

        // Displaying the TreeMap (keys will be sorted)
        System.out.println("TreeMap: " + map);

        // Accessing elements
        System.out.println("Value for key 2: " + map.get(2));
        
        map.put(4, null);
        map.put(6, "Watermelon");
        map.put(7, null);
        map.put(5, "Lemons");
        
        System.out.println(map);

        // Removing an element
        map.remove(1);
        System.out.println("After removal: " + map);
    }
}

