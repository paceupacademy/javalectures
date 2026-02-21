package com.paceup.IOStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * ByteArrayInputStreamExample:
 * ----------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **ByteArrayInputStream**:
 *    - A subclass of InputStream that reads data from a byte array in memory.
 *    - Useful for testing, parsing, or simulating input without using actual files.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one byte at a time (returns -1 at end of array).
 *    - available(): Returns the number of bytes left to read.
 *    - mark(int readlimit): Marks the current position in the stream.
 *    - reset(): Resets the stream to the last marked position.
 *    - skip(long n): Skips over 'n' bytes in the array.
 * 
 * 3. **Advantages**:
 *    - Fast since it works entirely in memory.
 *    - No I/O overhead compared to file-based streams.
 *    - Supports mark/reset operations.
 * 
 * In this example:
 * - A byte array is defined with ASCII values.
 * - The stream reads and prints characters.
 * - Demonstrates mark(), skip(), and reset() functionality.
 */
public class ByteArrayInputStreamExample {

    public static void main(String[] args) {
        // Define a byte array (ASCII values)
        byte[] buffer = {72, 64, 69, 75, 83, 76, 84, 90}; 
        // 72 = 'H', 64 = '@', 69 = 'E', 75 = 'K', 83 = 'S', 76 = 'L', 84 = 'T', 90 = 'Z'

        // Create ByteArrayInputStream from the byte array
        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer)) {

            // Print how many bytes are available initially
            System.out.println("Number of bytes available: " + bais.available());

            // Mark the current position
            if (bais.markSupported()) {
                bais.mark(buffer.length);
            }

            // Skip first 2 bytes
            bais.skip(2);
            System.out.println("Data after skipping 2 bytes:\n");

            // Read and print characters until end of array
            int ch;
            while ((ch = bais.read()) != -1) {
                System.out.print((char) ch + " ");
            }

            // Reset back to the marked position
            if (bais.markSupported()) {
                bais.reset();
                System.out.println("\n\nAfter Reset (reading from marked position):\n");

                // Read again from the marked position
                while ((ch = bais.read()) != -1) {
                    System.out.print((char) ch + " ");
                }
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
