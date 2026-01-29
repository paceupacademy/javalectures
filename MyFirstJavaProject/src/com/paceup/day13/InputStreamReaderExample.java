package com.paceup.day13;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * Demonstrates the use of InputStreamReader.
 * InputStreamReader acts as a bridge between byte streams and character streams.
 * It converts bytes (from System.in) into characters using the default charset.
 */
public class InputStreamReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create an InputStreamReader to read from System.in (keyboard input).
            // System.in provides input as a byte stream, so InputStreamReader converts it into characters.
            InputStreamReader isr = new InputStreamReader(System.in);

            // Step 2: Prompt the user to type something.
            System.out.println("Type something: ");

            // Step 3: Read characters one by one until a newline ('\n') is encountered.
            int ch;
            while ((ch = isr.read()) != '\n') { // loop continues until Enter key is pressed
            	System.out.print((char) ch);    // print each character as it is read
            }

            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
            System.out.println("Enter data:");
            String input = br.readLine();
            input  =  input.replace("\\n", "\n"); // '\\' -> escape the sequence for single backslash 
            
            System.out.println(input);
            // Step 4: Close the InputStreamReader to release resources.
            isr.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (e.g., input/output errors).
            e.printStackTrace();
        }
    }
}
