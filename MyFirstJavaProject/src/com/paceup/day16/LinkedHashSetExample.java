package com.paceup.day16;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 
 * LinkedHashSet:
 * - Implements Set interface.
 * - Maintains insertion order (unlike HashSet).
 * - Does not allow duplicate elements.
 * - Backed internally by a HashMap.
 * 
 * How LinkedHashSet works internally:
 * - It uses a HashMap to store elements.
 * - Each element is stored as a key in the HashMap, with a dummy constant object as the value.
 * - HashMap uses buckets (array + linked list/tree structure) to store keys based on their hashCode().
 * - LinkedHashSet adds a doubly-linked list on top of HashMap to maintain insertion order.
 * 
 * Representation Example:
 *   LinkedHashSet("Apple", "Banana", "Cherry")
 *   Internally → HashMap buckets:
 *   [0] → Apple (dummyValue)
 *   [1] → Banana (dummyValue)
 *   [2] → Cherry (dummyValue)
 *   ...
 *   And a linked list maintains order: Apple → Banana → Cherry
 */
public class LinkedHashSetExample {
    public static void main(String[] args) {
        
        // Create a LinkedHashSet of Strings
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        // Check if set is empty
        System.out.println("Set is Empty: " + set.isEmpty());
        
        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate → ignored
        System.out.println("After adding elements: " + set); // Maintains insertion order
        
        // Remove element
        set.remove("Apple");
        System.out.println("After removing Apple: " + set);
        
        // Check membership
        System.out.println("Contains Dog? " + set.contains("Dog")); // false
        
        // Add more elements
        set.add("Apple");
        set.add("Lemons");
        set.add("Watermelon");
        set.add("Cherry");
        
        // Size and emptiness check
        System.out.println("Size of set: " + set.size());
        System.out.println("Set is Empty: " + set.isEmpty());
        
        // Iterating using Iterator (in insertion order)
        System.out.print("Iterating elements: ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
        // Clear all elements
        set.clear();
        System.out.println("\nAfter clear: " + set + " | Is Empty? " + set.isEmpty());
    }
}
