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

        System.out.println("=========== HASHTABLE ===========");

        // Create a Hashtable
        Hashtable<Integer, String> table = new Hashtable<>();

        System.out.println("\n--- Adding Elements ---");

        // Add key-value pairs
        table.put(1, "Java");
        table.put(2, "Spring");
        table.put(3, "Hibernate");

        System.out.println("Hashtable contents: " + table);

        System.out.println("\n--- Iterating Entries ---");

        /**
         * Iteration using entrySet()
         * - Provides both key and value together
         * - Order is NOT guaranteed
         */
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println(
                "Key   : " + entry.getKey() +
                " | Value : " + entry.getValue()
            );
        }

        System.out.println("\n--- Null Handling ---");

        /**
         * Hashtable does NOT allow null keys or values
         * Attempting to insert null will throw NullPointerException
         */
        try {
            table.put(5, null);     // ❌ Null value not allowed
        } catch (Exception e) {
            System.out.println("Error inserting null value: " + e);
        }

        try {
            table.put(null, "Test"); // ❌ Null key not allowed
        } catch (Exception e) {
            System.out.println("Error inserting null key: " + e);
        }

        System.out.println("\nFinal Hashtable: " + table);
    }
}