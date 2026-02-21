package com.paceup.collections;

import java.util.LinkedHashMap;

/**
 * 
 * LinkedHashMap:
 * - Extends HashMap and implements Map interface.
 * - Stores key-value pairs.
 * - Maintains insertion order (unlike HashMap which does not guarantee order).
 * - Allows one null key and multiple null values.
 * - Not synchronized (use Collections.synchronizedMap() for thread safety).
 * 
 * Internal Working:
 * -----------------
 * - Backed by a HashMap with a doubly-linked list running through all entries.
 * - Each entry contains pointers to next and previous entries, preserving order.
 * - Formula for bucket index (same as HashMap):
 *      index = hashCode(key) & (capacity - 1)
 * - Capacity starts at 16 by default, load factor = 0.75.
 * - Threshold = capacity * loadFactor → when exceeded, capacity doubles.
 * 
 * Representation Example:
 * -----------------------
 * LinkedHashMap<Integer, String> map = {1=Apple, 2=Banana, 3=Cherry}
 * Internally:
 * Head → [1,"Apple"] → [2,"Banana"] → [3,"Cherry"] → Tail
 * Buckets (capacity=16):
 * [bucketIndex for 1] → (1, Apple)
 * [bucketIndex for 2] → (2, Banana)
 * [bucketIndex for 3] → (3, Cherry)
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
        
        // Create a LinkedHashMap
        // Syntax: new LinkedHashMap<>(initialCapacity, loadFactor)
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // Add key-value pairs (duplicate keys update value)
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Representation: Head → [1,"Apple"] → [2,"Banana"] → [3,"Cherry"] → Tail
        System.out.println("LinkedHashMap: " + map);

        // Access value by key
        System.out.println("Value for key 2: " + map.get(2));

        // Remove entry by key
        System.out.println("After removal: " + map.remove(1)); // returns removed value
        System.out.println("Map after removal: " + map + "\n");

        // Demonstrating null keys and values
        map.put(4, null);           // null value allowed
        map.put(6, "Watermelon");
        map.put(7, null);           // another null value
        map.put(null, "Lemons");    // one null key allowed
        map.put(null, null);        // overwrites previous null key mapping
        map.put(1, "Apple");        // re-inserting key 1
        map.put(1, "Apple.");       // updates value for key 1

        System.out.println("Map with nulls and updates: " + map);

        // Iterating through keys
        System.out.println("KeySet: " + map.keySet());
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
            if ("Cherry".equals(map.get(key))) {
                // Updating value during iteration
                map.put(key, "Chickoo");
            }
        }
        System.out.println("Map after update: " + map);

        // Iterating through entries
        System.out.println("EntrySet: " + map.entrySet());

        // Checking existence of keys/values
        System.out.println("Contains key 9? " + map.containsKey(9));
        System.out.println("Contains value Mango? " + map.containsValue("Mango"));

        // Getting all values
        System.out.println("Values: " + map.values());

        // getOrDefault returns default if key not found
        System.out.println("Value for key 9 (default Banana): " + map.getOrDefault(9, "Banana"));
    }
}
