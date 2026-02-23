package com.paceup.IOStreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriterExample:
 * ----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **BufferedWriter**:
 *    - Wraps around a Writer (like FileWriter).
 *    - Buffers characters for efficient writing.
 *    - Reduces the number of direct disk I/O operations.
 * 
 * 2. **Important Methods**:
 *    - write(String str): Writes a string to the output stream.
 *    - newLine(): Inserts a platform-independent newline.
 *    - close(): Flushes any remaining data and closes the stream.
 * 
 * 3. **Use Cases**:
 *    - Writing text files efficiently.
 *    - Logging or appending large amounts of text.
 * 
 * In this example:
 * - Writes two lines of text into "output.txt".
 * - Demonstrates use of `newLine()` for line breaks.
 * - Closes the stream to flush and release resources.
 */
public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a BufferedWriter instance
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            // Step 2: Write a string into the file
            bw.write("Hello BufferedWriter!");

            // Step 3: Insert a newline after the first line
            bw.newLine();

            // Step 4: Write another line of text into the file
            bw.write("Second line of text.");

            // Step 5: Close the BufferedWriter (flushes buffer + releases resources)
            bw.close();

            // Step 6: Print confirmation message to the console
            System.out.println("Data written with BufferedWriter.");

        } catch (IOException e) {
            // Step 7: Handle any I/O exceptions (e.g., file not found, permission issues)
            e.printStackTrace();
        }
    }
}
