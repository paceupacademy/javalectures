package com.paceup.IOStreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/**
 * PrintStreamExample:
 * -------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **PrintStream**:
 *    - Wraps around an OutputStream (e.g., FileOutputStream).
 *    - Provides convenient methods to print values in human-readable form.
 *    - Supports printing of primitive types, objects, and formatted strings.
 *    - Unlike PrintWriter, PrintStream works with bytes but still prints text easily.
 * 
 * 2. **Important Methods**:
 *    - print()/println(): Prints values with or without newline.
 *    - format(): Prints formatted strings (similar to printf).
 *    - checkError(): Checks if any error has occurred in the stream.
 *    - flush(): Forces buffered data to be written immediately.
 * 
 * 3. **Use Cases**:
 *    - Writing formatted text to files.
 *    - Logging output in readable form.
 *    - Printing primitive values and objects directly.
 * 
 * In this example:
 * - Wraps a FileOutputStream with PrintStream.
 * - Demonstrates printing of different data types.
 * - Uses format() with and without Locale.
 * - Shows flushing and error checking.
 */
public class PrintStreamExample {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        
        // Step 1: Create a FileOutputStream to write data into "data.txt"
        FileOutputStream fos = new FileOutputStream("data.txt");
        
        // Step 2: Wrap FileOutputStream with PrintStream for convenient printing
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

        // Print FileOutputStream object reference (prints its toString representation)
        out.println(fos);
        out.println();

        // Check if any error has occurred in the stream
        out.print(out.checkError());
        out.println();

        /*
         * Demonstrating format() method:
         * format(Locale l, String format, Object... args)
         * format(String format, Object... args)
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
