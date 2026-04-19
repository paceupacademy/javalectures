package com.paceup.Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * LinkedHashSet:
 * - Extends HashSet and implements Set interface.
 * - Maintains insertion order (unlike HashSet which does not guarantee order).
 * - Does not allow duplicate elements.
 * - Backed internally by a HashMap.
 * 
 * Internal Working:
 * -----------------
 * - Each element is stored as a key in a HashMap with a dummy constant value.
 * - HashMap uses buckets (array + linked list/tree) to store keys based on hashCode().
 * - LinkedHashSet adds a doubly-linked list across all entries to preserve insertion order.
 * 
 * Representation Example:
 * -----------------------
 * LinkedHashSet("Apple", "Banana", "Cherry")
 * Internally → HashMap buckets:
 *   [0] → Apple (dummyValue)
 *   [1] → Banana (dummyValue)
 *   [2] → Cherry (dummyValue)
 * And a linked list maintains order:
 *   Head → Apple → Banana → Cherry → Tail
 */
public class LinkedHashSetExample {
    public static void main(String[] args) {

        System.out.println("=========== LINKED HASHSET ==========");

        // Create a LinkedHashSet of Strings
        LinkedHashSet<String> set = new LinkedHashSet<>();

        System.out.println("\n--- Initial State ---");
        System.out.println("Set is Empty: " + set.isEmpty());

        System.out.println("\n--- Adding Elements ---");

        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("apple"); // Different case → treated as unique element

        System.out.println("After adding elements (insertion order maintained): " + set);

        System.out.println("\n--- HashSet Comparison (No Order Guarantee) ---");

        // Demonstrating HashSet (no order guarantee)
        List<String> list = Arrays.asList("Apple", "apple");
        HashSet<String> hs = new HashSet<>(list);

        System.out.println("HashSet created from List: " + hs);

        System.out.println("\n--- removeAll Operation ---");

        // Remove all elements present in another collection
        set.removeAll(hs); // removes "Apple" and "apple"
        System.out.println("After removing elements from HashSet: " + set);

        System.out.println("\n--- Membership Check ---");

        // Membership check
        System.out.println("Contains 'Dog'? " + set.contains("Dog"));

        System.out.println("\n--- Adding More Elements ---");

        // Add more elements
        set.add("Apple");
        set.add("Lemons");
        set.add("Watermelon");
        set.add("Cherry");

        System.out.println("Current Set: " + set);

        System.out.println("\n--- Size & State ---");

        // Size and emptiness check
        System.out.println("Size of set: " + set.size());
        System.out.println("Set is Empty: " + set.isEmpty());

        System.out.println("\n--- Iteration (Insertion Order) ---");

        /**
         * Iterator returns elements in insertion order
         * (this is the key difference from HashSet)
         */
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n\n--- Clearing Set ---");

        // Clear all elements
        set.clear();
        System.out.println("After clear: " + set + " | Is Empty? " + set.isEmpty());

        /*
         * retainAll Example:
         * - Keeps only elements that are common between two sets.
         */
        System.out.println("\n--- retainAll Example ---");

        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8));

        System.out.println("Set 1: " + s1);
        System.out.println("Set 2: " + s2);

        // Retain only elements common in both sets
        s2.retainAll(s1);

        System.out.println("Modified Set 2 after retainAll: " + s2);
    }
}