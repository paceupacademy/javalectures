package com.paceup.IOStreams;

import java.io.StringWriter;
import java.io.IOException;

/**
 * StringWriterExample:
 * --------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **StringWriter**:
 *    - A character stream that collects written characters into an internal buffer.
 *    - The buffer grows automatically as more data is written.
 *    - Unlike FileWriter, StringWriter stores data in memory instead of writing to disk.
 * 
 * 2. **Important Methods**:
 *    - write(String str): Writes a string into the buffer.
 *    - toString(): Returns the buffer contents as a String.
 *    - close(): Closes the stream (optional since it only uses memory).
 * 
 * 3. **Use Cases**:
 *    - Useful for temporary storage of text data in memory.
 *    - Ideal for string manipulation, testing, or collecting output before saving to a file.
 * 
 * In this example:
 * - Creates a StringWriter.
 * - Writes a string into the buffer.
 * - Converts the buffer contents into a String and prints it.
 * - Closes the writer (good practice, though optional).
 */
public class StringWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a StringWriter instance
            StringWriter sw = new StringWriter();

            // Step 2: Write a string into the buffer
            sw.write("Hello StringWriter!");

            // Step 3: Convert buffer contents into a String and print
            System.out.println(sw.toString());

            // Step 4: Close the StringWriter (optional but good practice)
            sw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (rare for StringWriter)
            e.printStackTrace();
        }
    }
}
