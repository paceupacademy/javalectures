//4. Implement a program that reads integers from a file and calculates their sum.

package com.paceup.day13.Asses13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IntegerSum {

	public static void main(String[] args) {
		int sum = 0;
		/*	try (FileReader Fi = new FileReader("Int.txt"); BufferedReader Bi = new BufferedReader(Fi)) {
			String data;
			while ((data = Bi.readLine()) != null) {
				String[] nums = data.split("\\s");
				for (String n : nums) {
					if (!n.isEmpty()) {
						sum += Integer.parseInt(n);
						// System.out.println("Sum: " + sum);
					}
				}
			}
			System.out.println("Sum: " + sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	
	try(FileInputStream Fs = new FileInputStream("Int.txt");
			Scanner sc = new Scanner(Fs)){
		while(sc.hasNextInt()) {
			sum +=sc.nextInt();
		}
		System.out.println("Sum: " + sum);
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }

}
