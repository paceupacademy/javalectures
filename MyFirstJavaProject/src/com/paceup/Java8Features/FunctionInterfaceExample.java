package com.paceup.Java8Features;

import java.util.function.Function;

/**
 * FunctionInterfaceExample:
 * -------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Function<T,R>**:
 *    - A functional interface introduced in Java 8.
 *    - Represents a function that takes an input of type T and produces a result of type R.
 *    - Method: `apply(T t)` → applies the function logic and returns a result.
 *
 * 2. **andThen()**:
 *    - Chains functions sequentially.
 *    - First applies the current function, then applies the next function on the result.
 *
 * 3. **compose()**:
 *    - Chains functions in reverse order.
 *    - First applies the given function, then applies the current function on the result.
 *
 * 4. **Use Cases**:
 *    - Transforming data (e.g., String → Integer, Integer → Square).
 *    - Function chaining for complex transformations.
 *    - Useful in Streams API for mapping and transformations.
 *
 * 5. **Difference from Consumer<T>**:
 *    - Function<T,R> → takes input and produces output.
 *    - Consumer<T> → takes input and performs an action, no output.
 */
public class FunctionInterfaceExample {
    public static void main(String[] args) {
        // Example 1: String length function
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Length of Aishwarya: " + strLength.apply("Aishwarya"));
        System.out.println("Length of Java: " + strLength.apply("Java"));

        // Example 2: Transformation (Square of a number)
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Square of 23: " + square.apply(23));
        System.out.println("Square of 12: " + square.apply(12));

        // Example 3: Chaining Functions with andThen()
        Function<Integer, Integer> multiBy3 = n -> n * 3;
        Function<Integer, Integer> add10 = n -> n + 10;

        // First multiply by 3, then add 10
        System.out.println("andThen (multiBy3 -> add10): " + multiBy3.andThen(add10).apply(78));

        // First add 10, then multiply by 3
        System.out.println("andThen (add10 -> multiBy3): " + add10.andThen(multiBy3).apply(78));

        // Example 4: Chaining Functions with compose()
        // First add 10, then multiply by 3
        System.out.println("compose (multiBy3 after add10): " + multiBy3.compose(add10).apply(78));

        // Example 5: Function with different input/output types
        Function<String, String> toUpper = s -> s.toUpperCase();
        Function<String, Integer> lengthAfterUpper = toUpper.andThen(String::length);
        System.out.println("Length after converting to uppercase: " + lengthAfterUpper.apply("functionalInterface"));

        // Example 6: Identity function (returns input as output)
        Function<String, String> identityFunc = Function.identity();
        System.out.println("Identity Function result: " + identityFunc.apply("No Transformation"));
    }
}
