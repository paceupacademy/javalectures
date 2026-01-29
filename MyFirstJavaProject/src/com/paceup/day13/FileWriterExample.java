package com.paceup.day13;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates the use of FileWriter.
 * FileWriter is a character stream class used to write text data into files.
 */
public class FileWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a FileWriter instance.
            // This will create (or overwrite if already exists) a file named "output.txt".
            FileWriter fw = new FileWriter("output.txt");

            // Step 2: Write a string into the file.
            fw.write("Hello FileWriter! This is Paceup");

            // Step 3: Close the FileWriter.
            // Closing ensures that all data is flushed to the file and resources are released.
            fw.close();

            // Step 4: Print confirmation message to the console.
            System.out.println("Data written to output.txt");

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        }
    }
}
