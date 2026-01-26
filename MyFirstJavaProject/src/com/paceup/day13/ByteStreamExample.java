package com.paceup.day13;

import java.io.*;
//Example to demonstrate FileInputStream and FileOutputStream
//ByteStreams are for binary data image, audio, video
//FIS : Read raw bytes from a file
//FOS : Write raw bytes to a file
public class ByteStreamExample {
    public static void main(String[] args) throws IOException { 
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output2.txt")) { 
            int data;
            while ((data = fis.read()) != -1) { // read() reads 1 byte at a time return it as an integer
                fos.write(data);
                System.out.print(" "+(char)data);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        PushbackInputStream pis =  new PushbackInputStream(new FileInputStream("input.txt"));
        int ch =  pis.read();
        System.out.println("\nData "+(char)ch);
        if(ch == '#') {
        	pis.unread(ch);
        	System.out.println("found #");
        }
        
        System.out.println("Remaining Data");
        int data;
        while((data= pis.read())!= -1) {
        	System.out.print((char) data);
        }
        
        int c = pis.read();
        System.out.println((char) c);
        
        
        pis.close();
    }
}
