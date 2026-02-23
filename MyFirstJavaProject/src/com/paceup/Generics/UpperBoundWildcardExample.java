package com.paceup.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UpperBoundWildcardExample:
 * --------------------------
 * Demonstrates **Wildcards in Generics** and the **PECS Rule** (Producer Extends, Consumer Super).
 *
 * Key Concepts:
 * -------------
 * 1. **Wildcard (?)**:
 *    - Represents an unknown type in generics.
 *
 * 2. **Upper Bound Wildcard (<? extends T>)**:
 *    - Used when a collection produces values (read-only).
 *    - Example: List<? extends Number> → can accept List<Integer>, List<Double>, etc.
 *    - You can read elements as type Number, but cannot add new elements (except null).
 *
 * 3. **Unbounded Wildcard (<?>)**:
 *    - Used when type is unknown.
 *    - Allows reading elements as Object.
 *    - Example: List<?> → can accept any type of list.
 *
 * 4. **Lower Bound Wildcard (<? super T>)**:
 *    - Used when a collection consumes values (write/add).
 *    - Example: List<? super Integer> → can accept List<Integer>, List<Number>, List<Object>.
 *    - You can safely add Integer values, but reading returns Object.
 *
 * 5. **PECS Rule**:
 *    - Producer Extends → use `extends` when you only read.
 *    - Consumer Super → use `super` when you only write.
 *
 * Backend Working:
 * ----------------
 * - Compiler enforces type safety by restricting what can be added/read.
 * - `<? extends Number>` → ensures list elements are subclasses of Number.
 * - `<? super Integer>` → ensures list can accept Integer values.
 * - `<?>` → allows iteration over unknown types as Object.
 *
 * Expected Output:
 * ----------------
 * 1 2 3 
 * 1.1 2.2 3.3 
 * Apple Banana Cherry 
 * 1 2 3 
 * 100 300 205 
 * 100 300 205 
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
        // Upper Bound Wildcard
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        printNumbers(intList);    // prints integers
        printNumbers(doubleList); // prints doubles

        // Unbounded Wildcard
        List<String> strList = Arrays.asList("Apple", "Banana", "Cherry");
        printList(strList);       // prints strings
        printList(intList);       // prints integers

        // Lower Bound Wildcard
        List<Number> numList = new ArrayList<>(); // Number is superclass of Integer
        addNumbers(numList);      // adds integers

        List<Object> objList = new ArrayList<>(); // Object is superclass of Integer
        addNumbers(objList);      // adds integers
    }
}

// Object -> Number -> Integer
// Vehicle -> Car -> Sedan
