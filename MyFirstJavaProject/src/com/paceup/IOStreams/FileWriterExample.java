package com.paceup.IOStreams;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriterExample:
 * ------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **FileWriter**:
 *    - A character stream class used to write text data into files.
 *    - Writes characters directly to a file (not suitable for binary data).
 *    - By default, overwrites the file if it already exists.
 *    - Can be configured to append data instead of overwriting.
 * 
 * 2. **Important Methods**:
 *    - write(String str): Writes a string to the file.
 *    - close(): Flushes any remaining data and closes the stream.
 * 
 * 3. **Use Cases**:
 *    - Writing text files (logs, reports, notes).
 *    - Appending text to existing files (when opened in append mode).
 * 
 * In this example:
 * - Creates a FileWriter for "output.txt".
 * - Writes a string into the file.
 * - Closes the FileWriter to flush and release resources.
 */
public class FileWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a FileWriter instance
            // This will create (or overwrite if already exists) a file named "output.txt"
            FileWriter fw = new FileWriter("output.txt");

            // Step 2: Write a string into the file
            fw.write("Hello FileWriter! This is Paceup");

            // Step 3: Close the FileWriter
            // Closing ensures that all data is flushed to the file and resources are released
            fw.close();

            // Step 4: Print confirmation message to the console
            System.out.println("Data written to output.txt");

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (e.g., file not found, permission issues)
            e.printStackTrace();
        }
    }
}
