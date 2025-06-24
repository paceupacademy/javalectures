package com.paceup.day16;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "Mohan", "Aditi", "Ravi");
        System.out.println("List: " + names);
        Collections.sort(names); // Sort in natural order
        System.out.println("Sorted List: " + names);
        
        Collections.reverse(names); // Reverse the list
        System.out.println("Reversed List: " + names);
        
        Collections.shuffle(names); // Shuffle the list
        System.out.println("Shuffled List: " + names);
        
        List<Integer> numbers = Arrays.asList(10, 20, 5, 15, 30);
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("List: " + numbers);
        System.out.println("Min: " + min + ", Max: " + max);
        int index = Collections.binarySearch(numbers, 30); // Performs a binary search on a sorted list.
        System.out.println("Index of 30: " + index);
        
        List<String> items = Arrays.asList("Apple", "Banana", "Apple", "Cherry", "Apple");
        int count = Collections.frequency(items, "Apple"); //Counts the occurrences of an element in a collection.
        System.out.println("List: " + items);
        System.out.println("Frequency of 'Apple': " + count);
        
        List<String> source = Arrays.asList("A", "B", "C");
        
        System.out.println("Before Filled List: " + source);
        Collections.fill(source, "D"); // Fill the list with "D"
        System.out.println("Filled List: " + source);
        
        List<String> destination = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        Collections.copy(destination, source); // Copy source to destination
        System.out.println("Destination List: " + destination);
    }
}

