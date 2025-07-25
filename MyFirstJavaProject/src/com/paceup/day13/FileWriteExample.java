package com.paceup.day13;
//FileWrite is a character output stream that will writes characters to a file
//if file exists content will be overwritten
//if file doesn't exists, it is created
import java.io.*;
public class FileWriteExample {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("output3.txt");
        writer.write("Hello, file!");
        writer.close();
    }
}

