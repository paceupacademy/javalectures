package com.paceup.IOStreams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class OutputStreamExample {

	public static void main(String[] args) throws IOException{
		OutputStream output = new ByteArrayOutputStream();
		output.write(65);
		output.write(66);
		output.write(-127);
		output.write(67);
		
		ByteArrayOutputStream result = (ByteArrayOutputStream) output;
		
		System.out.println(result+"\n");
		System.out.println(Arrays.toString(result.toByteArray()));
		
		result.close();
		output.close();
	}

}
