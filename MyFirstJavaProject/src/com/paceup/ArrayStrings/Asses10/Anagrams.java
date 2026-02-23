//8. Write a method that takes two strings and checks if they are anagrams.

package com.paceup.ArrayStrings.Asses10;

import java.util.Arrays;

public class Anagrams {
	public static boolean isAnagram(String s1, String s2) {

		s1 = s1.replaceAll("\\s", "").toLowerCase();// Removed spaces between strings
		s2 = s2.replaceAll("\\s", "").toLowerCase();// Removed spaces between strings

		if (s1.length() != s2.length()) { // check length of string
			return false;
		}

		char[] a1 = s1.toCharArray(); // Convert to char array
		char[] a2 = s2.toCharArray();

		Arrays.sort(a1);// Sort both arrays
		Arrays.sort(a2);

		return Arrays.equals(a1, a2); // Compare both string array
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("act", "cat")); // result is true
		System.out.println(isAnagram("class", "clas")); // result is false
	}
}