package com.paceup.ExceptionHandling;

/**
 * =============================================================================
 * CustomExceptionExample
 * =============================================================================
 *
 * Exception Basics:
 * -----------------
 * - Exceptions are abnormal events that interrupt the normal execution
 *   flow of a program.
 *
 * - Java provides numerous built-in exceptions:
 *
 *      ArithmeticException
 *      NullPointerException
 *      IOException
 *      SQLException
 *      ArrayIndexOutOfBoundsException
 *
 * - Java also allows developers to create application-specific
 *   exceptions known as Custom Exceptions.
 *
 * =============================================================================
 * CUSTOM EXCEPTIONS
 * =============================================================================
 *
 * Why Create Custom Exceptions?
 * -----------------------------
 * Built-in exceptions often fail to express business requirements.
 *
 * Example:
 *
 * Banking:
 *      InsufficientBalanceException
 *
 * College:
 *      InvalidMarksException
 *
 * HR:
 *      InvalidSalaryException
 *
 * User Registration:
 *      InvalidAgeException
 *
 * Custom exceptions make code:
 *
 * ✓ More readable
 * ✓ Easier to maintain
 * ✓ Better for business validation
 *
 * =============================================================================
 * CHECKED vs UNCHECKED CUSTOM EXCEPTIONS
 * =============================================================================
 *
 * Checked Exception:
 * ------------------
 *
 * class InvalidAgeException extends Exception
 *
 * Compiler forces handling.
 *
 * Must use:
 *
 *      try-catch
 *
 * OR
 *
 *      throws
 *
 * -----------------------------------------------------------------------------
 *
 * Unchecked Exception:
 * --------------------
 *
 * class InvalidAgeException
 *          extends RuntimeException
 *
 * Compiler does NOT force handling.
 *
 * =============================================================================
 * IMPORTANT KEYWORDS
 * =============================================================================
 *
 * throw
 * -----
 * Actually throws an exception object.
 *
 * Example:
 *
 * throw new InvalidAgeException("Invalid Age");
 *
 * -----------------------------------------------------------------------------
 *
 * throws
 * ------
 * Declares that a method may throw an exception.
 *
 * Example:
 *
 * public void validate()
 * throws InvalidAgeException
 *
 * -----------------------------------------------------------------------------
 *
 * try-catch
 * ---------
 * Used for exception handling.
 *
 * -----------------------------------------------------------------------------
 *
 * finally
 * -------
 * Used for cleanup operations.
 *
 * =============================================================================
 * PROGRAM FLOW
 * =============================================================================
 *
 * checkAge(15)
 *      |
 *      V
 * InvalidAgeException
 *      |
 *      V
 * Inner Catch
 *      |
 *      V
 * Print Error Message
 *      |
 *      V
 * checkAge(24)
 *      |
 *      V
 * Validation Success
 *
 * =============================================================================
 */


/*
 * =============================================================================
 * CUSTOM CHECKED EXCEPTION
 * =============================================================================
 *
 * By extending Exception:
 *
 * InvalidAgeException becomes a
 * checked exception.
 *
 * Compiler enforces handling.
 *
 * Exception Hierarchy:
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
 * InvalidAgeException
 *
 * =============================================================================
 */
class InvalidAgeException extends Exception {

    /*
     * Constructor
     *
     * Passes custom message
     * to parent Exception class.
     */
    public InvalidAgeException(String message) {

        super(message);
    }
}



/*
 * =============================================================================
 * DRIVER CLASS
 * =============================================================================
 */
public class CustomExceptionExample {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * OUTER TRY BLOCK
         * =====================================================================
         *
         * Handles any exception not managed
         * by inner try-catch blocks.
         *
         * Current Program:
         *
         * InvalidAgeException is handled
         * by inner catch block.
         *
         * Therefore outer catch is not executed.
         *
         * =====================================================================
         */
        try {

            /*
             * ================================================================
             * INNER TRY BLOCK
             * ================================================================
             *
             * Demonstrates specific handling for
             * InvalidAgeException.
             *
             * ================================================================
             */
            try {

                /*
                 * Invalid age.
                 *
                 * Age < 18
                 *
                 * Generates:
                 *
                 * InvalidAgeException
                 */
                checkAge(15);

            }

            /*
             * Handles InvalidAgeException generated
             * by checkAge().
             */
            catch (InvalidAgeException e) {

                System.out.println(
                        "Exception caught: "
                                + e.getMessage()
                );
            }

            /*
             * ================================================================
             * VALID INPUT
             * ================================================================
             *
             * No exception generated.
             */
            checkAge(24);

        }

        /*
         * ================================================================
         * OUTER CATCH BLOCK
         * ================================================================
         *
         * Catch-all handler.
         *
         * Executes only if:
         *
         * - Inner try does not handle exception
         * - Another unexpected exception occurs
         *
         * ================================================================
         */
        catch (Exception e) {

            System.out.println(
                    "Outer Exception caught: "
                            + e.getMessage()
            );
        }
    }



    /**
     * ========================================================================
     * AGE VALIDATION METHOD
     * ========================================================================
     *
     * Validates the age according
     * to business rules.
     *
     * Rule:
     *
     * Age must be >= 18
     *
     * ========================================================================
     *
     * @param age
     *         user age
     *
     * @throws InvalidAgeException
     *         when age is less than 18
     *
     * ========================================================================
     */
    public static void checkAge(int age)
            throws InvalidAgeException {

        /*
         * Validation Logic
         *
         * Age
         *  |
         *  V
         * age < 18 ?
         *  |
         * +------+------+
         * |             |
         * YES           NO
         * |             |
         * V             V
         * throw      Valid Age
         */
        if (age < 18) {

            /*
             * Explicitly create and throw
             * custom exception.
             *
             * JVM Process:
             *
             * Create Exception Object
             *          |
             *          V
             * Populate Message
             *          |
             *          V
             * Throw Exception
             *          |
             *          V
             * Search Matching Catch Block
             */
            throw new InvalidAgeException(
                    "Age must be 18 or above."
            );
        }

        /*
         * Executes only when validation passes.
         */
        System.out.println("Age is valid.");
    }
}