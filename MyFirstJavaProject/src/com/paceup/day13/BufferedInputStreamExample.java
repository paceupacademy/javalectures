package com.paceup.day13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class BufferedInputStreamExample {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin =  new FileInputStream("file.txt");
		
		BufferedInputStream bis = new BufferedInputStream(fin);
		//give us number of bytes that can be read from particular input stream
		System.out.println("Number of bytes: "+bis.available());
		
		//if inputstream supports mark method 
		boolean b = bis.markSupported();
		if(b) {
			bis.mark(bis.available()); //Marks current position in inputstream
		}
		bis.skip(8); //skips n bytes
		System.out.println("File Data:");
		
		// read character from fis
		int ch;
		
		while((ch=bis.read())!=-1) 
		{
			System.out.print((char)ch);
			//System.out.print("\tASCII value: "+ch);
		}
		bis.reset(); //Reposition this stream to position at time when mark method
		System.out.println("\n\nAfter Reset\n");
		while((ch=bis.read())!=-1) 
		{
			System.out.print((char)ch);
			//System.out.print("\tASCII value: "+ch);
		}
		
		fin.close();
	}

}
