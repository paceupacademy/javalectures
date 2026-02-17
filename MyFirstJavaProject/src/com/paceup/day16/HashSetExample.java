package com.paceup.day16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates usage of HashSet in Java.
 * 
 * HashSet implements Set interface:
 * - Stores unique elements (no duplicates).
 * - No guaranteed order of elements.
 * - Backed internally by a HashMap (hashtable).
 * 
 * Hashtable basics:
 * - Formula for bucket index:
 *      index = hashCode(key) & (capacity - 1)
 *   (bitwise AND ensures index is within current capacity).
 * - Capacity starts at 16 by default, load factor = 0.75.
 * - Threshold = capacity * loadFactor → when exceeded, capacity doubles.
 * - Collisions (same index for different keys) are handled by linked lists or balanced trees inside that bucket.
 * 
 * Example Representation:
 *   HashSet("Apple", "Banana", "Mango")
 *   Internally → Hashtable buckets (capacity=16):
 *   [0] → null
 *   [1] → Apple
 *   [2] → Banana
 *   [4] → Mango
 *   ...
 *   (actual bucket depends on hashCode of each string).
 */
public class HashSetExample {
    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        System.out.println("Set is Empty: " + set.isEmpty());
        
        // Add elements
        set.add("Apple"); 
        /*
         * Hashcode for Apple:
         * 
         */
        // Bucket formula: index = hashCode("Apple") & (16 - 1)
        // Example: hashCode("Apple") = 2031744 → 2031744 & 15 = 0 → bucket[0]
        
        set.add("Banana");  
        // Bucket formula: index = hashCode("Banana") & (16 - 1)
        // Example: hashCode("Banana") = -1396355221 → (-1396355221 & 15) = 11 → bucket[11]
        
        System.out.println("Size of Set: " + set.size()); // 2
        
        // Attempt to add duplicate
        set.add("Apple"); // Duplicate ignored (already in bucket[0])
        System.out.println("After adding duplicate: " + set);
        
        // Remove element
        set.remove("Apple"); // removes from bucket[0]
        System.out.println("After removing Apple: " + set);
        
        // Check membership
        System.out.println("Contains Apple? " + set.contains("Apple"));
        System.out.println("Contains Mango? " + set.contains("Mango"));
        
        // Add more elements
        set.add("Apple");   
        // Again goes to bucket[0]
        
        set.add("Mango");   
        // Bucket formula: index = hashCode("Mango") & (16 - 1)
        // Example: hashCode("Mango") = 74127464 → 74127464 & 15 = 8 → bucket[8]
        
        System.out.println("After adding Apple & Mango: " + set);
        
        set.add("Lemon");   
        // Bucket formula: index = hashCode("Lemon") & (16 - 1)
        // Example: hashCode("Lemon") = 2331023 → 2331023 & 15 = 15 → bucket[15]
        
        System.out.println("Final Set before iteration: " + set);
        
        // Traversing using Iterator
        Iterator<String> iterator = set.iterator();
        System.out.println("Iterating elements:");
        while (iterator.hasNext()) {
            String element = iterator.next();
            int hash = element.hashCode();
            int bucketIndex = hash & (16 - 1); // capacity=16 initially
            System.out.println("Element: " + element + 
                               " | HashCode: " + hash + 
                               " | Bucket Index: " + bucketIndex);
        }
        
        // Clear all elements
        set.clear();
        System.out.println("After clear: " + set);
        
        // Create HashSet from a List
        List<String> list = Arrays.asList("C", "Q", "A");
        HashSet<String> hs = new HashSet<>(list);
        System.out.println("HashSet created from List: " + hs);
    }
}
