package com.paceup.ExceptionHandling;

/**
 * ThrowExample:
 * -------------
 * This program demonstrates the difference between `throw` and `throws` in Java.
 * 
 * Key Concepts:
 * -------------
 * 1. **throw**:
 *    - Used inside a method to actually throw an exception object.
 *    - Example: `throw new IllegalArgumentException("Message");`
 * 
 * 2. **throws**:
 *    - Declares that a method may throw an exception.
 *    - Informs the caller that it must handle or propagate the exception.
 *    - Example: `public void method() throws IOException`
 * 
 * 3. **Checked vs Unchecked Exceptions**:
 *    - Checked exceptions (e.g., IOException) must be declared with `throws`.
 *    - Unchecked exceptions (e.g., IllegalArgumentException, NullPointerException) 
 *      don’t require declaration but can still be thrown.
 * 
 * In this example:
 * - The method `checkAge()` declares `throws IllegalArgumentException`.
 * - If age < 18, it uses `throw` to actually throw the exception.
 * - The caller handles the exception using try-catch.
 */
public class ThrowExample {
    
    // Method declares it may throw IllegalArgumentException
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            // Actually throwing an exception object
            throw new IllegalArgumentException("Age must be 18 or above.");
        } else {
            System.out.println("Correct Age Entered");
        }
    }

    public static void main(String[] args) {
        try {
            // This call throws an exception because age < 18
            checkAge(16);
        } catch (IllegalArgumentException e) {
            // Exception is caught here
            System.out.println("Exception caught: " + e.getMessage());
            
            // Second call with valid age → no exception
            checkAge(20);
        }
    }
}
