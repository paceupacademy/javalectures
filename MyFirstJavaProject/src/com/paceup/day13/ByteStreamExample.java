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
	}
}
