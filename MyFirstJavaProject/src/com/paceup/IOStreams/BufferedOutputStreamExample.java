package com.paceup.IOStreams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * BufferedOutputStreamExample:
 * ----------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **BufferedOutputStream**:
 *    - A wrapper around OutputStream that adds buffering capability.
 *    - Improves performance by reducing the number of direct write operations to the file.
 *    - Data is collected in a buffer and written in larger chunks.
 * 
 * 2. **Important Methods**:
 *    - write(byte[] b, int off, int len): Writes 'len' bytes from the array starting at index 'off'.
 *    - flush(): Forces any buffered output bytes to be written immediately.
 * 
 * 3. **Try-with-resources**:
 *    - Ensures FileOutputStream and BufferedOutputStream are closed automatically.
 *    - Prevents resource leaks and makes code cleaner.
 * 
 * In this example:
 * - A string is converted into a byte array.
 * - The first 5 characters are skipped, and the rest are written to "abc.txt".
 * - flush() ensures all buffered data is written to the file.
 */
public class BufferedOutputStreamExample {

    public static void main(String[] args) {
        // String data to be written into the file
        String data = "Buffered Output Stream Java Example !!";

        // try-with-resources ensures streams are closed automatically
        try (FileOutputStream fos = new FileOutputStream("abc.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            // Convert string into byte array
            byte[] bytes = data.getBytes();

            // Print length of byte array (number of bytes in the string)
            System.out.println("Total bytes: " + bytes.length);

            /*
             * Write bytes to file starting from index 5
             * and write (bytes.length - 5) bytes.
             * This means the first 5 characters are skipped.
             */
            bos.write(bytes, 5, bytes.length - 5);

            // Flush buffered data to ensure it's written to the file
            bos.flush();

            System.out.println("Data is written to file successfully.");
        } catch (Exception e) {
            // Handle any exceptions (like file not found or IO errors)
            e.printStackTrace();
        }
    }
}
