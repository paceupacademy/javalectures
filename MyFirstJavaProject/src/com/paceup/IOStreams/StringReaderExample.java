package com.paceup.IOStreams;

import java.io.StringReader;
import java.io.IOException;

/**
 * StringReaderExample:
 * --------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **StringReader**:
 *    - A character stream that reads characters directly from a String.
 *    - Treats a String as an input source (like a file or stream).
 *    - Useful for testing, parsing, or when you want to process text in memory.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one character at a time, returns its Unicode int value (-1 at end of string).
 *    - close(): Closes the stream (optional since it only uses memory, but good practice).
 * 
 * 3. **Use Cases**:
 *    - Simulating input streams using in-memory strings.
 *    - Useful in parsers or when you want to test stream-based logic without actual files.
 * 
 * In this example:
 * - Defines a String as the input source.
 * - Reads characters sequentially until the end of the string.
 * - Prints each character with a small delay.
 * - Closes the StringReader after use.
 */
public class StringReaderExample {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Define a string that will act as the input source
        String text = "Hello from StringReader!";

        try {
            // Step 2: Create a StringReader instance using the given string
            StringReader sr = new StringReader(text);

            // Step 3: Read characters one by one until end of string (-1)
            int ch;
            while ((ch = sr.read()) != -1) {
                System.out.print((char) ch); // Print each character
                Thread.sleep(100);           // Small delay for demonstration
            }

            // Step 4: Close the StringReader (optional but good practice)
            sr.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (rare for StringReader)
            e.printStackTrace();
        }
    }
}
