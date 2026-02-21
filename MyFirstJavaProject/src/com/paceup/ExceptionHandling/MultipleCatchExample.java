package com.paceup.ExceptionHandling;

/**
 * MultipleCatchExample:
 * ---------------------
 * 
 * Exception Handling:
 * - Exceptions are events that disrupt normal program flow.
 * - Different exceptions require different handling logic.
 * - Multiple catch blocks allow handling of specific exceptions separately.
 * 
 * Key Points:
 * -----------
 * 1. **Order of catch blocks matters**:
 *    - More specific exceptions must be caught before general ones.
 *    - If `Exception` (general) is placed first, specific exceptions (like ArithmeticException) will never be reached.
 * 
 * 2. **Common Runtime Exceptions**:
 *    - ArrayIndexOutOfBoundsException → accessing invalid array index.
 *    - ArithmeticException → divide by zero.
 *    - Exception → general catch-all for other exceptions.
 * 
 * 3. **Best Practice**:
 *    - Catch specific exceptions first.
 *    - Use a general catch block at the end for unexpected cases.
 */
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};

            // This line throws ArrayIndexOutOfBoundsException
            System.out.println(numbers[4]);

            // This line would throw ArithmeticException (if reached)
            int sum = numbers[1] / 0;

        } catch (ArithmeticException e) {
            // Handles divide by zero
            System.out.println("Arithmetic Exception occurred.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid array index access
            System.out.println("Array Index Out Of Bounds Exception occurred.");
        } catch (Exception e) {
            // Handles any other exceptions
            System.out.println("Some other exception occurred: " + e.getMessage());
        }
    }
}
