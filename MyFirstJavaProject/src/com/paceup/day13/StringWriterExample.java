package com.paceup.day13;

import java.io.StringWriter;
import java.io.IOException;

/**
 * Demonstrates the use of StringWriter.
 * StringWriter is a character stream that collects written characters into
 * an internal String buffer, which can later be converted into a String.
 */
public class StringWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a StringWriter instance.
            // Unlike OutputStreamWriter, StringWriter does not write to files or console.
            // It stores the written characters in memory (String buffer).
            StringWriter sw = new StringWriter();

            // Step 2: Write a string into the StringWriter buffer.
            sw.write("Hello StringWriter!");

            // Step 3: Convert the buffer contents into a String and print it.
            // toString() retrieves everything written so far.
            System.out.println(sw.toString());

            // Step 4: Close the StringWriter.
            // Closing a StringWriter has no real effect (since it uses memory),
            // but it's good practice to close streams to release resources.
            sw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (though StringWriter rarely throws them).
            e.printStackTrace();
        }
    }
}
