package com.paceup.IOStreams;

import java.io.*;

/**
 * ByteStreamExample:
 * ------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Byte Streams**:
 *    - Used for handling binary data (images, audio, video, raw bytes).
 *    - FileInputStream → reads raw bytes from a file.
 *    - FileOutputStream → writes raw bytes to a file.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one byte at a time, returns it as an integer (returns -1 at end of file).
 *    - write(int b): Writes a single byte to the output stream.
 * 
 * 3. **Try-with-resources**:
 *    - Ensures streams are closed automatically.
 *    - Prevents resource leaks and makes code cleaner.
 * 
 * 4. **Use Cases**:
 *    - Copying binary files (images, audio, video).
 *    - Reading/writing raw byte data.
 * 
 * In this example:
 * - Reads bytes from "input.txt".
 * - Writes them into "output2.txt".
 * - Prints characters to console while copying.
 */
public class ByteStreamExample {
    public static void main(String[] args) throws IOException { 
        // try-with-resources ensures streams are closed automatically
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output2.txt")) { 

            int data;
            // Read one byte at a time until end of file (-1)
            while ((data = fis.read()) != -1) { 
                // Write byte to output file
                fos.write(data);

                // Print character representation of byte to console
                System.out.print(" " + (char) data);
            }

            // Streams are auto-closed by try-with-resources
        } catch (IOException e) {
            // Handle exceptions (like file not found or IO errors)
            e.printStackTrace();
        }
    }
}
