package com.paceup.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Demonstrates various uses of the Scanner class:
 * 1. Reading input from console (String, int, double).
 * 2. Reading lines from a file.
 * 3. Reading words from a file.
 * 4. Using custom delimiters.
 * 5. Formatted output.
 */
public class ScannerExample {
    public static void main(String[] args) {
        // ------------------ Console Input ------------------
        // Create a Scanner object to read input from the console (System.in).
        Scanner sc = new Scanner(System.in);

        // Prompt user for name and read a full line of text.
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Prompt user for age and read an integer value.
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Prompt user for GPA and read a double value.
        System.out.print("Enter your GPA (decimal value): ");
        double gpa = sc.nextDouble();

        // Display the collected input back to the user.
        System.out.println("Hello " + name + ", you are " + age + " years old and your GPA is " + gpa);

        // ------------------ File Input (Line by Line) ------------------
        // Create a File object pointing to "input.txt".
        File file = new File("input.txt");

        // Use try-with-resources to ensure Scanner is closed automatically after use.
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nReading file line by line:");
            // Read each line until end of file.
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
                
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            // Handle case where file does not exist.
            System.err.println("File not found: " + file.getAbsolutePath());
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // ------------------ File Input (Word by Word) ------------------
        // Another Scanner instance to read words from the same file.
        try (Scanner wordScanner = new Scanner(file)) {
            System.out.println("\nReading file word by word:");
            // Read each word until end of file.
            while (wordScanner.hasNext()) {
                String word = wordScanner.next();
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        }

        // ------------------ Using Custom Delimiter ------------------
        // Example string with comma-separated values.
        String data = "apple,banana,grape,orange";

        // Create Scanner to read from the string.
        Scanner delimiterScanner = new Scanner(data);

        // Set delimiter to comma (instead of default whitespace).
        delimiterScanner.useDelimiter(",");

        System.out.println("\nReading with custom delimiter (comma):");
        // Read tokens separated by commas.
        while (delimiterScanner.hasNext()) {
            System.out.println(delimiterScanner.next());
        }
        // Close the delimiter scanner.
        delimiterScanner.close();

        // ------------------ Formatted Output ------------------
        // Print PI with 6 decimal places using printf formatting.
        System.out.printf("\nFormatted output for PI: %.6f%n", Math.PI);

        // ------------------ Closing Console Scanner ------------------
        sc.close(); // Always close Scanner to release resources.
        System.err.println("\nScanner object closed.");
    }
}
