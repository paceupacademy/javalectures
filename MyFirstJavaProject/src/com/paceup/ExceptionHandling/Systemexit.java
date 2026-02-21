package com.paceup.ExceptionHandling;

/**
 * Systemexit:
 * -----------
 * Demonstrates the behavior of `System.exit()` inside a try-finally block.
 *
 * Key Concepts:
 * -------------
 * 1. **finally block**:
 *    - Normally executes after try/catch, regardless of whether an exception occurs.
 *    - Ensures cleanup code (closing resources, releasing locks).
 *
 * 2. **System.exit()**:
 *    - Terminates the JVM immediately.
 *    - Does not throw an exception or return normally.
 *    - Bypasses the normal try/finally execution path.
 *
 * 3. **Why finally is skipped**:
 *    - The JVM halts before it can reach the finally block.
 *    - No further instructions are executed once `System.exit()` is called.
 *
 * Backend Working:
 * ----------------
 * - JVM starts executing the try block.
 * - `System.out.println("In try block")` executes.
 * - `System.exit(0)` is called → JVM shutdown sequence begins.
 * - JVM halts immediately → finally block is **not executed**.
 *
 * Expected Output:
 * ----------------
 * In try block
 *
 * (The line "In finally block" will NOT appear because JVM terminates before reaching it.)
 */
public class Systemexit {
    public static void main(String[] args) {
        try {
            System.out.println("In try block");
            System.exit(0); // Terminates JVM immediately
        } finally {
            // This will NOT execute because JVM halts before reaching here
            System.out.println("In finally block");
        }
    }
}
