package com.paceup.day13;

import java.io.StringReader;
import java.io.IOException;

/**
 * Demonstrates the use of StringReader.
 * StringReader is a character stream that allows reading characters
 * directly from a String as if it were an input source.
 */
public class StringReaderExample {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Define a string that will act as the input source.
        String text = "Hello from StringReader!";

        try {
            // Step 2: Create a StringReader instance using the given string.
            // This allows us to read characters from the string sequentially.
            StringReader sr = new StringReader(text);

            // Step 3: Read characters one by one until the end of the string is reached.
            int ch;
            while ((ch = sr.read()) != -1) { // -1 indicates end of stream
                System.out.print((char) ch); // Print each character
                
                Thread.sleep(100);
            }

            // Step 4: Close the StringReader to release resources.
            // Although StringReader only uses memory, closing is good practice.
            sr.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (though StringReader rarely throws them).
            e.printStackTrace();
        }
    }
}
