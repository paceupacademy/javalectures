package com.paceup.day13;

import java.io.*;
//Buffered Streams for better performance
public class BufferedStreamExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); //to insert a line separator based on the system (Linux,Windows, MacOS)
            }
            bw.append(" June");
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

