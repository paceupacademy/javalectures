package com.paceup.ExceptionHandling;

/**
 * NestedTryCatchExample:
 * ----------------------
 * 
 * Exception Handling Basics:
 * - A try block contains code that may throw exceptions.
 * - A catch block handles exceptions thrown inside the try block.
 * - Nested try-catch allows handling different risky operations separately.
 * 
 * Key Points:
 * -----------
 * 1. **Nested try-catch**:
 *    - You can place one try-catch block inside another.
 *    - Useful when different parts of code may throw different exceptions.
 * 
 * 2. **Execution flow**:
 *    - If an exception occurs in the inner try block, its catch block handles it.
 *    - If an exception occurs in the outer try block (but not in the inner one), the outer catch block handles it.
 * 
 * 3. **Common Runtime Exceptions in this example**:
 *    - ArithmeticException → divide by zero.
 *    - ArrayIndexOutOfBoundsException → accessing invalid array index.
 * 
 * 4. **Best Practice**:
 *    - Use nested try-catch when you want fine-grained control over exception handling.
 *    - Helps isolate risky operations and handle them independently.
 */
public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};

            // This line executes successfully (no ArithmeticException here)
            int result = 10 / 2; 

            // Inner try-catch block
            try {
                // This line throws ArrayIndexOutOfBoundsException
                System.out.println(arr[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handles invalid array index access
                System.out.println("Inner catch: " + e.getMessage());
            }

        } catch (ArithmeticException e) {
            // Handles divide by zero (if it occurred in outer try block)
            System.out.println("Outer catch: Cannot divide by zero.");
        }
    }
}
