package com.paceup.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TryWithResourcesExample:
 * ------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Resource Management**:
 *    - Resources like files, sockets, and database connections must be closed after use.
 *    - Traditionally, this required a `finally` block to close resources manually.
 *    - Try-with-resources (introduced in Java 7) automatically closes resources 
 *      that implement the `AutoCloseable` interface.
 * 
 * 2. **BufferedReader & FileReader**:
 *    - `FileReader` reads characters from a file.
 *    - `BufferedReader` adds efficiency by buffering input and allowing line-by-line reading.
 * 
 * 3. **Exception Handling**:
 *    - If an exception occurs while reading the file, it is caught in the `catch` block.
 *    - The resource (`BufferedReader`) is automatically closed, even if an exception occurs.
 * 
 * Advantages:
 * -----------
 * - Cleaner code (no need for explicit `finally` block).
 * - Prevents resource leaks.
 * - Improves readability and reliability.
 */
public class TryWithResourcesExample {
    public static void main(String[] args) {
        // try-with-resources ensures BufferedReader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            // Read file line by line until end of file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handles file not found or read errors
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
