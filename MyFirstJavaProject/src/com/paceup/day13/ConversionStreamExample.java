package com.paceup.day13;

import java.io.*;
//ConversionStreams bridge the gap between byte and character streams
//InputStreamReader Converts bytes-> character
//OutputStreamWriter Convert character->bytes
public class ConversionStreamExample {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println("\n");
            }
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

