package com.paceup.day13;

import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * Demonstrates the use of OutputStreamWriter.
 * OutputStreamWriter is a bridge between character streams and byte streams.
 * It converts characters into bytes using a specified charset (default is platform charset).
 */
public class OutputStreamWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create an OutputStreamWriter that writes to System.out (console).
            // System.out is a byte stream, so OutputStreamWriter helps convert characters into bytes.
            OutputStreamWriter osw = new OutputStreamWriter(System.out);

            // Step 2: Write a string message to the output stream.
            osw.write("Hello OutputStreamWriter!");

            // Step 3: Flush the stream to ensure all data is actually written to the console.
            // Without flush(), some data may remain in the buffer.
            osw.flush();

            // Step 4: Close the stream to release resources.
            // Closing also flushes any remaining data before shutting down the stream.
            osw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions that may occur during writing or closing.
            e.printStackTrace();
        }
    }
}
