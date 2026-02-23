package com.paceup.IOStreams;

import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * OutputStreamWriterExample:
 * --------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **OutputStreamWriter**:
 *    - Acts as a bridge between character streams and byte streams.
 *    - Converts characters into bytes using a specified charset (default is platform charset).
 *    - Useful when writing text data to byte-based destinations (e.g., System.out, files, sockets).
 * 
 * 2. **Important Methods**:
 *    - write(String str): Writes a string to the output stream.
 *    - flush(): Ensures buffered characters are converted into bytes and written immediately.
 *    - close(): Closes the stream, flushing any remaining data.
 * 
 * 3. **System.out**:
 *    - Represents the console as a byte stream.
 *    - OutputStreamWriter allows writing characters directly to the console.
 * 
 * In this example:
 * - Creates an OutputStreamWriter wrapping System.out.
 * - Writes a string message to the console.
 * - Flushes and closes the stream to ensure proper output.
 */
public class OutputStreamWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create an OutputStreamWriter that writes to System.out (console).
            OutputStreamWriter osw = new OutputStreamWriter(System.out);

            // Step 2: Write a string message to the output stream.
            osw.write("Hello OutputStreamWriter!");

            // Step 3: Flush the stream to ensure all data is written to the console.
            osw.flush();

            // Step 4: Close the stream to release resources.
            osw.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions that may occur during writing or closing.
            e.printStackTrace();
        }
    }
}
