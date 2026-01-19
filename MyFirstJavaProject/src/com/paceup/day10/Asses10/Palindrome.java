//7. Implement a program to check if a given string is a palindrome.

package com.paceup.day10.Asses10;

public class Palindrome {

	public static void main(String[] args) {
		String arr = "mom";

		String reversed = "";

		for (int i = arr.length() - 1; i >= 0; i--) {
			reversed = reversed + arr.charAt(i);
		}
		if (arr.equals(reversed)) {
			System.out.println(arr + " is palindrome.");
		} else {
			System.out.println(arr + " is not palindrome.");
		}
	}

}
