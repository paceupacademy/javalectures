package com.paceup.IOStreams;

import java.io.*;

/**
 * ConversionStreamExample:
 * ------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Conversion Streams**:
 *    - Bridge the gap between byte streams and character streams.
 *    - InputStreamReader → converts bytes into characters.
 *    - OutputStreamWriter → converts characters into bytes.
 * 
 * 2. **InputStreamReader**:
 *    - Wraps around a byte stream (e.g., FileInputStream).
 *    - Decodes bytes into characters using a specified charset (default: platform charset).
 * 
 * 3. **BufferedReader**:
 *    - Adds efficiency by buffering input.
 *    - Provides convenient methods like `readLine()` for reading text line by line.
 * 
 * 4. **Try-with-resources**:
 *    - Ensures streams are closed automatically.
 *    - Prevents resource leaks and makes code cleaner.
 * 
 * In this example:
 * - Reads text from "input.txt" using InputStreamReader.
 * - BufferedReader is used to read line by line.
 * - Each line is printed to the console.
 */
public class ConversionStreamExample {
    public static void main(String[] args) {
        // try-with-resources ensures streams are closed automatically
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            // Read file line by line until end of file (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println("\n"); // extra newline for clarity
            }

            // Streams are auto-closed by try-with-resources
            // No need to call isr.close() and br.close() manually

        } catch (IOException e) {
            // Handle exceptions like file not found or IO errors
            e.printStackTrace();
        }
    }
}
