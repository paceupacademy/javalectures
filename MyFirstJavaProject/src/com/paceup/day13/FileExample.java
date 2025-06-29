package com.paceup.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileExample {

	public static void main(String[] args) {

		// Write a Java program to read a text file and print its contents line by line.

		try {
			BufferedReader reader = new BufferedReader(new FileReader("MyFirstJavaProject/input.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Write a program to copy the content of one file into another using
		// FileInputStream and FileOutputStream.

		try {
			BufferedReader reader = new BufferedReader(new FileReader("MyFirstJavaProject/input.txt"));
			String line;
			File file = new File("MyFirstJavaProject/output.txt");
			if (!file.exists()) {
				if (file.createNewFile()) {
					System.out.println("File created: " + file.getName());
				} else {
					System.out.println("File already exists.");
				}
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Lines written to file");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Create a file and write multiple lines into it using BufferedWriter.

		try {
			File file = new File("MyFirstJavaProject/output_1.txt");
			if (!file.exists()) {
				if (file.createNewFile()) {
					System.out.println("File created: " + file.getName());
				} else {
					System.out.println("File already exists.");
				}
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String[] lines = { "This is test lines.", "Hello World..!!", "Welcome to Java programming..!!" };
			for (int i = 0; i < lines.length; i++) {
				writer.write(lines[i]);
				writer.newLine();
			}
			System.out.println("Lines array written to file");

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Implement a program that reads integers from a file and calculates their sum.

		try {
			FileInputStream fis = new FileInputStream("MyFirstJavaProject/input_int.txt");
			Scanner scanner = new Scanner(fis);
			int sum = 0;
			while (scanner.hasNext()) {
				sum += scanner.nextInt();
			}
			scanner.close();
			System.out.println("Sum: " + sum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Write a program using FileReader and BufferedReader to count words in a file.

		try {
			BufferedReader reader = new BufferedReader(new FileReader("MyFirstJavaProject/input.txt"));
			String line;
			int count = 0;
			String[] arr;
			while ((line = reader.readLine()) != null) {
				arr = line.split(" ");
				count += arr.length;
			}
			reader.close();
			System.out.println("no. of words in file : " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
