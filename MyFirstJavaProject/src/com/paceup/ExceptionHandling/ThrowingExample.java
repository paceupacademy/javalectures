package com.paceup.ExceptionHandling;

/**
 * ThrowingExample:
 * ----------------
 * 
 * Key Concepts:
 * -------------
 * 1. **throw**:
 *    - Used inside a method or block to actually throw an exception object.
 *    - Example: `throw new IllegalArgumentException("Message");`
 * 
 * 2. **Unchecked Exception**:
 *    - IllegalArgumentException is an unchecked exception (subclass of RuntimeException).
 *    - It does not need to be declared with `throws` in the method signature.
 * 
 * 3. **Exception Handling**:
 *    - The caller must handle exceptions using try-catch.
 *    - Once an exception is thrown, normal execution stops and control jumps to the catch block.
 * 
 * In this example:
 * - The method `validateNumber()` throws IllegalArgumentException if the number is negative.
 * - The main method calls `validateNumber(-5)` which throws an exception.
 * - The catch block handles it and then calls `validateNumber(90)` successfully.
 */
public class ThrowingExample {
    public static void main(String[] args) {
        try {
            // This call throws an exception because number < 0
            validateNumber(-5);
        } catch (IllegalArgumentException e) {
            // Exception is caught here
            System.out.println("Exception caught: " + e.getMessage());

            // Second call with valid number → no exception
            validateNumber(90);
        }
    }

    /**
     * Validates that the number is non-negative.
     * @param number The number to validate
     * @throws IllegalArgumentException if number < 0
     */
    public static void validateNumber(int number) {
        if (number < 0) {
            // Actually throwing an exception object
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        System.out.println("Valid number: " + number);
    }
}
