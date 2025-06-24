package com.paceup.day16;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println(" Arraylist: "+list);

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Accessing elements
        System.out.println("First element: " + list.get(2));

        // Removing an element
        list.remove("Banana");

        // Iterating through the list
        for (String fruit : list) {
            System.out.println(fruit);
        }
        
        ArrayList<String> extra = new ArrayList<>(Arrays.asList("Watermelon","Lemon","Guava"));
        list.addAll(extra);

     // Iterating through the list
        for (String fruit : list) {
            System.out.println(fruit);
        }
        
        System.out.println("ArrayList: "+list);
        // Checking size
        System.out.println("Size of the list: " + list.size());
    }
}

