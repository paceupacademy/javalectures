//6. Write a Java program to count the number of vowels in a string.
package com.paceup.ArrayStrings.Asses10;

public class VowelsCount {

	public static void main(String[] args) {
		String string = "Welcome, Hello worlds!";
		int count = 0;

		for (char a : string.toCharArray()) {
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
				count++;
				System.out.println("Vowel found: " + a);
			}
		}

		System.out.println("Number of vowels in string: " + count);
	}

}
