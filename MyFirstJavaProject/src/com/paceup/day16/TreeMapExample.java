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
        System.out.println("Greatest key: "+ map.lowerKey(5)); //Greatest key < given key
        System.out.println("FloorKey method: "+map.floorKey(5)); //Greatest key =< given key
        System.out.println("Ceiling method: "+map.ceilingKey(5)); // Smallest key >= given key
        System.out.println("Higher Key: "+map.higherKey(5)); //smallest key > given key
        
        System.out.println("\n Entry Methods: \n");
        System.out.println("SubMap (2)"+map.subMap(2, true, 7, false));
        System.out.println("Descending Map: "+map.descendingMap());
        System.out.println("Polling First Entry: "+map.pollFirstEntry());
        System.out.println(map);
        System.out.println("First Entry: "+map.firstEntry());
    }
}

