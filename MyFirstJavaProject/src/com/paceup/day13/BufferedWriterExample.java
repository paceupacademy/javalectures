package com.paceup.day13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates the use of BufferedWriter.
 * BufferedWriter provides efficient writing of characters to a file
 * by buffering the output. This reduces the number of I/O operations.
 */
public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a BufferedWriter instance.
            // FileWriter is used to write characters directly to a file.
            // Wrapping it with BufferedWriter improves efficiency by reducing disk writes.
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            // Step 2: Write a string into the file.
            bw.write("Hello BufferedWriter!");

            // Step 3: Insert a newline after the first line.
            // newLine() ensures platform-independent line breaks.
            bw.newLine();

            // Step 4: Write another line of text into the file.
            bw.write("Second line of text.");

            // Step 5: Close the BufferedWriter.
            // Closing flushes any remaining data in the buffer and releases resources.
            bw.close();

            // Step 6: Print confirmation message to the console.
            System.out.println("Data written with BufferedWriter.");

        } catch (IOException e) {
            // Step 7: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        }
    }
}
