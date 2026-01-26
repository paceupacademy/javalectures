package com.paceup.day13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/**
 * Demonstrates usage of PrintStream in Java.
 * Output is written to a file named "data.txt".
 */
public class PrintStreamExample {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        
        // Create a FileOutputStream to write data into "data.txt"
        FileOutputStream fos = new FileOutputStream("data.txt");
        
        // Wrap FileOutputStream with PrintStream for convenient printing
        PrintStream out = new PrintStream(fos);

        // Example string and character array
        String s = "First Word";
        char[] c = {'G', 'H', 'I', 'J'};

        // Print a boolean value
        out.print(true);
        out.println(); // Move to next line

        // Print an integer
        out.print(1);
        out.println();

        // Print a float value
        out.print(4.533f);
        out.println();

        // Print a string with newline
        out.println("Republic Day\n");
        out.println();

        // Print FileOutputStream object reference (not very useful, but possible)
        out.println(fos);
        out.println();

        // Check if any error has occurred in the stream
        out.print(out.checkError());
        out.println();

        /*
         * Demonstrating format() method:
         * format(Locale l, String format, Object... args)
         * format(String format, Object... args)
         * Locale can be null or a specific locale (e.g., Locale.UK)
         */
        out.format(Locale.UK, "Welcome to India %s", s);
        out.println();

        // Format without specifying locale
        out.format("Welcome to India %s", s);
        out.println();

        // Print a string (may stay in buffer until flushed)
        out.print("Hello Aishwarya");
        
        // Force flush to ensure data is written immediately
        out.flush();

        // Pause for 10 seconds to demonstrate delayed writing
        Thread.sleep(10000);

        // Print after flush
        out.println("Printed after flush");
        out.flush();

        // Close the PrintStream (also closes underlying FileOutputStream)
        out.close();
    }
}
