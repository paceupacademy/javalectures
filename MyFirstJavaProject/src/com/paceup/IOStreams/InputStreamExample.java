package com.paceup.IOStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class InputStreamExample {

	public static void main(String[] args) throws IOException{
		
		byte[] data = {65,66,-1,67};
		InputStream input =  new ByteArrayInputStream(data);
		
		int value;
		
		while((value=input.read())!=-1) {
			byte b = (byte) value;
			System.out.print(b+" ");
		}
		System.out.println();
		input.close();
	}

}
