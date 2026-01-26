package com.paceup.day13;

import java.io.*;

/**
 * Demonstrates usage of BufferedReader and BufferedWriter in Java.
 * Reads data from "input.txt" and writes it into "output1.txt"
 * with improved performance due to buffering.
 */
public class BufferedStreamExample {
    public static void main(String[] args) {
        // try-with-resources ensures both streams are closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output1.txt"))) {

            String line;

            // Read each line from input.txt until end of file
            while ((line = br.readLine()) != null) {
                // Write the line into output1.txt
                bw.write(line);

                // Insert a system-dependent line separator (works on Windows, Linux, MacOS)
                bw.newLine();
            }

            // Append extra text at the end of the file
            bw.append(" June");

            // No need to explicitly call br.close() or bw.close()
            // because try-with-resources will handle it automatically

            System.out.println("Data copied successfully from input.txt to output1.txt");

        } catch (IOException e) {
            // Handle exceptions such as file not found or read/write errors
            e.printStackTrace();
        }
    }
}
