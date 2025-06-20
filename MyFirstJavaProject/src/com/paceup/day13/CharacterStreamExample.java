package com.paceup.day13;

import java.io.*;
//Character Streams are for text data
public class CharacterStreamExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output1.txt")) {
            int data;
            while ((data = fr.read()) != -1) { //character-by-character reading
                fw.write(data);
                
                System.out.println("Data"+data);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

