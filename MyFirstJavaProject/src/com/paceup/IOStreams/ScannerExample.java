package com.paceup.IOStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ScannerExample:
 * ---------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Console Input**:
 *    - Scanner can read different data types (String, int, double) from System.in.
 * 
 * 2. **File Input**:
 *    - Scanner can read text files line by line (`hasNextLine()` + `nextLine()`).
 *    - Scanner can also read word by word (`hasNext()` + `next()`).
 * 
 * 3. **Custom Delimiters**:
 *    - Scanner allows setting custom delimiters using `useDelimiter()`.
 *    - Useful for parsing CSV or other structured text.
 * 
 * 4. **Formatted Output**:
 *    - Works seamlessly with `System.out.printf()` for formatted printing.
 * 
 * In this example:
 * - Reads user input from console (name, age, GPA).
 * - Reads lines and words from a file (`input.txt`).
 * - Demonstrates custom delimiter parsing with a comma-separated string.
 * - Shows formatted output using `printf`.
 */
public class ScannerExample {
    public static void main(String[] args) {
        // ------------------ Console Input ------------------
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your GPA (decimal value): ");
        double gpa = sc.nextDouble();

        System.out.println("Hello " + name + ", you are " + age + " years old and your GPA is " + gpa);

        // ------------------ File Input (Line by Line) ------------------
        File file = new File("input.txt");

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nReading file line by line:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
                Thread.sleep(1000); // 1 second delay
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ------------------ File Input (Word by Word) ------------------
        try (Scanner wordScanner = new Scanner(file)) {
            System.out.println("\nReading file word by word:");
            while (wordScanner.hasNext()) {
                String word = wordScanner.next();
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        }

        // ------------------ Using Custom Delimiter ------------------
        String data = "apple,banana,grape,orange";
        Scanner delimiterScanner = new Scanner(data);
        delimiterScanner.useDelimiter(",");

        System.out.println("\nReading with custom delimiter (comma):");
        while (delimiterScanner.hasNext()) {
            System.out.println(delimiterScanner.next());
        }
        delimiterScanner.close();

        // ------------------ Formatted Output ------------------
        System.out.printf("\nFormatted output for PI: %.6f%n", Math.PI);

        // ------------------ Closing Console Scanner ------------------
        sc.close();
        System.err.println("\nScanner object closed.");
    }
}
