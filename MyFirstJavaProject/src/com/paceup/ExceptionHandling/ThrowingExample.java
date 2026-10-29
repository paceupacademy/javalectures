package com.paceup.ExceptionHandling;

/*
 * =============================================================================
 * THROWING EXAMPLE
 * =============================================================================
 *
 * Purpose:
 * --------
 * Demonstrates how to explicitly generate (throw) exceptions in Java
 * using the 'throw' keyword.
 *
 * =============================================================================
 * WHAT IS AN EXCEPTION?
 * =============================================================================
 *
 * An Exception is an abnormal condition that interrupts
 * the normal flow of program execution.
 *
 * Example:
 *
 * User enters invalid data
 *              OR
 * File not found
 *              OR
 * Invalid argument passed
 *
 * =============================================================================
 * THROW KEYWORD
 * =============================================================================
 *
 * Syntax:
 *
 * throw new ExceptionType("Message");
 *
 * Example:
 *
 * throw new IllegalArgumentException(
 *      "Number must be non-negative");
 *
 * Purpose:
 * --------
 * Manually create and throw an exception object.
 *
 * =============================================================================
 * THROW vs THROWS
 * =============================================================================
 *
 * throw
 * -----
 * Used to actually throw an exception object.
 *
 * Example:
 *
 * throw new IllegalArgumentException();
 *
 * -----------------------------------------------------------------------------
 *
 * throws
 * ------
 * Used in method declaration.
 *
 * Indicates responsibility is delegated to caller.
 *
 * Example:
 *
 * public void readFile() throws IOException
 *
 * =============================================================================
 *
 * Exception Hierarchy Used Here
 *
 * Object
 *   |
 *   V
 * Throwable
 *   |
 *   V
 * Exception
 *   |
 *   V
 * RuntimeException
 *   |
 *   V
 * IllegalArgumentException
 *
 * Since IllegalArgumentException is unchecked,
 * compiler does not force handling.
 *
 * =============================================================================
 */
public class ThrowingExample {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * EXCEPTION HANDLING FLOW
         * =====================================================================
         *
         * try
         *  |
         *  V
         * validateNumber(-5)
         *  |
         *  V
         * Exception Generated?
         *  |
         * YES
         *  |
         *  V
         * catch Block Executes
         *  |
         *  V
         * validateNumber(90)
         *  |
         *  V
         * Program Continues
         *
         * =====================================================================
         */

        try {

            /*
             * Invalid input
             *
             * Number is less than zero.
             *
             * Method will throw:
             *
             * IllegalArgumentException
             */
            validateNumber(-5);

        }
        catch (IllegalArgumentException e) {

            /*
             * Exception handling block.
             *
             * getMessage()
             * returns custom exception message.
             */
            System.out.println(
                    "Exception caught: "
                            + e.getMessage()
            );

            /*
             * Valid input.
             *
             * No exception generated.
             */
            validateNumber(90);
        }
        System.out.println("Main Method Executed");
    }


    /*
     * =========================================================================
     * VALIDATION METHOD
     * =========================================================================
     *
     * Business Rule:
     *
     * Number must be >= 0
     *
     * If invalid:
     *      Throw Exception
     *
     * If valid:
     *      Continue Execution
     *
     * =========================================================================
     *
     * @param number
     *         number to validate
     *
     * @throws IllegalArgumentException
     *         when number < 0
     *
     * =========================================================================
     */
    public static void validateNumber(int number) {

        /*
         * =====================================================================
         * VALIDATION CHECK
         * =====================================================================
         *
         * Input Value
         *      |
         *      V
         * number < 0 ?
         *      |
         *  +---+---+
         *  |       |
         * YES      NO
         *  |       |
         *  V       V
         * throw   Valid Number
         *
         * =====================================================================
         */
        if (number < 0) {

            /*
             * Explicitly create Exception Object.
             *
             * JVM creates:
             *
             * IllegalArgumentException object
             *
             * then immediately throws it.
             *
             * After this statement:
             *
             * Remaining code inside method
             * will NOT execute.
             */
            throw new IllegalArgumentException(
                    "Number must be non-negative."
            );
        }

        /*
         * Executes only when validation succeeds.
         */
        System.out.println(
                "Valid number: " + number
        );
    }
}