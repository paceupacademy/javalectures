package com.paceup.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * =============================================================================
 * TRY-WITH-RESOURCES EXAMPLE
 * =============================================================================
 *
 * Introduced:
 * -----------
 * Java 7
 *
 * Purpose:
 * --------
 * Automatically manage and close resources after use.
 *
 * Common Resources:
 * -----------------
 * 1. File Streams
 * 2. BufferedReader
 * 3. BufferedWriter
 * 4. Database Connections
 * 5. Socket Connections
 * 6. Scanner
 *
 * =============================================================================
 *
 * PROBLEM BEFORE JAVA 7
 * =============================================================================
 *
 * Traditional Approach:
 *
 * BufferedReader br = null;
 *
 * try {
 *      br = new BufferedReader(...);
 * }
 * finally {
 *      if(br != null){
 *          br.close();
 *      }
 * }
 *
 * Issues:
 * -------
 * 1. More boilerplate code
 * 2. Easy to forget close()
 * 3. Resource leaks
 * 4. Multiple nested try-catch blocks
 *
 * =============================================================================
 *
 * SOLUTION: TRY-WITH-RESOURCES
 * =============================================================================
 *
 * try(Resource resource = ...)
 * {
 *      business logic
 * }
 *
 * JVM automatically invokes:
 *
 * resource.close();
 *
 * even if exception occurs.
 *
 * =============================================================================
 *
 * REQUIREMENT
 * =============================================================================
 *
 * Resource must implement:
 *
 * AutoCloseable
 *            |
 *            V
 * Closeable
 *            |
 *            V
 * BufferedReader
 * FileReader
 * Scanner
 * InputStream
 * OutputStream
 *
 * =============================================================================
 */
public class TryWithResourcesExample {

    public static void main(String[] args) {

        /*
         * =====================================================================
         * TRY-WITH-RESOURCES BLOCK
         * =====================================================================
         *
         * Resource Declaration:
         *
         * BufferedReader br =
         *      new BufferedReader(
         *          new FileReader("example.txt")
         *      );
         *
         * JVM stores reference and guarantees closing.
         *
         * Equivalent Internal Logic:
         *
         * try {
         *      ...
         * }
         * finally {
         *      br.close();
         * }
         *
         * =====================================================================
         */

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader("example.txt")
                        )
        ) {

            /*
             * =================================================================
             * FILE READING PROCESS
             * =================================================================
             *
             * Application
             *      |
             *      V
             * BufferedReader
             *      |
             *      V
             * FileReader
             *      |
             *      V
             * Operating System
             *      |
             *      V
             * Physical File
             *
             * =================================================================
             */

            String line;

            /*
             * =================================================================
             * READ FILE LINE BY LINE
             * =================================================================
             *
             * readLine() Behavior:
             *
             * Returns:
             * --------
             * String -> next line
             *
             * End Of File:
             * ------------
             * null
             *
             * Loop Continues:
             *
             * Line Available ?
             *        |
             *      YES
             *        |
             *        V
             * Print Line
             *        |
             *        V
             * Read Next
             *        |
             *      NO
             *        |
             *        V
             * Exit Loop
             *
             * =================================================================
             */

            while ((line = br.readLine()) != null) {

                /*
                 * Print current line
                 */
                System.out.println(line);
            }

        }

        /*
         * =====================================================================
         * EXCEPTION HANDLING
         * =====================================================================
         *
         * Handles:
         *
         * FileNotFoundException
         * NoSuchFileException
         * IOException
         *
         * Even if exception occurs:
         *
         * JVM automatically closes BufferedReader.
         *
         * =====================================================================
         */
        catch (IOException e) {

            System.out.println(
                    "Error reading file: "
                            + e.getMessage()
            );
        }

        /*
         * No explicit finally block needed.
         *
         * Resource already closed automatically.
         */
    }
}