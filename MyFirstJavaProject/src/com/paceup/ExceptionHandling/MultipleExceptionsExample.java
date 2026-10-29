package com.paceup.ExceptionHandling;

/**
 * MultipleExceptionsExample:
 * --------------------------
 *
 * Exception Handling Basics:
 * --------------------------
 * - Exceptions are abnormal events that disrupt normal program execution.
 * - Different exceptions often require different recovery mechanisms.
 * - Java allows multiple catch blocks to handle specific exceptions separately.
 *
 * Key Points:
 * -----------
 * 1. Execution stops at the first exception:
 *    - Once an exception occurs, the remaining code inside the try block
 *      is skipped immediately.
 *    - JVM starts searching for a matching catch block.
 *
 * 2. Order of catch blocks matters:
 *    - Child exceptions must always be placed before parent exceptions.
 *
 *      Correct:
 *      --------
 *      catch(ArrayIndexOutOfBoundsException e)
 *      catch(Exception e)
 *
 *      Incorrect:
 *      ----------
 *      catch(Exception e)
 *      catch(ArrayIndexOutOfBoundsException e)
 *
 *    - Otherwise the compiler reports "Unreachable Catch Block".
 *
 * 3. Common Runtime Exceptions in this Example:
 *
 *    ArrayIndexOutOfBoundsException:
 *    --------------------------------
 *    Generated when an invalid array index is accessed.
 *
 *    ArithmeticException:
 *    --------------------
 *    Generated when performing illegal arithmetic operations
 *    such as division by zero.
 *
 * 4. finally Block:
 *    --------------
 *    - Executes regardless of whether an exception occurs.
 *    - Commonly used for:
 *          • Closing files
 *          • Closing database connections
 *          • Releasing locks
 *          • Releasing resources
 *
 * 5. Important Observation:
 *    ----------------------
 *    In this program:
 *
 *        numbers[5]
 *
 *    throws an ArrayIndexOutOfBoundsException FIRST.
 *
 *    Therefore:
 *
 *        int result = 10 / 0;
 *
 *    is NEVER executed.
 *
 *    This demonstrates an important rule:
 *
 *    "Only the first exception encountered during execution
 *     gets processed."
 *
 * Expected Output:
 * ----------------
 * Array index is out of bounds: Index 5 out of bounds for length 3
 * Execution completed.
 */
public class MultipleExceptionsExample {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * TRY BLOCK
         * =====================================================================
         *
         * Purpose:
         * --------
         * Contains code that may generate exceptions.
         *
         * JVM Execution Sequence:
         *
         * Try Block
         *     |
         *     V
         * numbers[5]
         *     |
         *     V
         * ArrayIndexOutOfBoundsException
         *     |
         *     V
         * Matching Catch Block
         *     |
         *     V
         * finally Block
         *
         * =====================================================================
         */
        try {

            /*
             * Array Initialization
             *
             * Index Mapping:
             *
             * numbers[0] = 1
             * numbers[1] = 2
             * numbers[2] = 3
             *
             * Length = 3
             */
            int[] numbers = {1, 2, 3};

            /*
             * ================================================================
             * EXCEPTION #1
             * ================================================================
             *
             * Attempting to access index 5.
             *
             * Valid Indexes:
             * --------------
             * 0, 1, 2
             *
             * Invalid:
             * --------
             * 5
             *
             * JVM immediately throws:
             *
             * ArrayIndexOutOfBoundsException
             *
             * After exception occurs:
             * -----------------------
             * Remaining statements in the try block
             * are skipped.
             */
            System.out.println(numbers[5]);

            /*
             * ================================================================
             * EXCEPTION #2
             * ================================================================
             *
             * This statement is NEVER executed
             * because execution already jumped
             * to the catch block above.
             *
             * If executed:
             *
             *      10 / 0
             *
             * would throw:
             *
             * ArithmeticException
             *
             * ================================================================
             */
            int result = 10 / 0;

            /*
             * Unreachable during current execution.
             */
            System.out.println(result);
        }

        /*
         * =====================================================================
         * CATCH BLOCK #1
         * =====================================================================
         *
         * Handles:
         *
         * ArrayIndexOutOfBoundsException
         *
         * Current execution lands here.
         *
         * =====================================================================
         */
        catch (ArrayIndexOutOfBoundsException e) {

            /*
             * getMessage()
             *
             * Returns detailed JVM-generated
             * exception information.
             */
            System.out.println(
                    "Array index is out of bounds: "
                            + e.getMessage()
            );
        }

        /*
         * =====================================================================
         * CATCH BLOCK #2
         * =====================================================================
         *
         * Handles:
         *
         * ArithmeticException
         *
         * Current execution NEVER reaches here
         * because numbers[5] throws first.
         *
         * To test this block:
         *
         * Replace:
         *     numbers[5]
         *
         * With:
         *     numbers[2]
         *
         * Then:
         *
         *      10 / 0
         *
         * will execute and this catch block
         * will handle the exception.
         *
         * =====================================================================
         */
        catch (ArithmeticException e) {

            System.out.println(
                    "Cannot divide by zero: "
                            + e.getMessage()
            );
        }

        /*
         * =====================================================================
         * FINALLY BLOCK
         * =====================================================================
         *
         * Always executes after:
         *
         * try
         * catch
         *
         * regardless of:
         *
         * ✓ Exception occurred
         * ✓ No exception occurred
         * ✓ Exception handled
         *
         * Common Use Cases:
         *
         * - Database cleanup
         * - Resource release
         * - File closing
         * - Logging
         *
         * Exception:
         * ----------
         * finally may not execute if JVM terminates
         * using System.exit().
         *
         * =====================================================================
         */
        finally {

            System.out.println("Execution completed.");
        }
    }
}