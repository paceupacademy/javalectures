package com.paceup.day13;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.IOException;

/**
 * Demonstrates inter-thread communication using PipedReader and PipedWriter.
 * One thread writes data into the pipe, and another thread reads it.
 */
public class PipedExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create piped reader and writer objects
            final PipedReader reader = new PipedReader();
            final PipedWriter writer = new PipedWriter();

            // Step 2: Connect the reader and writer so they can communicate
            reader.connect(writer);

            // Step 3: Define the writer thread
            Thread writerThread = new Thread(() -> {
                try {
                    // Message to be sent through the pipe
                    String message = "Hello from Writer Thread!";
                    System.out.println("Writer: Writing message...");

                    // Write the message into the pipe
                    writer.write(message);

                    // Close the writer after writing to release resources
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Step 4: Define the reader thread
            Thread readerThread = new Thread(() -> {
                try {
                    int ch;
                    System.out.println("Reader: Reading message...");

                    // Read characters one by one from the pipe until end of stream (-1)
                    while ((ch = reader.read()) != -1) {
                        System.out.print((char) ch); // Print each character
                    }

                    // Close the reader after reading to release resources
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Step 5: Start both threads to begin communication
            writerThread.start();
            readerThread.start();

            // Step 6: Wait for both threads to finish execution
            writerThread.join();
            readerThread.join();

        } catch (Exception e) {
            // Handle any exceptions that occur during setup or execution
            e.printStackTrace();
        }
    }
}
