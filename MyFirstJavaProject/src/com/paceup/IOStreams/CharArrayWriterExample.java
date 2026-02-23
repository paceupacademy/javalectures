package com.paceup.IOStreams;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * CharArrayWriterExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **CharArrayWriter**:
 *    - A character stream that writes data into an internal char array buffer.
 *    - The buffer grows automatically as more data is written.
 *    - Unlike FileWriter, it stores data in memory instead of writing directly to disk.
 * 
 * 2. **Important Methods**:
 *    - write(String str): Writes a string into the buffer.
 *    - toString(): Returns the buffer contents as a String.
 *    - close(): Closes the stream (optional since it only uses memory).
 * 
 * 3. **Use Cases**:
 *    - Useful for collecting character data in memory before writing to a file.
 *    - Ideal for temporary storage, string manipulation, or testing.
 * 
 * In this example:
 * - Creates a CharArrayWriter.
 * - Writes a string into the buffer.
 * - Converts the buffer contents into a String and prints it.
 * - Closes the writer (good practice, though optional).
 */
public class CharArrayWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a CharArrayWriter instance
            CharArrayWriter caw = new CharArrayWriter();

            // Step 2: Write a string into the buffer
            caw.write("Hello CharArrayWriter!");

            // Step 3: Convert buffer contents into a String and print
            System.out.println(caw.toString());

            // Step 4: Close the CharArrayWriter (optional but good practice)
            caw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (rare for CharArrayWriter)
            e.printStackTrace();
        }
    }
}
