package com.paceup.day13;

import java.io.*;

/**
 * Demonstrates the use of Character Streams in Java.
 * Character streams are specifically designed for handling text data.
 * FileReader reads characters from a file, while FileWriter writes characters to a file.
 */
public class CharacterStreamExample {
    public static void main(String[] args) {
        // Step 1: Use try-with-resources to automatically close streams after use.
        // FileReader reads characters from "input.txt".
        // FileWriter writes characters to "output3.txt".
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output3.txt")) {

            int data; // variable to hold each character read (as its Unicode int value)

            // Step 2: Read characters one by one until end of file (-1).
            while ((data = fr.read()) != -1) {
                // Write the character to the output file.
                fw.write(data);

                // Print the Unicode integer value of the character to the console.
                System.out.println("Data " + data);
            }

            // Step 3: Streams will be closed automatically because of try-with-resources.
            // Explicit close() calls are not required here, but included in original code.
            // (No need to call fr.close() and fw.close() manually.)

        } catch (IOException e) {
            // Step 4: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        }
    }
}
