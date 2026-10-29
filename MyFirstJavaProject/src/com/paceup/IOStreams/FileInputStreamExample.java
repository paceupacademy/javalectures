package com.paceup.IOStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(FileInputStream fin =  new FileInputStream("file.txt")){
			System.out.println("\n\nFile Input Stream started");
            
            int count;
            //System.out.println(fin.read());
            
            while((count = fin.read())!=-1) {
            	System.out.print((char)count);
            	
            }
		}

	}

}
