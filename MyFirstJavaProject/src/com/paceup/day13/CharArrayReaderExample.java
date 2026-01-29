package com.paceup.day13;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Demonstrates the use of CharArrayReader.
 * CharArrayReader allows reading characters directly from a char array
 * as if it were an input source (like a file or stream).
 */
public class CharArrayReaderExample {
    public static void main(String[] args) {
        // Step 1: Define a character array that will act as the input source.
        char[] data = {'A', 'B','H', 'e', 'l', 'l', 'o'};

        try {
            // Step 2: Create a CharArrayReader instance using the char array.
            // This enables sequential reading of characters from the array.
            CharArrayReader car = new CharArrayReader(data);

            // Step 3: Read characters one by one until the end of the array is reached.
            
            car.skip(2);
            int ch;
            while ((ch = car.read()) != -1) { // -1 indicates end of stream
            	if((char)ch == 'H') {
            		//continue; //skip remaining code and current iteration and jump to next iteration
            		car.mark(0);
            	}
                System.out.print((char) ch);  // Print each character
                Thread.sleep(100);
            }
            
            car.reset();
            System.out.println("\nAfter reset: "+(char)car.read());
            // Step 4: Close the CharArrayReader to release resources.
            // Although it only uses memory, closing is good practice.
            car.close();

        } catch (IOException e) {
            // Step 5: Handle any I/O exceptions (though CharArrayReader rarely throws them).
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
