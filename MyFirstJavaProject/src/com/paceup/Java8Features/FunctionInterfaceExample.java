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

        /*
         * Execution Flow:
         * Input: "Aishwarya"
         * Backend: apply() → calls s.length()
         * Output: Integer length = 9
         *
         * "Aishwarya" ---> [Function: s.length()] ---> 9
         */
        System.out.println("Length of Aishwarya: " + strLength.apply("Aishwarya"));

        /*
         * Input: "Java"
         * Backend: apply() → calls s.length()
         * Output: 4
         *
         * "Java" ---> [Function: s.length()] ---> 4
         */
        System.out.println("Length of Java: " + strLength.apply("Java"));

        // Example 2: Transformation (Square of a number)
        Function<Integer, Integer> square = n -> n * n;

        /*
         * Input: 23
         * Backend: apply() → executes n * n
         * Output: 529
         *
         * 23 ---> [Function: n*n] ---> 529
         */
        System.out.println("Square of 23: " + square.apply(23));

        /*
         * Input: 12
         * Backend: apply() → executes n * n
         * Output: 144
         *
         * 12 ---> [Function: n*n] ---> 144
         */
        System.out.println("Square of 12: " + square.apply(12));

        // Example 3: Chaining Functions with andThen()
        Function<Integer, Integer> multiBy3 = n -> n * 3;
        Function<Integer, Integer> add10 = n -> n + 10;

        /*
         * andThen chaining:
         * Step 1: multiBy3.apply(78) → 78*3 = 234
         * Step 2: add10.apply(234) → 234+10 = 244
         *
         * 78 ---> [*3] ---> 234 ---> [+10] ---> 244
         */
        System.out.println("andThen (multiBy3 -> add10): " + multiBy3.andThen(add10).apply(78));

        /*
         * Reverse chaining:
         * Step 1: add10.apply(78) → 78+10 = 88
         * Step 2: multiBy3.apply(88) → 88*3 = 264
         *
         * 78 ---> [+10] ---> 88 ---> [*3] ---> 264
         */
        System.out.println("andThen (add10 -> multiBy3): " + add10.andThen(multiBy3).apply(78));

        // Example 4: Chaining Functions with compose()
        /*
         * compose chaining:
         * Step 1: add10.apply(78) → 88
         * Step 2: multiBy3.apply(88) → 264
         *
         * 78 ---> [+10] ---> 88 ---> [*3] ---> 264
         */
        System.out.println("compose (multiBy3 after add10): " + multiBy3.compose(add10).apply(78));

        // Half transformation example
        Function<Integer, Double> half = a -> a * 4.0;
        /*
         * Compose with (a -> a/2):
         * Step 1: a/2 → 67/2 = 33
         * Step 2: original half.apply(33) → 33*4.0 = 132.0
         *
         * 67 ---> [/2] ---> 33 ---> [*4.0] ---> 132.0
         */
        half = half.compose(a -> a / 2);
        System.out.println(half.apply(67));

        // Example 5: Function with different input/output types
        Function<String, String> toUpper = s -> s.concat("Interface");
        Function<String, Integer> lengthAfterUpper = toUpper.andThen(String::length);

        /*
         * Input: "functional"
         * Step 1: toUpper.apply("functional") → "functionalInterface"
         * Step 2: length() → 19
         *
         * "functional" ---> [concat 'Interface'] ---> "functionalInterface" ---> [length()] ---> 19
         */
        System.out.println("Length after concatenating: " + lengthAfterUpper.apply("functional"));

        // Example 6: Identity function
        Function<String, String> identityFunc = Function.identity();

        /*
         * Identity simply returns input unchanged.
         * Input: "No Transformation"
         * Output: "No Transformation"
         *
         * "No Transformation" ---> [identity()] ---> "No Transformation"
         */
        System.out.println("Identity Function result: " + identityFunc.apply("No Transformation"));
    }
}
