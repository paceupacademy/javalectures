package com.paceup.IOStreams;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * CharArrayReaderExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **CharArrayReader**:
 *    - A subclass of Reader that reads characters directly from a char array.
 *    - Useful for testing, parsing, or treating in-memory data as a stream.
 * 
 * 2. **Important Methods**:
 *    - read(): Reads one character at a time (returns -1 at end of array).
 *    - skip(long n): Skips 'n' characters in the array.
 *    - mark(int readAheadLimit): Marks the current position in the stream.
 *    - reset(): Resets the stream to the last marked position.
 *    - close(): Closes the stream (though it only uses memory, closing is good practice).
 * 
 * 3. **Use Cases**:
 *    - Simulating file/stream input using in-memory data.
 *    - Useful in parsers or when you want to test stream-based logic without actual files.
 * 
 * In this example:
 * - Defines a char array as the input source.
 * - Skips the first two characters.
 * - Reads characters one by one, marking when 'H' is encountered.
 * - Resets back to the marked position and reads again.
 */
public class CharArrayReaderExample {
    public static void main(String[] args) {
        // Step 1: Define a character array that will act as the input source
        char[] data = {'A', 'B', 'H', 'e', 'l', 'l', 'o'};

        try {
            // Step 2: Create a CharArrayReader instance using the char array
            CharArrayReader car = new CharArrayReader(data);

            // Step 3: Skip the first two characters
            car.skip(2);

            int ch;
            while ((ch = car.read()) != -1) { // -1 indicates end of stream
                if ((char) ch == 'H') {
                    // Mark the position when 'H' is encountered
                    car.mark(0);
                }
                System.out.print((char) ch);  // Print each character
                Thread.sleep(100);            // Small delay for demonstration
            }

            // Step 4: Reset back to the marked position
            car.reset();
            System.out.println("\nAfter reset: " + (char) car.read());

            // Step 5: Close the CharArrayReader
            car.close();

        } catch (IOException e) {
            // Handle I/O exceptions (though CharArrayReader rarely throws them)
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Handle thread interruption during sleep
            e.printStackTrace();
        }
    }
}
