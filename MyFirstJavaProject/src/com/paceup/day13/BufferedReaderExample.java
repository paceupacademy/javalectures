package com.paceup.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demonstrates the use of BufferedReader.
 * BufferedReader reads text efficiently by buffering characters,
 * allowing line-by-line reading instead of character-by-character.
 */
public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a BufferedReader instance.
            // FileReader reads characters from the file "example.txt".
            // Wrapping it with BufferedReader improves efficiency and provides convenient methods like readLine().
            BufferedReader br = new BufferedReader(new FileReader("example.txt"));

            // Step 2: Read the file line by line until the end of the file is reached.
            String line;
            while ((line = br.readLine()) != null) {
                // Print each line to the console.
                System.out.println(line);
                Thread.sleep(1000); //1000ms -> 1 second
            }

            // Step 3: Close the BufferedReader to release system resources.
            br.close();
            
            BufferedReader br1 =  new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name:");
            String name = br1.readLine();
            System.out.println("Hello, "+name+"!");

        } catch (IOException e) {
            // Step 4: Handle any I/O exceptions (e.g., file not found, permission issues).
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
