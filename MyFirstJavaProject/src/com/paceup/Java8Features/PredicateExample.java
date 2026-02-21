package com.paceup.Java8Features;

import java.util.function.Predicate;

/**
 * PredicateExample:
 * -----------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Predicate<T>**:
 *    - A functional interface introduced in Java 8.
 *    - Represents a condition (boolean-valued function) of one argument.
 *    - Method: `test(T t)` → returns true or false based on the condition.
 *
 * 2. **Default Methods**:
 *    - and(): Combines two predicates with logical AND.
 *    - or(): Combines two predicates with logical OR.
 *    - negate(): Negates the predicate result.
 *
 * 3. **Use Cases**:
 *    - Filtering collections.
 *    - Validating inputs.
 *    - Conditional checks in streams.
 */
public class PredicateExample {
    public static void main(String[] args) {
        // Example 1: Simple Predicate to check if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 7 even? " + isEven.test(7)); // false

        // Example 2: Predicate to check if a number is greater than 10
        Predicate<Integer> greaterThan10 = number -> number > 10;
        System.out.println("Is 15 > 10? " + greaterThan10.test(15)); // true
        System.out.println("Is 8 > 10? " + greaterThan10.test(8)); // false

        // Example 3: Combining Predicates with AND
        Predicate<Integer> evenAndGreaterThan10 = isEven.and(greaterThan10);
        System.out.println("Is 12 even and > 10? " + evenAndGreaterThan10.test(12)); // true
        System.out.println("Is 8 even and > 10? " + evenAndGreaterThan10.test(8)); // false

        // Example 4: Combining Predicates with OR
        Predicate<Integer> evenOrGreaterThan10 = isEven.or(greaterThan10);
        System.out.println("Is 9 even or > 10? " + evenOrGreaterThan10.test(9)); // false
        System.out.println("Is 15 even or > 10? " + evenOrGreaterThan10.test(15)); // true

        // Example 5: Negating a Predicate
        Predicate<Integer> notEven = isEven.negate();
        System.out.println("Is 7 not even? " + notEven.test(7)); // true
        System.out.println("Is 4 not even? " + notEven.test(4)); // false
    }
}
