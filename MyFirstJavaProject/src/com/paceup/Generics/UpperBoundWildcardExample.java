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
 *    - Producer Extends → use `extends` when you only read.
 *    - Consumer Super → use `super` when you only write.
 */
public class UpperBoundWildcardExample {
    // Upper Bound Wildcard: read-only producer
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Unbounded Wildcard: unknown type, read as Object
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Lower Bound Wildcard: consumer, allows adding Integers
    public static void addNumbers(List<? super Integer> list) {
        list.add(100);
        list.add(300);
        list.add(205);

        printList(list); // prints added values
    }

    public static void main(String[] args) {
        // Example 1: Upper Bound Wildcard
        // Input: List<Integer> [1,2,3]
        // Output: "1 2 3"
        // [1,2,3] ---> [List<? extends Number>] ---> printNumbers
        List<Integer> intList = List.of(1, 2, 3);
        printNumbers(intList);

        // Input: List<Double> [1.1,2.2,3.3]
        // Output: "1.1 2.2 3.3"
        // [1.1,2.2,3.3] ---> [List<? extends Number>] ---> printNumbers
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        printNumbers(doubleList);

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
