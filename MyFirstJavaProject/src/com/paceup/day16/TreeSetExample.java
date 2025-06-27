package com.paceup.day16;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // Add elements
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        // Display elements (sorted order)
        System.out.println("TreeSet: " + numbers);

        // Access specific elements
        System.out.println("First Element: " + numbers.first());
        System.out.println("Last Element: " + numbers.last());

        // NavigableSet methods Provides methods to navigate through set
        System.out.println("Higher than 10: " + numbers.higher(10));
        System.out.println("Lower than 10: " + numbers.lower(15));

        // Remove an element
        numbers.remove(15);
        System.out.println("After Removal: " + numbers);
    }
}

