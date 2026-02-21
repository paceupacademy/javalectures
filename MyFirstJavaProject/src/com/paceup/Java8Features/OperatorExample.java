package com.paceup.Java8Features;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * OperatorExample:
 * ----------------
 * 
 * Key Concepts:
 * -------------
 * 1. **UnaryOperator<T>**:
 *    - A specialization of Function<T,T>.
 *    - Takes a single argument of type T and returns a result of the same type T.
 *    - Example: squaring a number.
 *
 * 2. **BinaryOperator<T>**:
 *    - A specialization of BiFunction<T,T,T>.
 *    - Takes two arguments of type T and returns a result of the same type T.
 *    - Example: adding two numbers.
 *
 * 3. **Use Cases**:
 *    - UnaryOperator → transformations like increment, negate, square.
 *    - BinaryOperator → aggregation like sum, max, min, multiplication.
 */
public class OperatorExample {
    public static void main(String[] args) {
        // Example 1: UnaryOperator (square of a number)
        UnaryOperator<Integer> square = n -> n * n; // Equivalent to Function<Integer,Integer>
        System.out.println("Square of 78: " + square.apply(78));

        // Example 2: BinaryOperator (sum of two numbers)
        BinaryOperator<Integer> add = (a, b) -> a + b; // Equivalent to BiFunction<Integer,Integer,Integer>
        System.out.println("Sum of 7 and 73: " + add.apply(7, 73));

        // Example 3: UnaryOperator (increment by 1)
        UnaryOperator<Integer> increment = n -> n + 1;
        System.out.println("Increment 99: " + increment.apply(99));

        // Example 4: BinaryOperator (find maximum of two numbers)
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("Max of 45 and 78: " + max.apply(45, 78));

        // Example 5: BinaryOperator (multiplication)
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiplication of 12 and 11: " + multiply.apply(12, 11));
    }
}
