package com.paceup.ExceptionHandling;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * =============================================================================
 * BASIC EXCEPTION HANDLING
 * =============================================================================
 *
 * Exception:
 * ----------
 * An Exception is an abnormal event that occurs during program execution
 * and interrupts the normal execution flow.
 *
 * ============================================================================
 * EXCEPTION HIERARCHY
 * ============================================================================
 *
 *                          Object
 *                             |
 *                       Throwable
 *                       /        \
 *                      /          \
 *                  Error      Exception
 *                                 |
 *                     -----------------------
 *                     |                     |
 *               Checked              Unchecked
 *             Exception              Exception
 *                     |                     |
 *               IOException      NullPointerException
 *               SQLException     ArithmeticException
 *               ClassNotFound    ArrayIndexOutOfBounds
 *
 * ============================================================================
 *
 * Error:
 * ------
 * Serious JVM level problem.
 *
 * Examples:
 * - OutOfMemoryError
 * - StackOverflowError
 * - VirtualMachineError
 *
 * Usually recovery is not possible.
 *
 * ============================================================================
 *
 * Checked Exception:
 * ------------------
 * Compiler forces handling.
 *
 * Examples:
 * - IOException
 * - SQLException
 * - ClassNotFoundException
 *
 * ============================================================================
 *
 * Unchecked Exception:
 * --------------------
 * Occurs during runtime.
 *
 * Examples:
 * - NullPointerException
 * - ArithmeticException
 * - ClassCastException
 * - ArrayIndexOutOfBoundsException
 *
 * ============================================================================
 *
 * Exception Handling Keywords
 * ---------------------------
 *
 * try
 *      Risky code
 *
 * catch
 *      Handles exception
 *
 * finally
 *      Always executes
 *
 * throw
 *      Explicitly throws exception
 *
 * throws
 *      Declares exception responsibility
 *
 * ============================================================================
 */
public class BasicExceptionHandling {

    public static void main(String[] args) throws IOException {

        /*
         * =====================================================================
         * CLASS LOADING EXCEPTION
         * =====================================================================
         *
         * Checked Exception Example
         *
         * JVM tries to locate class metadata.
         *
         * Class Loader
         *      |
         *      V
         * Load Class
         *      |
         *      V
         * Class Found ? ------- YES ------> Continue
         *      |
         *      NO
         *      |
         *      V
         * ClassNotFoundException
         *
         */

        /*
        try {
            Class c = Class.forName("com.paceup.Example");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */


        /*
         * =====================================================================
         * TYPE CASTING
         * =====================================================================
         *
         * Narrowing Conversion
         *
         * double
         * 10.459
         *
         * converted to
         *
         * int
         * 10
         *
         * Decimal portion lost.
         *
         * JVM simply truncates value.
         */

        double data = 10.459d;

        int n = (int) data;

        System.out.println(n);



        /*
         * =====================================================================
         * ARITHMETIC EXCEPTION
         * =====================================================================
         *
         * Division by zero.
         *
         * Flow:
         *
         * try
         *   |
         *   V
         * Exception Occurred?
         *   |
         * YES
         *   |
         *   V
         * catch
         *   |
         *   V
         * finally
         *
         */

        /*
        try {

            int result = 10 / 0;

        } catch (Exception e) {

            System.out.println(
                "Cannot divide by zero : "
                + e.getMessage());

        } finally {

            System.out.println("Execution completed.");

        }
        */


        /*
         * =====================================================================
         * FILE RELATED EXCEPTIONS
         * =====================================================================
         *
         * Checked Exceptions
         *
         * Common Problems:
         *
         * FileNotFoundException
         * NoSuchFileException
         * AccessDeniedException
         *
         * Backend Working:
         *
         * Application
         *     |
         *     V
         * File System
         *     |
         *     V
         * Operating System
         *     |
         *     V
         * Physical Disk
         *
         * Any failure in this path generates exceptions.
         */

        /*
        Files.exists(Path.of("D:/sample.txt"));

        Files.readAllBytes(
                Path.of("D:/sample.txt"));
        */


        /*
         * =====================================================================
         * OUT OF MEMORY ERROR
         * =====================================================================
         *
         * Error (NOT Exception)
         *
         * Heap Memory Continuously Filled
         *
         * JVM Heap
         *
         * [#######..........]
         * [############.....]
         * [#################]
         *        |
         *        V
         * OutOfMemoryError
         *
         */

        /*
        List<Byte> list = new ArrayList<>();

        while(true){

            list.add(new Byte((byte)10000000));

        }
        */


        /*
         * =====================================================================
         * BIGDECIMAL CALCULATION
         * =====================================================================
         *
         * Why BigDecimal?
         *
         * double cannot store exact decimal precision.
         *
         * BigDecimal provides:
         *
         * - Arbitrary precision
         * - Financial calculations
         * - Accurate decimal math
         */

        BigDecimal num1 =
                new BigDecimal("121.0290840928409301");

        BigDecimal num2 =
                new BigDecimal("83.791839834093809387");



        /*
         * HALF_DOWN Rounding
         */
        BigDecimal result =
                num1.divide(
                        num2,
                        RoundingMode.HALF_DOWN
                );

        System.out.println(
                "Result is " + result);


        /*
         * =====================================================================
         * DOUBLE PRECISION ISSUE
         * =====================================================================
         *
         * Floating point values are represented
         * according to IEEE 754 standard.
         *
         * Results may not be perfectly accurate.
         */

        double a1 = 121.0290840928409301;

        double b = 83.791839834093809387;

        System.out.println(
                "Result of double "
                        + (a1 + b));



        /*
         * =====================================================================
         * ARRAY INDEX OUT OF BOUNDS
         * =====================================================================
         *
         * Array Size = 2
         *
         * Valid:
         * 0
         * 1
         *
         * Invalid:
         * 2
         *
         * Runtime Exception
         */

        /*
        int[] a = {10,20};

        System.out.println(a[2]);
        */



        /*
         * =====================================================================
         * NULL POINTER EXCEPTION
         * =====================================================================
         *
         * One of the most common runtime exceptions.
         *
         * Cause:
         *
         * Object Reference
         *      |
         *      V
         * null
         *      |
         *      V
         * Method Call
         *      |
         *      V
         * NullPointerException
         */

        String s = null;

        try {

            System.out.println(s.length());

        }
        catch (NullPointerException e) {

            System.out.println(
                    "String is empty\n"
                            + e.getMessage());

        }

        System.out.println("Program Continues");


        /*
         * Best Practice
         *
         * Null check before usage.
         */
        if (s != null) {

            System.out.println(
                    s.length());

        }



        /*
         * =====================================================================
         * CLASS CAST EXCEPTION
         * =====================================================================
         *
         * Runtime Type Mismatch
         *
         * Object
         *   |
         *   V
         * String
         *
         * Can cast back to String.
         *
         * Cannot cast String to Integer.
         */

        /*
        Object o = "Hello";

        String s1 = (String) o;

        Integer x = (Integer) o;

        String s2 = "45";

        int i = Integer.parseInt(s2);
        */



        /*
         * =====================================================================
         * DATABASE EXCEPTIONS
         * =====================================================================
         *
         * Common SQL Exceptions:
         *
         * Syntax Error
         * Connection Failure
         * Timeout
         * Constraint Violation
         *
         * Example:
         *
         * SELECT * FROM student
         *
         * Misspelled:
         *
         * Selec * from student
         *
         * -> SQLException
         */

        // PreparedStatement stmt;

        // stmt.executeQuery("Selec * from student");


        /*
         * StackOverflowError Demo
         */
        method();
    }



    /*
     * =========================================================================
     * RECURSION EXAMPLE
     * =========================================================================
     *
     * WARNING:
     *
     * Infinite recursion.
     *
     * method()
     *      |
     *      V
     * method()
     *      |
     *      V
     * method()
     *      |
     *      V
     * method()
     *
     * Stack keeps growing.
     *
     * Eventually:
     *
     * StackOverflowError
     *
     * =========================================================================
     */
    public static void method() {

        /*
         * Infinite recursive call.
         */
        method();



        /*
         * Code below will never execute
         * because recursion never returns.
         */

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        sc.close();



        Scanner sc1 = new Scanner(System.in);

        int b = sc1.nextInt();
    }
}