package com.paceup.IOStreams;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedInputStreamExample:
 * ------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Piped Streams**:
 *    - Used for communication between two threads.
 *    - PipedOutputStream → writes data.
 *    - PipedInputStream → reads data.
 *    - They must be connected before use.
 * 
 * 2. **Thread Communication**:
 *    - One thread writes data into the pipe.
 *    - Another thread reads data from the pipe.
 *    - Useful for producer-consumer scenarios.
 * 
 * 3. **Important Methods**:
 *    - write(byte[] b): Writes bytes into the output stream.
 *    - read(): Reads one byte at a time (returns -1 at end of stream).
 *    - close(): Closes the stream to release resources.
 * 
 * In this example:
 * - Writer thread writes "Hello Students!!!" into the PipedOutputStream.
 * - Reader thread reads the data from PipedInputStream and prints it to the console.
 */
public class PipedInputStreamExample {
    public static void main(String[] args) throws Exception {
        // Create piped streams and connect them
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        // Writer thread: writes data into the PipedOutputStream
        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello Students!!!".getBytes()); // write string as bytes
                pos.close(); // close output stream after writing
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Reader thread: reads data from the PipedInputStream
        Thread reader = new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) { // read until end of stream
                    System.out.print((char) data); // convert byte to char and print
                }
                pis.close(); // close input stream after reading
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        writer.start();
        reader.start();
    }
}
