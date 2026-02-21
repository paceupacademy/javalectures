package com.paceup.IOStreams;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * InputStreamReaderExample:
 * -------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **InputStreamReader**:
 *    - Acts as a bridge between byte streams and character streams.
 *    - Converts bytes (from System.in or any InputStream) into characters using a charset.
 *    - Default charset is platform-dependent, but can be specified explicitly.
 * 
 * 2. **BufferedReader**:
 *    - Wraps around InputStreamReader for efficient reading.
 *    - Provides convenient methods like `readLine()` for reading text line by line.
 * 
 * 3. **System.in**:
 *    - Provides input from the keyboard as a byte stream.
 *    - InputStreamReader converts these bytes into characters for easier handling.
 * 
 * In this example:
 * - Reads characters one by one until Enter (`\n`) is pressed.
 * - Then uses BufferedReader to read an entire line of text.
 * - Demonstrates both character-by-character and line-by-line input handling.
 */
public class InputStreamReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create an InputStreamReader to read from System.in (keyboard input).
            InputStreamReader isr = new InputStreamReader(System.in);

            // Step 2: Prompt the user to type something.
            System.out.println("Type something: ");

            // Step 3: Read characters one by one until a newline ('\n') is encountered.
            int ch;
            while ((ch = isr.read()) != '\n') { // loop continues until Enter key is pressed
                System.out.print((char) ch);    // print each character as it is read
            }

            // Step 4: Use BufferedReader for line-based input.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter data:");
            String input = br.readLine();

            // Replace escaped newline sequence with actual newline (if present)
            input = input.replace("\\n", "\n"); 

            // Print the final input
            System.out.println("You entered:\n" + input);

            // Step 5: Close InputStreamReader to release resources.
            isr.close();

        } catch (IOException e) {
            // Step 6: Handle any I/O exceptions (e.g., input/output errors).
            e.printStackTrace();
        }
    }
}
