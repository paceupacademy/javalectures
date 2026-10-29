package com.paceup.ExceptionHandling;

/*
 * =============================================================================
 * SYSTEM.EXIT() EXAMPLE
 * =============================================================================
 *
 * Purpose:
 * --------
 * Demonstrates what happens when System.exit()
 * is invoked inside a try block that also contains
 * a finally block.
 *
 * =============================================================================
 * FINALLY BLOCK
 * =============================================================================
 *
 * In normal situations:
 *
 * try
 *   |
 *   V
 * catch (optional)
 *   |
 *   V
 * finally
 *
 * The finally block executes regardless of:
 *
 * ✓ Exception occurs
 * ✓ Exception does not occur
 * ✓ Return statement executes
 *
 * Common Uses:
 * ------------
 * 1. Closing files
 * 2. Closing database connections
 * 3. Releasing locks
 * 4. Resource cleanup
 *
 * =============================================================================
 * SYSTEM.EXIT()
 * =============================================================================
 *
 * Syntax:
 *
 * System.exit(statusCode);
 *
 * Example:
 *
 * System.exit(0);
 *
 * Purpose:
 * --------
 * Immediately terminates the Java Virtual Machine (JVM).
 *
 * =============================================================================
 * EXIT STATUS CODES
 * =============================================================================
 *
 * System.exit(0)
 * ----------------
 * Normal termination.
 *
 * System.exit(1)
 * ----------------
 * Abnormal termination.
 *
 * System.exit(anyNonZeroValue)
 * ----------------------------
 * Indicates an error condition.
 *
 * =============================================================================
 * IMPORTANT BEHAVIOR
 * =============================================================================
 *
 * Normally:
 *
 * try
 *   |
 *   V
 * finally executes
 *
 * But:
 *
 * System.exit()
 *      |
 *      V
 * JVM Shutdown Initiated
 *      |
 *      V
 * Program Stops
 *      |
 *      V
 * finally Block Skipped
 *
 * =============================================================================
 */
public class Systemexit {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * TRY BLOCK
         * =====================================================================
         *
         * JVM Execution Sequence:
         *
         * main()
         *    |
         *    V
         * try block
         *    |
         *    V
         * println()
         *    |
         *    V
         * System.exit(0)
         *    |
         *    V
         * JVM Shutdown
         *
         * =====================================================================
         */
        try {

            /*
             * Executed successfully.
             */
            System.out.println("In try block");

            /*
             * =================================================================
             * TERMINATE JVM
             * =================================================================
             *
             * Exit code = 0
             *
             * Indicates normal termination.
             *
             * JVM immediately begins shutdown sequence.
             *
             * No exception is thrown.
             *
             * Method does NOT return.
             *
             * Any statements after this point
             * are never executed.
             *
             * =================================================================
             */
            //System.exit(0);

            /*
             * Unreachable Code Example
             *
             * This line would never execute
             * if uncommented.
             *
             * System.out.println("Never Executes");
             */
        }

        /*
         * =====================================================================
         * FINALLY BLOCK
         * =====================================================================
         *
         * Normally guaranteed to execute.
         *
         * EXCEPTION:
         *
         * JVM termination through:
         *
         * System.exit()
         *
         * causes JVM shutdown before
         * finally can execute.
         *
         * =====================================================================
         */
        finally {

            /*
             * This statement never executes.
             */
            System.out.println("In finally block");
            System.exit(0);
        }
    }
}