package com.paceup.day13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class PrintStreamExample {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		FileOutputStream fos =  new FileOutputStream("data.txt");
		PrintStream out = new PrintStream(fos);
		
		String s = "First Word";
		
		char c[] = {'G', 'H', 'I', 'J'};
		
		out.print(true);
		out.println();
		out.print(1);
		
		out.println();
		out.print(4.533f);
		
		out.println("Republic Day\n");
		out.println();

		out.println(fos);
		out.println();
		
		out.print(out.checkError());
		out.println();
		/*
		 * format(l, String s, Object args)
		 * format(String, args)
		 * l : The locale to apply formatting
		 * l -> null 
		 */
		out.format(Locale.UK, "Welcome to India %s", s);
		out.println();
		out.format("Welcome to India %s", s);
		out.print("Hello Aishwarya"); //stays in buffer sometime
		out.flush();
		
		Thread.sleep(10000);
		out.println("Printed after flush");
		out.flush();
		out.close();
	}

}
