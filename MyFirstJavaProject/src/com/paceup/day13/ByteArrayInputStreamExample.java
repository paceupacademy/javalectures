package com.paceup.day13;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamExample {

    public static void main(String[] args) {
        // Define a byte array (ASCII values)
        byte[] buffer = {72, 64, 69, 75, 83, 76, 84, 90}; 
        // 72 = 'H', 64 = '@', 69 = 'E', 75 = 'K', etc.

        ByteArrayInputStream bis = null;

        try {
            // Create ByteArrayInputStream from the byte array
            bis = new ByteArrayInputStream(buffer);

            // Print how many bytes are available initially
            System.out.println("Bytes available at start: " + bis.available());
            System.out.println("\nReading bytes one by one:\n");

            // Iterate through the buffer
            for (byte b : buffer) {
                // When 4 bytes remain, mark the current position
                if (bis.available() == 4) {
                    bis.mark(0); // mark() saves the current position
                }

                // Read one byte and print its character representation
                System.out.print((char) bis.read() + "\t");

                // Check if mark/reset is supported
                boolean check = bis.markSupported();
                System.out.print(" markSupported=" + check + "\n");
            }

            // If mark/reset is supported, reset back to the marked position
            if (bis.markSupported()) {
                bis.reset(); // resets to the position where mark() was called

                System.out.println("\nAfter reset, reading remaining bytes:");
                // Read remaining bytes after reset
                int data;
                while ((data = bis.read()) != -1) {
                    System.out.print(" " + (char) data);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
