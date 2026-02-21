package com.paceup.IOStreams;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.IOException;

/**
 * PipedExample:
 * -------------
 * 
 * Key Concepts:
 * -------------
 * 1. **PipedWriter**:
 *    - A character stream used to write data into a pipe.
 *    - Must be connected to a PipedReader.
 * 
 * 2. **PipedReader**:
 *    - A character stream used to read data from a pipe.
 *    - Reads characters written by a connected PipedWriter.
 * 
 * 3. **Thread Communication**:
 *    - One thread writes data into the pipe.
 *    - Another thread reads data from the pipe.
 *    - Useful for producer-consumer scenarios.
 * 
 * In this example:
 * - Writer thread writes a message into the pipe.
 * - Reader thread reads the message and prints it.
 * - Demonstrates synchronous communication between threads.
 */
public class PipedExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create piped reader and writer objects
            final PipedReader reader = new PipedReader();
            final PipedWriter writer = new PipedWriter();

            // Step 2: Connect the reader and writer
            reader.connect(writer);

            // Step 3: Define the writer thread
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!";
                    System.out.println("Writer: Writing message...");
                    writer.write(message); // write message into pipe
                    writer.close();        // close writer after writing
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Step 4: Define the reader thread
            Thread readerThread = new Thread(() -> {
                try {
                    int ch;
                    System.out.println("Reader: Reading message...");
                    while ((ch = reader.read()) != -1) { // read until end of stream
                        System.out.print((char) ch);     // print each character
                    }
                    reader.close(); // close reader after reading
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Step 5: Start both threads
            writerThread.start();
            readerThread.start();

            // Step 6: Wait for both threads to finish
            writerThread.join();
            readerThread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
