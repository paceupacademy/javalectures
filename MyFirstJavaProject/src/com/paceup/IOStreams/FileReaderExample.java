package com.paceup.IOStreams;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReaderExample:
 * ------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **FileReader**:
 *    - A character stream class used to read text files.
 *    - Reads characters one by one and returns their Unicode integer values.
 *    - Suitable for reading plain text files (not binary data).
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one character at a time, returns its Unicode int value (-1 at end of file).
 *    - close(): Closes the stream and releases system resources.
 * 
 * 3. **Use Cases**:
 *    - Reading text files character by character.
 *    - Useful for simple text processing or parsing.
 * 
 * In this example:
 * - Reads characters from "example.txt".
 * - Prints them to the console with a small delay.
 * - Closes the FileReader after use.
 */
public class FileReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a FileReader instance to read from "example.txt"
            FileReader fr = new FileReader("example.txt");

            // Step 2: Read characters one by one until EOF (-1)
            int ch;
            while ((ch = fr.read()) != -1) {
                // Convert Unicode int to char and print
                System.out.print((char) ch);
                Thread.sleep(100); // 100ms delay for demonstration
            }

            // Step 3: Close the FileReader to release resources
            fr.close();

        } catch (IOException e) {
            // Step 4: Handle I/O exceptions (e.g., file not found, permission issues)
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Handle thread interruption during sleep
            e.printStackTrace();
        }
    }
}
