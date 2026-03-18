package com.paceup.Java8Features;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * OperatorExample:
 * ----------------
 * Theoretical Notes:
 * ------------------
 * 1. UnaryOperator<T>:
 *    - Specialization of Function<T,T>.
 *    - Takes one argument of type T and returns a result of type T.
 *    - Example: squaring a number.
 *
 * 2. BinaryOperator<T>:
 *    - Specialization of BiFunction<T,T,T>.
 *    - Takes two arguments of type T and returns a result of type T.
 *    - Example: adding two numbers.
 *
 * 3. Use Cases:
 *    - UnaryOperator → transformations like increment, negate, square.
 *    - BinaryOperator → aggregation like sum, max, min, multiplication.
 */
public class OperatorExample {
    public static void main(String[] args) {
        // Example 1: UnaryOperator (square of a number)
        // Input: 78
        // Output: 78 * 78 = 6084
        // 78 ---> [UnaryOperator: n*n] ---> 6084
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("Square of 78: " + square.apply(78));

        // Example 2: BinaryOperator (sum of two numbers)
        // Input: (7, 73)
        // Output: 7 + 73 = 80
        // (7,73) ---> [BinaryOperator: a+b] ---> 80
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum of 7 and 73: " + add.apply(7, 73));

        // Example 3: UnaryOperator (increment by 1)
        // Input: 99
        // Output: 99 + 1 = 100
        // 99 ---> [UnaryOperator: n+1] ---> 100
        UnaryOperator<Integer> increment = n -> n + 1;
        System.out.println("Increment 99: " + increment.apply(99));

        // Example 4: BinaryOperator (find maximum of two numbers)
        // Input: (45, 78)
        // Output: max = 78
        // (45,78) ---> [BinaryOperator: max] ---> 78
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("Max of 45 and 78: " + max.apply(45, 78));

        // Example 5: BinaryOperator (multiplication)
        // Input: (12, 11)
        // Output: 12 * 11 = 132
        // (12,11) ---> [BinaryOperator: a*b] ---> 132
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiplication of 12 and 11: " + multiply.apply(12, 11));
    }
}
