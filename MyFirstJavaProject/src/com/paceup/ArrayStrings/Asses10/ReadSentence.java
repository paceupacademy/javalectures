//10. Write a program that reads a sentence from the user and prints the longest word.
package com.paceup.ArrayStrings.Asses10;

import java.util.Scanner;

public class ReadSentence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a Sentence:");
		String senten = scanner.nextLine();

		String[] word = senten.split("\\s+");
		String longestWord = "";

		for (String wString : word) {
			if (wString.length() > longestWord.length()) {
				longestWord = wString;
			}
		}

		System.out.println("Longest word: " + longestWord);
	}

}
