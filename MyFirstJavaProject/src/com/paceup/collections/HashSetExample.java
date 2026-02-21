package com.paceup.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * HashSet:
 * - Implements Set interface.
 * - Stores unique elements (no duplicates).
 * - No guaranteed order of elements.
 * - Backed internally by a HashMap (hashtable).
 * - The hashtable is specifically a HashMap instance.
 * 
 * Hashtable Basics:
 * -----------------
 * - Elements are stored in "buckets" based on their hashCode.
 * - Formula for bucket index:
 *      index = hashCode(key) & (capacity - 1)
 *   (bitwise AND ensures index is within current capacity).
 * - Default capacity = 16, load factor = 0.75.
 * - Threshold = capacity * loadFactor → when exceeded, capacity doubles.
 * - Collisions (same index for different keys) are handled by linked lists or balanced trees inside that bucket.
 * 
 * Example Representation (capacity=16):
 * -------------------------------------
 * HashSet("Apple", "Banana", "Mango")
 * Internally → Hashtable buckets:
 * [0] → Apple
 * [8] → Mango
 * [11] → Banana
 * [others] → null
 * 
 * HashCode Calculation Example:
 * -----------------------------
 * String.hashCode() formula:
 *   h = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
 * For "Apple":
 *   hashCode("Apple") = 63476038
 *   bucketIndex = 63476038 & (16 - 1) = 14 → bucket[14]
 */
public class HashSetExample {
    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        System.out.println("Set is Empty: " + set.isEmpty());
        
        // Add elements
        set.add("Apple"); 
        // hashCode("Apple") = 63476038 → 63476038 & 15 = 14 → bucket[14]
        
        set.add("Banana");  
        // hashCode("Banana") = -1396355221 → (-1396355221 & 15) = 11 → bucket[11]
        
        System.out.println("Size of Set: " + set.size()); // 2
        
        // Attempt to add duplicate
        set.add("Apple"); // Duplicate ignored (already in bucket[14])
        System.out.println("After adding duplicate: " + set);
        
        // Remove element
        set.remove("Apple"); // removes from bucket[14]
        System.out.println("After removing Apple: " + set);
        
        // Check membership
        System.out.println("Contains Apple? " + set.contains("Apple"));
        System.out.println("Contains Mango? " + set.contains("Mango"));
        
        // Add more elements
        set.add("Apple");   // bucket[14]
        
        set.add("Mango");   
        // hashCode("Mango") = 74127464 → 74127464 & 15 = 8 → bucket[8]
        
        System.out.println("After adding Apple & Mango: " + set);
        
        set.add("Lemon");   
        // hashCode("Lemon") = 2331023 → 2331023 & 15 = 15 → bucket[15]
        
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
        
        // Synchronized version (thread-safe)
        Collections.synchronizedSet(hs);
    }
}
