package com.paceup.day13;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Read input from console
 * Read lines from file
 */
public class ScannerExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		
		System.out.println("Hello "+name+" ,you are "+age+" years old!!" );
		
		sc.close();
		
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
		
	}
}
