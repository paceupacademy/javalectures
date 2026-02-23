package com.paceup.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap->ConcurrentMap=>Map
 * 		||
 * 	AbstractMap->Map
 * 
 * ConcurrentHashMap:
 * - Part of java.util.concurrent package.
 * - Implements Map interface.
 * - Stores key-value pairs like HashMap but is thread-safe.
 * - Allows concurrent read and write operations without locking the entire map.
 * - Achieves concurrency by dividing the map into segments (buckets) and locking only the affected segment.
 * - Null keys and null values are NOT allowed (throws NullPointerException).
 * 
 * Internal Working:
 * -----------------
 * - Uses a hash-based structure similar to HashMap.
 * - For concurrency, it uses fine-grained locking (bucket-level) instead of locking the whole map.
 * - Multiple threads can operate safely without corrupting data.
 * - Operations like put(), get(), remove() are O(1) on average.
 * 
 * Difference from HashMap and Hashtable:
 * --------------------------------------
 * - HashMap: Not synchronized, allows one null key and multiple null values.
 * - Hashtable: Synchronized (locks entire map), no null keys/values, slower.
 * - ConcurrentHashMap: Thread-safe with better performance (locks only segments), no null keys/values.
 */
public class ConcurrentHashmapExample {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<>();
        
        Map<Integer,String> map2 =  new HashMap<>();
        map2.put(35, "Charlie");
        map2.put(40, "Bob");
        
        // Add key-value pairs
        cmap.put(1, "Java");
        cmap.put(2, "Spring");
        cmap.put(5, "Hibernate");
        cmap.put(4, "Database");
        System.out.println("ConcurrentHashMap entries: " + cmap);
        
        cmap.putAll(map2);
        
        System.out.println("ConcurrentHashMap entries: " + cmap);
        
        // Iteration (safe in concurrent environment)
        cmap.forEach((k, v) -> System.out.println(k + " : " + v));
        
        for(Map.Entry<Integer, String> entry: cmap.entrySet()) {
        	System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
        // Safe concurrent update using compute()
        cmap.compute(2, (key, value) -> value + " Boot"); // updates value for key 2
        System.out.println("Updated ConcurrentHashMap entries: " + cmap+"\n");
        
        // Null keys/values not allowed
        try {
            cmap.put(null, "Test"); // throws NullPointerException
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        Iterator<ConcurrentHashMap.Entry<Integer,String>> i = cmap.entrySet().iterator();
        while(i.hasNext()) {
        	ConcurrentHashMap.Entry<Integer,String> entry = i.next();
        	System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
