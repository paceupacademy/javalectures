package com.paceup.ExceptionHandling;

/**
 * ============================================================================
 * CustomStackTraceDemo
 * ============================================================================
 *
 * Purpose:
 * --------
 * Demonstrates how to create a custom stack trace for an exception
 * using the setStackTrace() method.
 *
 * ============================================================================
 * STACK TRACE
 * ============================================================================
 *
 * A stack trace is a list of method calls that were active when
 * an exception occurred.
 *
 * Example:
 *
 * main()
 *    |
 *    V
 * methodA()
 *    |
 *    V
 * methodB()
 *    |
 *    V
 * Exception
 *
 * JVM automatically records these method calls and stores them
 * inside the Exception object.
 *
 * ============================================================================
 * WHAT IS StackTraceElement?
 * ============================================================================
 *
 * Each entry inside a stack trace is represented by:
 *
 * StackTraceElement
 *
 * It contains:
 *
 * 1. Class Name
 * 2. Method Name
 * 3. Source File Name
 * 4. Line Number
 *
 * Example:
 *
 * com.example.Test.main(Test.java:15)
 *
 * Here:
 *
 * Class Name  : com.example.Test
 * Method Name : main
 * File Name   : Test.java
 * Line Number : 15
 *
 * ============================================================================
 * CUSTOM STACK TRACE
 * ============================================================================
 *
 * Java allows replacing the automatically generated stack trace
 * with a custom one using:
 *
 *      setStackTrace(...)
 *
 * Use Cases:
 *
 * 1. Framework Development
 * 2. Testing Tools
 * 3. Mock Error Simulation
 * 4. Security Sanitization
 * 5. Error Abstraction Layers
 *
 * ============================================================================
 * IMPORTANT NOTE
 * ============================================================================
 *
 * In production systems,
 * modifying stack traces should be done carefully because:
 *
 * - Original debugging information may be lost.
 * - Troubleshooting becomes difficult.
 * - Can hide the real root cause.
 *
 * Usually used by:
 * - Spring Framework
 * - Hibernate
 * - Logging Frameworks
 * - Testing Utilities
 *
 * ============================================================================
 */
public class CustomStackTraceDemo {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * MAIN METHOD
         * =====================================================================
         *
         * Execution Flow:
         *
         * main()
         *     |
         *     V
         * triggerCustomException()
         *     |
         *     V
         * Create Exception
         *     |
         *     V
         * Replace Stack Trace
         *     |
         *     V
         * throw Exception
         *     |
         *     V
         * catch Block
         *     |
         *     V
         * printStackTrace()
         *
         * =====================================================================
         */
        try {

            /*
             * Method call that generates a custom exception.
             */
            triggerCustomException();

        }
        catch (Exception e) {

            /*
             * Prints the custom stack trace.
             *
             * Because we replaced the original stack trace,
             * JVM displays our custom entries.
             */
            e.printStackTrace();
        }
    }

    /**
     * ========================================================================
     * Creates and throws an exception with a custom stack trace.
     * ========================================================================
     *
     * @throws Exception
     *         a custom exception with modified stack trace.
     */
    private static void triggerCustomException() throws Exception {

        /*
         * =====================================================================
         * CREATE EXCEPTION OBJECT
         * =====================================================================
         *
         * Standard Exception Object.
         *
         * Message:
         *
         * "A custom error occurred!"
         *
         * =====================================================================
         */
        Exception ex =
                new Exception("A custom error occurred!");



        /*
         * =====================================================================
         * CUSTOM STACK TRACE CREATION
         * =====================================================================
         *
         * Normally JVM creates stack trace automatically.
         *
         * Example:
         *
         * triggerCustomException()
         * main()
         *
         * Instead,
         * we replace it manually.
         *
         * =====================================================================
         */
        StackTraceElement[] customTrace =
                new StackTraceElement[] {

                        /*
                         * Stack Trace Element #1
                         *
                         * Class Name:
                         *      FakeClassName
                         *
                         * Method:
                         *      secretMethod
                         *
                         * Source:
                         *      HiddenSource.java
                         *
                         * Line:
                         *      99
                         */
                        new StackTraceElement(
                                "FakeClassName",
                                "secretMethod",
                                "HiddenSource.java",
                                99
                        ),

                        /*
                         * Stack Trace Element #2
                         *
                         * Simulates application entry point.
                         */
                        new StackTraceElement(
                                "OriginalApp",
                                "main",
                                "MainApp.java",
                                10
                        )
                };



        /*
         * =====================================================================
         * REPLACE JVM GENERATED STACK TRACE
         * =====================================================================
         *
         * Original Trace:
         *
         * CustomStackTraceDemo.main()
         * triggerCustomException()
         *
         * gets replaced with:
         *
         * FakeClassName.secretMethod()
         * OriginalApp.main()
         *
         * =====================================================================
         */
        ex.setStackTrace(customTrace);



        /*
         * =====================================================================
         * THROW CUSTOMIZED EXCEPTION
         * =====================================================================
         *
         * The exception now contains:
         *
         * Message:
         *      A custom error occurred!
         *
         * Stack Trace:
         *      Our custom entries
         *
         * =====================================================================
         */
        throw ex;
    }
}