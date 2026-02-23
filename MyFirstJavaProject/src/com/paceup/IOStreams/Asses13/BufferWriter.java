//3. Create a file and write multiple lines into it using BufferedWriter.

package com.paceup.IOStreams.Asses13;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferWriter {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Example3.txt"));
			bw.write("Hello, Writer!\t");
			bw.append("Good Morning...");
			
			bw.close();
			System.out.println("Data written with BufferedWriter.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
