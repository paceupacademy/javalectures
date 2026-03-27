package com.paceup.IOStreams;

import java.io.IOException;
import java.io.InputStream;

public class SystemInOutExample {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		byte[]buffer = new byte[10];
		
		System.out.println("Enter a character:");
		
		int data = System.in.read();
		
		System.out.println("You have entered "+(char)data);
		
		System.out.println("ASCII value is "+ data);
		
		//Comment  line 14-20 to execute below code
		
		System.out.println("Enter some text");	
		
		
		//Read data from System.in into byte[]
		int byteRead = is.read(buffer);
		
		if(byteRead!=-1) {
			System.out.println("Bytes read:" +byteRead);
			System.out.println("Data read: ");
			
			String input = new String(buffer, 0, byteRead);
			System.out.println(input);
		}
		else {
			System.out.println("End of stream reached");
		}
		
		System.out.println("Assigning values to a and b");
		
		int a = 10;
		int b = 0;
		
		if(b==0) {
			System.err.println("B value is zero so we cannot divide A by B");
			System.out.println("B is "+b);
			System.out.printf("B is %d and A is %d",b,a);
		}
	}

}
