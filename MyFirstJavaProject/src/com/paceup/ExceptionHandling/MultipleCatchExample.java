package com.paceup.ExceptionHandling;

/**
 * MultipleCatchExample:
 * ---------------------
 *
 * Exception Handling:
 * -------------------
 * - Exceptions are abnormal events that interrupt the normal execution
 *   of a Java program.
 * - Different exceptions usually require different recovery actions.
 * - Multiple catch blocks allow us to handle specific exceptions
 *   independently.
 *
 * Key Points:
 * -----------
 *
 * 1. Order of Catch Blocks Matters:
 * ---------------------------------
 * More specific exceptions must appear before more general exceptions.
 *
 * Correct:
 *
 * catch (ArithmeticException e)
 * catch (Exception e)
 *
 * Incorrect:
 *
 * catch (Exception e)
 * catch (ArithmeticException e)
 *
 * Reason:
 * -------
 * Exception is the parent class.
 * ArithmeticException is its child class.
 *
 * If Exception is placed first,
 * all ArithmeticExceptions will already be handled,
 * making the second catch block unreachable.
 *
 * ---------------------------------------------------------------------------
 *
 * 2. Common Runtime Exceptions:
 * -----------------------------
 *
 * ArrayIndexOutOfBoundsException
 * ------------------------------
 * Occurs when accessing an array index
 * beyond its valid range.
 *
 * ArithmeticException
 * -------------------
 * Occurs during illegal arithmetic operations
 * such as division by zero.
 *
 * Exception
 * ---------
 * Generic superclass for most exceptions.
 * Usually placed as the last catch block.
 *
 * ---------------------------------------------------------------------------
 *
 * 3. Execution Stops at First Exception:
 * --------------------------------------
 *
 * In this example:
 *
 *      numbers[4]
 *
 * throws:
 *
 *      ArrayIndexOutOfBoundsException
 *
 * immediately.
 *
 * Therefore:
 *
 *      int sum = numbers[1] / 0;
 *
 * never executes.
 *
 * ---------------------------------------------------------------------------
 *
 * 4. Best Practice:
 * -----------------
 * - Catch the most specific exception first.
 * - Catch generic Exception at the end.
 * - Avoid empty catch blocks.
 * - Log exceptions properly in enterprise applications.
 *
 * ---------------------------------------------------------------------------
 *
 * Expected Output:
 * ----------------
 * Array Index Out Of Bounds Exception occurred.
 */
public class MultipleCatchExample {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * TRY BLOCK
         * =====================================================================
         *
         * Contains potentially risky code.
         *
         * JVM Flow:
         *
         * Try Block
         *      |
         *      V
         * numbers[4]
         *      |
         *      V
         * Exception Thrown
         *      |
         *      V
         * Search Matching Catch Block
         *      |
         *      V
         * Execute Matching Catch
         *
         * =====================================================================
         */
        try {

            /*
             * Array Creation
             *
             * Valid Indexes:
             *
             * numbers[0] = 1
             * numbers[1] = 2
             * numbers[2] = 3
             *
             * Array Length = 3
             */
            int[] numbers = {1, 2, 3};
            int[] num = null;
            /*
             * ================================================================
             * EXCEPTION #1
             * ================================================================
             *
             * Attempting to access index 4.
             *
             * Valid:
             * ------
             * 0,1,2
             *
             * Invalid:
             * --------
             * 4
             *
             * JVM generates:
             *
             * ArrayIndexOutOfBoundsException
             *
             * Remaining statements inside the try block
             * are skipped immediately.
             */
            System.out.println(numbers[2]);

            /*
             * ================================================================
             * EXCEPTION #2
             * ================================================================
             *
             * This line never executes because
             * the previous statement already threw an exception.
             *
             * If executed:
             *
             * 2 / 0
             *
             * would produce:
             *
             * ArithmeticException
             *
             * ================================================================
             */
            int sum = numbers[1] / 4;
            
            System.out.println("Divsion result "+sum);

            /*
             * Also never executes.
             */
            System.out.println(num.length);
        }

        /*
         * =====================================================================
         * CATCH BLOCK #1
         * =====================================================================
         *
         * Handles:
         *
         * ArithmeticException
         *
         * Current execution does NOT reach here
         * because ArrayIndexOutOfBoundsException
         * occurs first.
         *
         * To test this block:
         *
         * Change:
         *      numbers[4]
         *
         * To:
         *      numbers[1]
         *
         * Then division by zero will execute.
         */
        catch (ArithmeticException e) {

            System.out.println(
                    "Arithmetic Exception occurred."
            );
        }

        /*
         * =====================================================================
         * CATCH BLOCK #2
         * =====================================================================
         *
         * Handles:
         *
         * ArrayIndexOutOfBoundsException
         *
         * This is the catch block that executes
         * in the current program.
         *
         * Exception Message Example:
         *
         * Index 4 out of bounds for length 3
         *
         * =====================================================================
         */
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Array Index Out Of Bounds Exception occurred."
            );

            /*
             * Alternative:
             *
             * System.out.println(e.getMessage());
             */
        }

        /*
         * =====================================================================
         * CATCH BLOCK #3
         * =====================================================================
         *
         * Generic Exception Handler.
         *
         * Handles all exceptions that are:
         *
         * ✓ Subclasses of Exception
         * ✓ Not handled above
         *
         * Always keep generic catch block
         * after specific catch blocks.
         *
         * =====================================================================
         */
        catch (Exception e) {

            System.out.println(
                    "Some other exception occurred: "
                            + e.getMessage()
            );
        }

        /*
         * Current program reaches here because
         * exception was handled successfully.
         */
        System.out.println("Program Continues...");
    }
}