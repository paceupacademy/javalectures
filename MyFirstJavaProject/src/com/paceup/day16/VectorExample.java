package com.paceup.day16;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        // Create a Vector
        Vector<String> vector = new Vector<>(); //maintains order and synchronized, allows duplicates

        // Add elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Access elements
        System.out.println("First Element: " + vector.get(0));

        // Iterate through the Vector
        for (String fruit : vector) {
            System.out.print(fruit+", ");
        }

        // Remove an element
        vector.remove("Banana");
        System.out.println("After Removal: " + vector);
    }
}

