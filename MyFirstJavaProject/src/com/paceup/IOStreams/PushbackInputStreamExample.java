package com.paceup.IOStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * PushbackInputStreamExample:
 * ---------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **PushbackInputStream**:
 *    - Extends FilterInputStream.
 *    - Allows "unreading" bytes (pushing them back into the stream).
 *    - Useful for parsers where you need to look ahead and then push data back.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one byte at a time (returns -1 at end of file).
 *    - unread(int b): Pushes back a single byte into the stream.
 *    - close(): Closes the stream and releases resources.
 * 
 * 3. **Use Cases**:
 *    - Lexical analyzers and parsers.
 *    - Situations where you need to peek at data and then reprocess it.
 * 
 * In this example:
 * - Reads the first byte from "input.txt".
 * - If the first character is '#', it is pushed back into the stream.
 * - Reads and prints the remaining data.
 * - Demonstrates behavior after EOF (returns -1).
 */
public class PushbackInputStreamExample {

    public static void main(String[] args) {
        try (PushbackInputStream pis = new PushbackInputStream(new FileInputStream("input.txt"))) {

            // Read the first byte
            int ch = pis.read();
            System.out.println("\nFirst Data: " + (char) ch);

            // If the first character is '#', push it back into the stream
            if (ch == '#') {
                pis.unread(ch); // unread allows us to "put back" the byte
                System.out.println("Found #, pushed back into stream");
            }

            // Read remaining data from the file
            System.out.println("\nRemaining Data:");
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }

            // Attempt to read again after EOF (will return -1)
            int c = pis.read();
            if (c != -1) {
                System.out.println("\nExtra read: " + (char) c);
            } else {
                System.out.println("\nNo more data to read.");
            }

        } catch (FileNotFoundException e) {
            // Handle case where file is not found
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            // Handle general I/O errors
            e.printStackTrace();
        }
    }
}
