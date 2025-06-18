package com.paceup.day16;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    // Static list holds references to objects indefinitely
    private static List<Object> staticList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            // Adding objects to the static list
            staticList.add(new Object());
        }
        System.out.println("Objects added to the static list.");
        // Even though the objects are no longer needed, they are still referenced by staticList
    }
}
