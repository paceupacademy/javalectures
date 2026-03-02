//5. Write a program using FileReader and BufferedReader to count words in a file.
package com.paceup.IOStreams.Asses13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountWord {

	public static void main(String[] args) throws IOException {
		int count = 0;
		try (BufferedReader bf = new BufferedReader(new FileReader("Example3.txt"))) {
			String data;
			while ((data = bf.readLine()) != null) {
				if (!data.trim().isEmpty()) {
					String[] words = data.trim().split("\\s+");
					count += words.length;

				}

			}
			System.out.println("Total number of words : " + count);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
