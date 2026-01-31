package com.paceup.day13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Demonstrates usage of BufferedInputStream in Java.
 * Reads data from "file.txt" and shows how mark(), skip(), and reset() work.
 */
public class BufferedInputStreamExample {

    public static void main(String[] args) {
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
