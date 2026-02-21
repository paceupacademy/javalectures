package com.paceup.IOStreams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * BufferedInputStreamExample:
 * ---------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **BufferedInputStream**:
 *    - A wrapper around InputStream that adds buffering capability.
 *    - Improves performance by reducing the number of I/O operations.
 *    - Reads data in chunks (buffer) instead of byte-by-byte directly from the file.
 * 
 * 2. **Important Methods**:
 *    - available(): Returns the number of bytes that can be read without blocking.
 *    - mark(int readlimit): Marks the current position in the stream.
 *    - reset(): Resets the stream to the last marked position.
 *    - skip(long n): Skips over 'n' bytes of data.
 *    - read(): Reads one byte at a time (returns -1 at end of file).
 * 
 * 3. **Mark/Reset Support**:
 *    - Not all streams support mark/reset.
 *    - BufferedInputStream supports it, but always check using markSupported().
 * 
 * 4. **Try-with-resources**:
 *    - Ensures that FileInputStream and BufferedInputStream are closed automatically.
 *    - Prevents resource leaks.
 * 
 * In this example:
 * - Reads data from "file.txt".
 * - Demonstrates available(), skip(), mark(), and reset().
 * - Shows how to re-read data after resetting to a marked position.
 */
public class BufferedInputStreamExample {

    public static void main(String[] args) {
        // try-with-resources ensures streams are closed automatically
        try (FileInputStream fin = new FileInputStream("file.txt");
             BufferedInputStream bis = new BufferedInputStream(fin)) {

            // Print how many bytes are available initially
            System.out.println("Number of bytes available: " + bis.available());

            // Check if mark/reset is supported
            boolean markSupported = bis.markSupported();
            if (markSupported) {
                // Mark the current position in the stream
                bis.mark(bis.available());
            }

            // Skip first 8 bytes
            bis.skip(8);
            System.out.println("File Data after skipping 8 bytes:\n");

            // Read and print characters until end of file
            int ch;
            while ((ch = bis.read()) != -1) {
                System.out.print((char) ch);
                // Uncomment below line to also print ASCII values
                // System.out.print("\tASCII value: " + ch);
            }

            // Reset back to the marked position (before skip)
            if (markSupported) {
                bis.reset();
                System.out.println("\n\nAfter Reset (reading from marked position):\n");

                // Read again from the marked position
                while ((ch = bis.read()) != -1) {
                    System.out.print((char) ch);
                }
            }

        } catch (IOException e) {
            // Handle exceptions like file not found or IO errors
            e.printStackTrace();
        }
    }
}
