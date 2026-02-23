package com.paceup.IOStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReaderExample:
 * ----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **BufferedReader**:
 *    - Wraps around a Reader (like FileReader or InputStreamReader).
 *    - Buffers characters for efficient reading.
 *    - Provides convenient methods like `readLine()` for line-by-line reading.
 * 
 * 2. **FileReader + BufferedReader**:
 *    - Reads text from a file efficiently.
 *    - Suitable for reading large text files line by line.
 * 
 * 3. **InputStreamReader + BufferedReader**:
 *    - Converts byte input (System.in) into characters.
 *    - Allows reading user input from the console.
 * 
 * 4. **Thread.sleep()**:
 *    - Demonstrates a delay between reading lines (1 second per line).
 * 
 * In this example:
 * - Reads lines from "example.txt" using BufferedReader.
 * - Prints each line with a 1-second delay.
 * - Then reads user input from the console and greets the user.
 */
public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a BufferedReader instance for file reading
            BufferedReader br = new BufferedReader(new FileReader("example.txt"));

            // Step 2: Read the file line by line until EOF
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(1000); // 1000ms = 1 second delay
            }

            // Step 3: Close the BufferedReader
            br.close();

            // Step 4: Create a BufferedReader for console input
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name:");
            String name = br1.readLine();
            System.out.println("Hello, " + name + "!");

        } catch (IOException e) {
            // Handle file not found or I/O errors
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Handle thread interruption during sleep
            e.printStackTrace();
        }
    }
}
