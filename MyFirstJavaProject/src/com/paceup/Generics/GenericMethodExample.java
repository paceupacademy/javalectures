package com.paceup.Generics;

/**
 * GenericMethodExample:
 * ---------------------
 * Demonstrates how to define and use a **Generic Method** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Generic Method**:
 *    - Declared with type parameters (e.g., <T>).
 *    - Works with any type of data without rewriting code.
 *
 * 2. **Type Parameter <T>**:
 *    - Acts as a placeholder for the actual type.
 *    - Compiler replaces <T> with the actual type at compile time.
 *
 * 3. **Advantages**:
 *    - Code reusability: one method works for multiple data types.
 *    - Type safety: prevents runtime ClassCastException.
 *    - Cleaner code: no explicit casting required.
 *
 * Backend Working:
 * ----------------
 * - `printArray(T[] array)`:
 *   → Compiler ensures type safety by replacing T with the actual type (Integer, String, etc.).
 *   → For `Integer[]`, T = Integer.
 *   → For `String[]`, T = String.
 *
 * - For-each loop iterates over elements of the array regardless of type.
 *
 * Expected Output:
 * ----------------
 * Integer Array: 1 2 3 4 
 * String Array: A B C
 */
public class GenericMethodExample {
    // Generic Method
    public static <T> void printArray(T[] array) { 
        // Works with any type of array (Integer[], String[], Double[], etc.)
        for (T element : array) { 
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4}; // Integer is a wrapper class
        String[] stringArray = {"A", "B", "C"};

        System.out.print("Integer Array: ");
        printArray(intArray); // T = Integer

        System.out.print("String Array: ");
        printArray(stringArray); // T = String
    }
}
