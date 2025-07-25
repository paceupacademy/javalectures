package com.paceup.day13;

import java.io.*;
//Character Streams are for text 
//FR will read characters from file
//FW will write characters to a file
public class CharacterStreamExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output3.txt")) {
            int data;
            while ((data = fr.read()) != -1) { //character-by-character reading return the unicode int value of that character
                fw.write(data);
                
                System.out.println("Data "+data);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

