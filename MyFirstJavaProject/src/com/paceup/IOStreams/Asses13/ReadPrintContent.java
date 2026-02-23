//1. Write a Java program to read a text file and print its contents line by line.

package com.paceup.IOStreams.Asses13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadPrintContent {

	public static void main(String[] args) {
		try (FileReader Fi = new FileReader("Example1.txt"); BufferedReader Bi = new BufferedReader(Fi)) {

			String data;
			while ((data = Bi.readLine()) != null) {
				System.out.println(data);
				Thread.sleep(1000);
			}
			Fi.close();
			Bi.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();

		}
		// System.out.println("Expected Location: " + new
		// File("Example1.txt").getAbsolutePath());

	}

}
