package com.paceup.ExceptionHandling;

/**
 * MultipleExceptionsExample:
 * --------------------------
 * 
 * Exception Handling Basics:
 * - Exceptions are events that disrupt normal program flow.
 * - Different exceptions require different handling logic.
 * - Multiple catch blocks allow handling of specific exceptions separately.
 * 
 * Key Points:
 * -----------
 * 1. **Execution stops at the first exception**:
 *    - Once an exception occurs, the remaining code in the try block is skipped.
 *    - Control jumps directly to the matching catch block.
 * 
 * 2. **Order of catch blocks matters**:
 *    - More specific exceptions must be caught before general ones.
 *    - If `Exception` (general) is placed first, specific exceptions will never be reached.
 * 
 * 3. **Common Runtime Exceptions in this example**:
 *    - ArrayIndexOutOfBoundsException → accessing invalid array index.
 *    - ArithmeticException → divide by zero.
 * 
 * 4. **finally block**:
 *    - Executes regardless of whether an exception occurs.
 *    - Useful for cleanup operations (e.g., closing files, releasing resources).
 */
public class MultipleExceptionsExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};

            // This line throws ArrayIndexOutOfBoundsException
            System.out.println(numbers[5]);

            // This line would throw ArithmeticException (if reached)
            int result = 10 / 0;

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid array index access
            System.out.println("Array index is out of bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            // Handles divide by zero
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } finally {
            // Always executes regardless of exception
            System.out.println("Execution completed.");
        }
    }
}
