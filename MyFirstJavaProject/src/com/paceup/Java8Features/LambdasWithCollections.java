package com.paceup.Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * LambdasWithCollections:
 * ------------------------
 * Theoretical Notes:
 * ------------------
 * 1. Lambda Expressions:
 *    - Concise way to represent functional interfaces.
 *    - Syntax: (parameters) -> expression or (parameters) -> { statements }.
 *
 * 2. Method References:
 *    - Shortcut to refer to existing methods instead of writing lambdas.
 *    - Types: object::instanceMethod, Class::staticMethod, Class::new (constructor reference).
 *
 * 3. Streams API:
 *    - Introduced in Java 8 for functional-style operations on collections.
 *    - Supports intermediate operations (map, filter) and terminal operations (forEach, count).
 *
 * 4. Supplier<T>:
 *    - Functional interface that supplies objects without taking input.
 *    - Method: get() → returns an object.
 *
 * Purpose of this Class:
 * ----------------------
 * - Demonstrates sorting with lambdas.
 * - Filtering and transforming data using streams.
 * - Counting elements with conditions.
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
        // Input: ["Alice","Charlie","Bob","David","Arjun"]
        // Output: ["Alice","Arjun","Bob","Charlie","David"]
        // names ---> [sort((a,b)->a.compareTo(b))] ---> sorted list
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted Names: " + names);

        // Example 2: Stream operations (map + filter + forEach)
        // Input: ["Alice","Arjun","Bob","Charlie","David"]
        // map → uppercase, filter → startsWith("A")
        // Output: ["ALICE","ARJUN"]
        // names ---> [map(toUpperCase) → filter(startsWith("A")) → forEach(print)]
        System.out.println("\nNames starting with 'A' (converted to uppercase):");
        names.stream()
             .map(String::toUpperCase)
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);

        // Example 3: Counting even numbers in a list
        // Input: [1,2,3,4,5,6,7,8,9]
        // filter → keep evens, count → total
        // Output: 4
        // nums ---> [filter(n%2==0) → count()] ---> 4
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        long evenCount = nums.stream()
                             .filter(n -> n % 2 == 0)
                             .count();
        System.out.println("\nEven numbers count: " + evenCount);

        // Example 4: Constructor reference using Supplier
        // Input: () → no arguments
        // Output: new Student() → "Student created"
        // () ---> [Supplier<Student>] ---> Student object
        Supplier<Student> studentSupplier = Student::new;
        Student s1 = studentSupplier.get(); // creates new Student object
        Student s2 = studentSupplier.get(); // creates another Student object
    }
}
