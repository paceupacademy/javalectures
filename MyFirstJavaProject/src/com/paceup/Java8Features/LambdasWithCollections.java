package com.paceup.Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * LambdasWithCollections:
 * ------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Lambda Expressions**:
 *    - Provide a concise way to represent functional interfaces.
 *    - Syntax: (parameters) -> expression or (parameters) -> { statements }.
 *
 * 2. **Method References**:
 *    - Shortcut to refer to existing methods instead of writing lambdas.
 *    - Types: object::instanceMethod, Class::staticMethod, Class::new (constructor reference).
 *
 * 3. **Streams API**:
 *    - Introduced in Java 8 for functional-style operations on collections.
 *    - Supports intermediate operations (map, filter) and terminal operations (forEach, count).
 *
 * 4. **Supplier<T>**:
 *    - Functional interface that supplies objects without taking input.
 *    - Method: get() → returns an object.
 *
 * Use Cases:
 * ----------
 * - Sorting collections with lambdas.
 * - Filtering and transforming data using streams.
 * - Using constructor references with Supplier.
 */
class Student {
    Student() {
        System.out.println("Student created");
    }
}

public class LambdasWithCollections {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob", "David", "Arjun");

        // Example 1: Sorting using lambda expression
        names.sort((a, b) -> a.compareTo(b)); // natural ordering (alphabetical)
        System.out.println("Sorted Names: " + names);

        // Example 2: Stream operations (map + filter + forEach)
        System.out.println("\nNames starting with 'A' (converted to uppercase):");
        names.stream() // convert list to stream
             .map(String::toUpperCase) // transform each name to uppercase
             .filter(name -> name.startsWith("A")) // keep names starting with 'A'
             .forEach(System.out::println); // print each name

        // Example 3: Counting even numbers in a list
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        long evenCount = nums.stream()
                             .filter(n -> n % 2 == 0) // keep only even numbers
                             .count(); // count them
        System.out.println("\nEven numbers count: " + evenCount);

        // Example 4: Constructor reference using Supplier
        Supplier<Student> studentSupplier = Student::new; // constructor reference
        Student s1 = studentSupplier.get(); // creates new Student object
        Student s2 = studentSupplier.get(); // creates another Student object
    }
}
