package com.paceup.day13;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * Demonstrates the use of CharArrayWriter.
 * CharArrayWriter is a character stream that writes data into an internal
 * char array buffer. The buffer grows automatically as data is written.
 */
public class CharArrayWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a CharArrayWriter instance.
            // This writer stores characters in an internal char array buffer.
            CharArrayWriter caw = new CharArrayWriter();

            // Step 2: Write a string into the buffer.
            // The buffer expands automatically to accommodate the data.
            caw.write("Hello CharArrayWriter!");

            // Step 3: Convert the buffer contents into a String and print it.
            // toString() retrieves all characters written so far.
            System.out.println(caw.toString());

            // Step 4: Close the CharArrayWriter.
            // Closing is optional because CharArrayWriter only uses memory,
            // but it's good practice to close streams to release resources.
            caw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (though CharArrayWriter rarely throws them).
            e.printStackTrace();
        }
    }
}
