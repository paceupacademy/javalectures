package com.paceup.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UpperBoundWildcardExample:
 * --------------------------
 * Theoretical Notes:
 * ------------------
 * 1. Wildcard (?) :
 *    - Represents an unknown type in generics.
 *
 * 2. Upper Bound Wildcard (<? extends T>):
 *    - Producer (read-only).
 *    - Example: List<? extends Number> → can accept List<Integer>, List<Double>.
 *    - You can read elements as type Number, but cannot add new elements (except null).
 *
 * 3. Unbounded Wildcard (<?>):
 *    - Type is unknown.
 *    - Allows reading elements as Object.
 *    - Example: List<?> → can accept any type of list.
 *
 * 4. Lower Bound Wildcard (<? super T>):
 *    - Consumer (write/add).
 *    - Example: List<? super Integer> → can accept List<Integer>, List<Number>, List<Object>.
 *    - You can safely add Integer values, but reading returns Object.
 *
 * 5. PECS Rule:
 *    - Producer(?) Extends → use `extends` when you only read.
 *    - Consumer(?) Super → use `super` when you only write.
 *    
 *    - (UpperBound)If it gives -> extends, (LowerBound)if it takes -> super
 */
public class UpperBoundWildcardExample {
    // Upper Bound Wildcard: read-only producer
	/*
	 * It can accept any list of a type that is a subclass of Number, like Integer or Double or Float
	 * source of T values
	 * If a collection is producing data ( you are reading from it)
	 * ? extends T
	 */
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Unbounded Wildcard: unknown type, read as Object
    /* Read Everything , add nothing 
     * ? = Represents unknown type - could be anything(Object, Integer, String, etc.)
     * <?> = "I don't know the type"
     */
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Lower Bound Wildcard: consumer, allows adding Integers
    /*
     * destination for T values
     * If a collections is consuming data ( you are adding to it)
     * 
     * ? super T
     */
    public static void addNumbers(List<? super Integer> list) {
        list.add(100);
        list.add(300);
        list.add(205);

        printList(list); // prints added values
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1: Upper Bound Wildcard ===");
        // Example 1: Upper Bound Wildcard
        // Input: List<Integer> [1,2,3]
        // Output: "1 2 3"
        // [1,2,3] ---> [List<? extends Number>] ---> printNumbers
        List<Integer> intList = List.of(1, 2, 3, 4);
        printNumbers(intList);
        //intList.remove(1);

        // Input: List<Double> [1.1,2.2,3.3]
        // Output: "1.1 2.2 3.3"
        // [1.1,2.2,3.3] ---> [List<? extends Number>] ---> printNumbers
        /*
         * List.of() : Introduced in Java 9
         * -> Immutable Cannot add or remove elements 
         * -> No null elements allowed
         * -> Fixed size
         * -> Maintain the order of insertion
         */
		List<Double> doubleList = List.of(1.1, 2.2, 3.3, 4.4);
        printNumbers(doubleList);

        System.out.println("\n=== Example 2: Unbounded Wildcard ===");
        // Example 2: Unbounded Wildcard
        // Input: List<String> ["Apple","Banana","Cherry"]
        // Output: "Apple Banana Cherry"
        // ["Apple","Banana","Cherry"] ---> [List<?>] ---> printList
        List<String> strList = Arrays.asList("Apple", "Banana", "Cherry");
        printList(strList);

        // Input: List<Integer> [1,2,3]
        // Output: "1 2 3"
        // [1,2,3] ---> [List<?>] ---> printList
        printList(intList);

        System.out.println("\n=== Example 3: Lower Bound Wildcard ===");
        // Example 3: Lower Bound Wildcard
        // Input: Empty List<Number>
        // Added: 100,300,205
        // Output: "100 300 205"
        // [] ---> [List<? super Integer>] ---> addNumbers ---> [100,300,205]
        List<Number> numList = new ArrayList<>();
        addNumbers(numList);

        // Input: Empty List<Object>
        // Added: 100,300,205
        // Output: "100 300 205"
        // [] ---> [List<? super Integer>] ---> addNumbers ---> [100,300,205]
        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
    }
}

// Object -> Number -> Integer
// Vehicle -> Car -> Sedan

/*
 * <?> -> Unknown type for reading Object adding not possible
 * <? extends T> -> Producer reading using subclass adding not possible
 * <? super T> -> Consumer reading within limit adding through super class
 */
