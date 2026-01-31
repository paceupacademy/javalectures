package com.paceup.day13;

import java.io.FileReader;
import java.io.IOException;

/**
 * Demonstrates the use of FileReader.
 * FileReader is a character stream class used to read text files.
 * It reads characters one by one and returns their Unicode integer values.
 */
public class FileReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a FileReader instance to read from "example.txt".
            // If the file does not exist, a FileNotFoundException (subclass of IOException) will be thrown.
            FileReader fr = new FileReader("example.txt");

            // Step 2: Read characters one by one until the end of the file is reached.
            int ch;
            while ((ch = fr.read()) != -1) { // -1 indicates end of file
                // Convert the integer Unicode value to a character and print it.
                System.out.print((char) ch);
                Thread.sleep(100);
            }

            // Step 3: Close the FileReader to release system resources.
            fr.close();

        } catch (IOException e) {
            // Step 4: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
