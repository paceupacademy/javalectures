package com.paceup.day13;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Demonstrates usage of PipedInputStream and PipedOutputStream in Java.
 * These streams are used for communication between two threads:
 * one thread writes data, and another thread reads it.
 */
public class PipedInputStreamExample {
    public static void main(String[] args) throws Exception {
        // Create piped streams and connect them
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        // Writer thread: writes data into the PipedOutputStream
        Thread writer = new Thread(() -> {
            try {
                // Write a string as bytes
                pos.write("Hello Students!!!".getBytes());

                // Close the output stream after writing
                pos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Reader thread: reads data from the PipedInputStream
        Thread reader = new Thread(() -> {
            try {
                int data;
                // Read until end of stream (-1)
                while ((data = pis.read()) != -1) {
                    // Convert byte to char and print
                    System.out.print((char) data);
                }

                // Close the input stream after reading
                pis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        writer.start();
        reader.start();
    }
}
