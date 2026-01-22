package com.paceup.day13;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * Read input from console
 * Read lines from file
 */
public class ScannerExample {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); //Standard input stream to read characters from keyboard or any other input device
		System.out.println("Enter your name: "); //Standard output stream on output stream like computer screen
		String name = sc.nextLine();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		
		System.out.println("Hello "+name+" ,you are "+age+" years old!!" );
		
		sc.close();
		
		System.err.print("\nScanner object closed\n\n"); //Standard error stream to display error messages separately from normal output on screen
		
		File file = new File("input.txt");
		
		try {
			Scanner sF = new Scanner(file);
			
			while(sF.hasNextLine()) {
				String line = sF.nextLine();
				System.out.println(line);
			}
			sF.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Formatted output for PI: %.6f%n",Math.PI);
		/*
		System.out.println("Enter a character:");
		//Stores ASCII value of character in data
		int data =  System.in.read();
		System.out.println("You entered: "+(char)data);
		System.out.println("ASCII value: "+data);
		*/
	}
}
