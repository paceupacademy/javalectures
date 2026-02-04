//2. Write a program to copy the content of one file into another using FileInputStream and FileOutputStream.

package com.paceup.day13.Asses13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyContent {

	public static void main(String[] args) {
		System.out.println((System.getProperty("user.dir")));
		try (FileInputStream Fi = new FileInputStream("C://Users/suraj/git/javalectures/MyFirstJavaProject/src/Source.txt");
				FileOutputStream Fo = new FileOutputStream("src/Destination.txt")) {

			int data;
			while ((data = Fi.read()) != -1) {
				Fo.write(data);
			}
			Fi.close();
			Fo.close();
			System.out.println("File copied successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File error occurred: " + e.getMessage());
		}
	}

}
