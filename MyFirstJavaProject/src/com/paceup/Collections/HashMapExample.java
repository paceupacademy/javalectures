package com.paceup.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * HashMap:
 * - Implements Map interface.
 * - Stores key-value pairs (unique keys, values can be duplicated).
 * - Backed internally by a hashtable (array of buckets).
 * - Provides O(1) average time complexity for put/get/remove operations.
 * - Not synchronized (use Collections.synchronizedMap() for thread safety).
 * 
 * Internal Working:
 * -----------------
 * - Each key's hashCode() is used to calculate bucket index:
 *      index = hashCode(key) & (capacity - 1)
 * - Capacity starts at 16 by default, load factor = 0.75.
 * - Threshold = capacity * loadFactor → when exceeded, capacity doubles.
 * - Collisions (two keys mapping to same bucket) are handled by linked lists
 *   or balanced trees (since Java 8).
 * 
 * Representation Example:
 * -----------------------
 * HashMap<Integer, String> map = {1=Apple, 2=Banana, 3=Cherry}
 * Internally (capacity=16):
 * [bucketIndex for 1] → (1, Apple)
 * [bucketIndex for 2] → (2, Banana)
 * [bucketIndex for 3] → (3, Cherry)
 * Other buckets → null
 */
public class HashMapExample {
    public static void main(String[] args) {
        
        // Example 1: Map reference with HashMap implementation
        Map<String, Integer> m = new HashMap<>();
        m.put("Key1", 1);
        m.put("Key2", 2);
        m.put("Key3", 3);
        System.out.println("Map elements are " + m);

        // Example 2: Direct HashMap usage
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(1, "Apple");   // bucket index based on hashCode(1)
        map.put(2, "Banana");  // bucket index based on hashCode(2)
        map.put(3, "Cherry");  // bucket index based on hashCode(3)
        System.out.println("Initial Map: " + map);

        // Accessing value by key
        System.out.println("Value for key 3: " + map.get(3)); // Cherry

        // Updating value for a key (replaces old value)
        map.put(3, "Apple"); // Key 3 now maps to "Apple"
        System.out.println("Updated Map: " + map);

        // Iterating through HashMap using Iterator
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

            // Removing entry safely during iteration
            if (entry.getValue().equals("Apple")) {
                System.out.println("Removing Apple from HashMap");
                it.remove(); // safe removal via iterator
                System.out.println("Map after removal: " + map);
            }

            // Updating value during iteration
            if (entry.getValue().equals("Banana")) {
                entry.setValue("Berry"); // replaces "Banana" with "Berry"
            }

            // Demonstrating hashCode of entry object
            if (entry.getValue().equals("Berry")) {
                System.out.println("HashCode of entry (key+value): " + entry.hashCode());
            }
        }

        // Removing entry by key
        map.remove(3); // removes key 3 if present
        System.out.println("After removal of key 3: " + map);

        // Thread-safe version (optional)
        // Map<Integer, String> syncMap = Collections.synchronizedMap(map);
    }
}
