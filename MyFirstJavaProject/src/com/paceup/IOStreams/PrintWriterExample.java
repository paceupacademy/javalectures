package com.paceup.IOStreams;

import java.io.PrintWriter;
import java.util.Locale;

/**
 * PrintWriterExample:
 * -------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **PrintWriter**:
 *    - A character stream class used for writing formatted text.
 *    - Provides convenient methods like `print()`, `println()`, `append()`, and `format()`.
 *    - Unlike PrintStream, PrintWriter works with characters rather than bytes.
 * 
 * 2. **Important Methods**:
 *    - print()/println(): Prints values with or without newline.
 *    - append(CharSequence): Appends text to the output.
 *    - format(Locale l, String format, Object... args): Prints formatted strings.
 *    - flush(): Forces buffered data to be written immediately.
 *    - close(): Closes the stream and releases resources.
 * 
 * 3. **Use Cases**:
 *    - Writing text to files or console in a human-readable format.
 *    - Logging, reporting, or generating formatted output.
 * 
 * In this example:
 * - Demonstrates printing of different data types (boolean, int, float, double, String).
 * - Uses `append()` to add a sequence of characters.
 * - Uses `format()` with and without Locale.
 * - Flushes and closes the writer to ensure proper output.
 */
public class PrintWriterExample {
    public static void main(String[] args) {
        // Step 1: Create a PrintWriter instance that writes to the console (System.out)
        PrintWriter pw = new PrintWriter(System.out);

        String s = "Hello World!! This is Aishwarya";
        char[] c = {'A', 'B', 'C', 'D'};

        // Step 2: Demonstrate printing of different data types
        pw.print(true);       // boolean
        pw.print(1);          // integer
        pw.print(4.533f);     // float
        pw.print(8.66);       // double
        pw.print("Hi There!!"); // string

        pw.println(); // newline

        // Step 3: Append a sequence of characters
        pw.append(s.subSequence(0, s.length()));
        pw.println();

        // Step 4: Use format() with Locale
        pw.format(Locale.UK, "This is my * %s * sentence", s);
        pw.println();

        // Step 5: Flush and close the PrintWriter
        pw.flush();
        pw.close();
    }
}
