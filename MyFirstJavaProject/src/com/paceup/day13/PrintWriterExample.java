package com.paceup.day13;

import java.io.PrintWriter;
import java.util.Locale;

public class PrintWriterExample {

	public static void main(String[] args) {
		PrintWriter pw =  new PrintWriter(System.out);
		String s = "Hello World!! This is Aishwarya";
		
		char c[] = {'A', 'B', 'C','D'};
		
		pw.print(true); //boolean
		
		pw.print(1); //integer
		
		pw.print(4.533f); //float
		
		pw.print(8.66); //double
		
		pw.print("Hi There!!");
		
		pw.println();
		
		pw.append(s.subSequence(0, s.length()));
		
		pw.println();
		
		pw.format(Locale.UK, "This is my * %s * sentence", s);
		
		pw.flush();
		
		pw.close();
		
	}

}
