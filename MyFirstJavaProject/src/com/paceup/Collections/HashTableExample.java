package com.paceup.Collections;

import java.util.Hashtable;
import java.util.Map;

/**
 * 
 * Hashtable:
 * - Legacy class (introduced in Java 1.0).
 * - Implements Map interface.
 * - Stores key-value pairs in a hash table (array of buckets).
 * - Keys and values cannot be null (NullPointerException if attempted).
 * - Maintains no order of elements.
 * - Synchronized → thread-safe (unlike HashMap).
 * 
 * Internal Working:
 * -----------------
 * - Uses hashCode() of the key to determine bucket index:
 *      index = hashCode(key) & (capacity - 1)
 * - Collisions handled using linked lists inside buckets.
 * - Default capacity = 11, load factor = 0.75.
 * - When threshold exceeded, capacity grows (rehashing).
 * 
 * Difference from HashMap:
 * ------------------------
 * - HashMap allows one null key and multiple null values.
 * - Hashtable does NOT allow null keys or null values.
 * - HashMap is unsynchronized (faster), Hashtable is synchronized (slower).
 */
public class HashTableExample {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<Integer, String> table = new Hashtable<>();

        // Add key-value pairs
        table.put(1, "Java");
        table.put(2, "Spring");
        table.put(3, "Hibernate");

        // Print entire table
        System.out.println("Hashtable: " + table);

        // Iterate through entries
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Null keys/values not allowed
        try {
            table.put(5, null);   // Throws NullPointerException
            table.put(null, null); // Throws NullPointerException
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
