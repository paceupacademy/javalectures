package com.paceup.day13;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Demonstrates usage of BufferedOutputStream in Java.
 * Data is written to a file named "abc.txt".
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
