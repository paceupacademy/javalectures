package com.paceup.ExceptionHandling;

import java.sql.SQLException;

/*
 * =============================================================================
 * THROW EXAMPLE
 * =============================================================================
 *
 * Purpose:
 * --------
 * Demonstrates the difference between:
 *
 * 1. throw
 * 2. throws
 *
 * and how exceptions are generated, propagated,
 * and handled in Java applications.
 *
 * =============================================================================
 * THROW vs THROWS
 * =============================================================================
 *
 * throw
 * -----
 * Used to explicitly create and throw an exception object.
 *
 * Syntax:
 *
 * throw new ExceptionType("Message");
 *
 * Example:
 *
 * throw new IllegalArgumentException(
 *         "Age must be 18 or above.");
 *
 * -----------------------------------------------------------------------------
 *
 * throws
 * ------
 * Used in method signature.
 *
 * Indicates that a method may generate an exception.
 *
 * Syntax:
 *
 * method() throws ExceptionType
 *
 * Example:
 *
 * public void readFile()
 * throws IOException
 *
 * =============================================================================
 *
 * EXCEPTION HIERARCHY
 *
 * Object
 *    |
 *    V
 * Throwable
 *    |
 *    +------------------+
 *    |                  |
 *    V                  V
 * Error            Exception
 *                       |
 *                       V
 *                RuntimeException
 *                       |
 *                       V
 *          IllegalArgumentException
 *
 * IllegalArgumentException is:
 *
 * - Runtime Exception
 * - Unchecked Exception
 * - Compiler does NOT force handling
 *
 * =============================================================================
 */
public class ThrowExample {

    /*
     * =========================================================================
     * AGE VALIDATION METHOD
     * =========================================================================
     *
     * Business Rule:
     *
     * Age must be >= 18
     *
     * Valid:
     * ------
     * 18
     * 19
     * 20
     *
     * Invalid:
     * --------
     * 17
     * 16
     * 10
     *
     * =========================================================================
     *
     * throws IllegalArgumentException
     *
     * Technically not required because
     * IllegalArgumentException is unchecked.
     *
     * It is added here for documentation purposes.
     *
     * =========================================================================
     */
    public static void checkAge(int age)
            throws IllegalArgumentException {

        /*
         * =====================================================================
         * VALIDATION PIPELINE
         * =====================================================================
         *
         * Input Age
         *      |
         *      V
         * age < 18 ?
         *      |
         *  +---+---+
         *  |       |
         * YES      NO
         *  |       |
         *  V       V
         * throw   Continue
         *
         * =====================================================================
         */
        if (age < 18) {

            /*
             * Explicit exception creation.
             *
             * JVM internally performs:
             *
             * Step 1:
             * Create IllegalArgumentException object.
             *
             * Step 2:
             * Store error message.
             *
             * Step 3:
             * Interrupt normal execution.
             *
             * Step 4:
             * Search for nearest matching catch block.
             */
        	System.out.println("Try Block Executed");
            throw new IllegalArgumentException(
                    "Age must be 18 or above."
            );
            
        }
        else {

            /*
             * Executes only for valid age values.
             */
            System.out.println(
                    "Correct Age Entered"
            );
        }
        System.out.println("Check Age Executed!!");
    }

    /*
     * =========================================================================
     * DRIVER METHOD
     * =========================================================================
     *
     * Demonstrates:
     *
     * 1. Exception generation
     * 2. Exception handling
     * 3. Recovery and continuation of execution
     *
     * =========================================================================
     */
    public static void main(String[] args) {

        /*
         * =====================================================================
         * TRY BLOCK
         * =====================================================================
         *
         * Purpose:
         *
         * Monitor risky code that may throw exceptions.
         *
         * Execution Flow:
         *
         * try
         *  |
         *  V
         * checkAge(16)
         *  |
         *  V
         * Exception?
         *  |
         * YES
         *  |
         *  V
         * catch block
         *
         * =====================================================================
         */
        try {

            /*
             * Invalid age.
             *
             * This will generate
             * IllegalArgumentException.
             */
            checkAge(16);
        }

        /*
         * =====================================================================
         * CATCH BLOCK
         * =====================================================================
         *
         * Executed only if matching exception occurs.
         *
         * Handles:
         *
         * IllegalArgumentException
         *
         * =====================================================================
         */
        catch (IllegalArgumentException e) {

            /*
             * getMessage()
             *
             * Returns custom message passed while
             * creating exception object.
             */
            System.out.println(
                    "Exception caught: "
                            + e.getMessage()
            );

            /*
             * Valid age.
             *
             * No exception generated.
             */
            checkAge(20);
        }
    }
}