package com.paceup.day16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * LinkedHashSet->Set=>Collection=>Iterable
 * 		||
 * 	HashSet
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
        set.add("apple"); // Duplicate → ignored
        System.out.println("After adding elements: " + set); // Maintains insertion order
        
        List<String> list = Arrays.asList("Apple", "apple");
        HashSet<String> hs = new HashSet<>(list);
        System.out.println("HashSet created from List: " + hs);
        
        // Remove element
        set.removeAll(hs);
        System.out.println("After removing all Apple: " + set);
        
        // Check membership
        System.out.println("Contains Dog? " + set.contains("Dog")); // false
        
        // Add more elements
        set.add("Apple");
        set.add("Lemons");
        set.add("Watermelon");
        set.add("Cherry");
        
        System.out.println(set);
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
        
        //Retain all example
        /*
         * HashSet<E> hs = new HashSet<E>(Collection o);
         */
        
        Set<Integer> s1 =  new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8));
        
        System.out.println("Set 1"+s1);
        System.out.println("Set 2"+s2);
        
        //Retain only the elements in s1 are also in s2
        s2.retainAll(s1);
        System.out.println("Modified set 2 after retainAll: "+s2);        
        
    }
}
