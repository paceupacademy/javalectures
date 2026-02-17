package com.paceup.day16;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * Vector:
 * - Legacy class (introduced early in Java).
 * - Implements List, Collection, Iterable.
 * - Dynamic array that grows automatically.
 * - Maintains insertion order, allows duplicates.
 * - Synchronized (thread-safe).
 */
public class VectorExample {
    public static void main(String[] args) {
        
        // Create Vectors
        Vector<String> vector = new Vector<>();              // default capacity (10)
        Vector<String> v = new Vector<>(20);                 // with initial capacity
        Vector<String> v1 = new Vector<>(10, 5);             // initial capacity + capacity increment

        // Add elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        vector.add("Banana");           // duplicate allowed
        vector.add("Orange");
        vector.add(3, "Banana");        // insert at index 3
        vector.add("Lemons");
        vector.add("Banana");

        // Access elements
        System.out.println("First Element: " + vector.get(0));
        
        // Update element at index 0
        vector.set(0, "Guava");

        // Find index of element
        int index = vector.indexOf("Banana"); // first occurrence
        System.out.println("Banana is at index: " + index);
        
        int lastIndex = vector.lastIndexOf("Banana"); // last occurrence
        System.out.println("Banana last index: " + lastIndex);
        
        System.out.println("Vector: " + vector);

        // Frequency of element using Collections utility
        System.out.println("Frequency of Banana: " + Collections.frequency(vector, "Banana"));
        
        // Iterate through Vector using for-each loop
        int i = 0;
        for (String fruit : vector) {
            System.out.print(fruit + ", ");
            if (vector.get(i).equals("Banana")) {
                System.out.println("Index of Banana: " + i);
            }
            i++;
        }

        /*
         * Using Streams (Java 8):
         * - IntStream.range(0, vector.size()) → generates indices.
         * - filter() → keep indices where element == "Banana".
         * - boxed() → convert primitive int to Integer.
         * - collect() → gather into a List.
         */
        List<Integer> indexVal = IntStream.range(0, vector.size())
                .filter(j -> "Banana".equals(vector.get(j)))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Indices of Banana: " + indexVal);
        System.out.println("Size of vector: " + vector.size());
        System.out.println("Capacity of vector: " + vector.capacity());

        System.out.println("Before Removal: " + vector);

        /*
         * Removing elements:
         * - remove(Object o) → removes first occurrence.
         * - removeAll(Collection c) → removes all elements present in collection c.
         */
        vector.remove("Banana"); // removes first occurrence
        System.out.println("Removed one Banana: " + vector);

        // removeAll with another collection
        System.out.println("All Banana removed? " + vector.removeAll(v)); // v is empty initially → false
        v.add("Banana");
        v.add("Apple");
        v.add("Watermelon");
        System.out.println("All Banana removed? " + vector.removeAll(v)); // removes Banana & Apple if present

        System.out.println("After Removal: " + vector);
    }
}
