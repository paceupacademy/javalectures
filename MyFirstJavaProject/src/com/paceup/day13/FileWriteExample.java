package com.paceup.day13;

import java.io.*;
public class FileWriteExample {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("output3.txt");
        writer.write("Hello, file!");
        writer.close();
    }
}

