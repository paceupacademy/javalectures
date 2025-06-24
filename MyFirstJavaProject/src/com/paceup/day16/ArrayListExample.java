package com.paceup.day16;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Accessing elements
        System.out.println("First element: " + list.get(0));

        // Removing an element
        list.remove("Banana");

        // Iterating through the list
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // Checking size
        System.out.println("Size of the list: " + list.size());
    }
}

