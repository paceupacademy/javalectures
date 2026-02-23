package com.paceup.IOStreams;

import java.io.*;

/**
 * CharacterStreamExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Character Streams**:
 *    - Specifically designed for handling text data (characters, Unicode).
 *    - FileReader → reads characters from a file.
 *    - FileWriter → writes characters to a file.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one character at a time, returns its Unicode integer value (-1 at end of file).
 *    - write(int c): Writes a single character to the output stream.
 * 
 * 3. **Try-with-resources**:
 *    - Ensures FileReader and FileWriter are closed automatically.
 *    - Prevents resource leaks and makes code cleaner.
 * 
 * 4. **Use Cases**:
 *    - Reading/writing plain text files.
 *    - Suitable for character data (not binary data like images/audio).
 * 
 * In this example:
 * - Reads characters from "input.txt".
 * - Writes them into "output3.txt".
 * - Prints the Unicode integer value of each character to the console.
 */
public class CharacterStreamExample {
    public static void main(String[] args) {
        // Step 1: Use try-with-resources to automatically close streams after use.
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output3.txt")) {

            int data; // variable to hold each character read (Unicode int value)

            // Step 2: Read characters one by one until end of file (-1).
            while ((data = fr.read()) != -1) {
                // Write the character to the output file.
                fw.write(data);

                // Print the Unicode integer value of the character to the console.
                System.out.println("Data " + data);
            }

            // Step 3: Streams are auto-closed by try-with-resources.
            // No need to call fr.close() and fw.close() manually.

        } catch (IOException e) {
            // Step 4: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        }
    }
}
