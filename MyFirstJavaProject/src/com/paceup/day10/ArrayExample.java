package com.paceup.day10;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) {

		// Write a program to initialize an integer array and print all elements.

		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println("for loop");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("forEach loop");
		for (int i : array) {
			System.out.println(i);
		}

		// Create a program that takes 5 numbers from the user and stores them in an
		// array. Then print their average.

		Scanner sc = new Scanner(System.in);
		int num = 0;
		int[] arr = new int[5];
		System.out.println("User will enter 5 positive numbers");
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter positive number:");
			num = sc.nextInt();
			arr[i] = num;
		}

		System.out.println("Array:");
		for (int i : arr) {
			System.out.println(i);
		}

		// Write a method to reverse the elements of an array.

		int[] arr_1 = { 1, 2, 3, 4, 5 };

		int[] arr_reverse = new int[arr_1.length];
		int j = 0;
		for (int i = arr_1.length - 1; i >= 0; i--) {
			arr_reverse[j] = arr_1[i];
			j++;
		}

		// Sort a string array alphabetically using Arrays.sort().
		String[] str_arr = { "apple", "dog", "map", "cat", "ball" };
		Arrays.sort(str_arr);
		for (String str : str_arr) {
			System.out.println(str);
		}

		// Write a program to find the maximum and minimum value in an integer array.
		int[] arr_2 = { 145, 250, 99, 45, 4, 3, 5 };
		int min = 0, max = 0;
		min = arr_2[0];
		for (int i = 0; i < arr_2.length; i++) {
			if (min > arr_2[i]) {

				min = arr_2[i];
			}
			if (max < arr_2[i]) {
				max = arr_2[i];
			}
		}
		System.out.println("min number: " + min);
		System.out.println("max number: " + max);

		// Write a Java program to count the number of vowels in a string.

		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		String word = "incredhogdycrdfkjhbjgdrxeaewsaghvklnlknkhjfytfsxrastrfuyooooogbviuhbvdtestrsreq4wqtfiuytuytrewrewaredxgxgfdgfdible";
		int count = 0;

		for (int i = 0; i < vowels.length; i++) {
			if (word.indexOf(vowels[i]) != -1) {
				count = 0;
				for (int k = word.indexOf(vowels[i]); k < word.length(); k++) {
					if (word.charAt(k) == vowels[i]) {
						count++;
					}
				}
				System.out.println("Count of vowel " + vowels[i] + " : " + count);
			}
		}

		
		// Implement a program to check if a given string is a palindrome.
		// madam,racecar

		
		String palString = "madam";
		String palString_1 = palString.toLowerCase();
		boolean isPalindrome = false;
		int l = palString_1.length() - 1;
		for (int i = 0; i < palString_1.length(); i++, l--) {
			if (palString_1.charAt(i) == palString_1.charAt(l)) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.println(palString + " is palindrome.");
		} else {
			System.out.println(palString + " is not palindrome.");
		}
		
		
		// Write a method that takes two strings and checks if they are anagrams.
		// "silent","listen"
		String str1 = "silent", str2 = "listen", str3, str4;
		str3 = str1.replace(" ", "");
		str4 = str2.replace(" ", "");
		boolean isAnagram = false;

		if (str3.length() == str4.length()) {
			for (int i = 0; i < str3.length(); i++) {
				if (str4.indexOf(str3.charAt(i)) != -1) {
					isAnagram = true;
				} else {
					isAnagram = false;
					break;
				}
			}
		} else {
			isAnagram = false;
		}
		if (isAnagram) {
			System.out.println(str1 + " " + str2 + " are anagram.");
		} else {
			System.out.println(str1 + " " + str2 + " are not anagram.");
		}

		// Create a 2D array (matrix) of integers and print the diagonal elements.
		int[][] array2D = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 2D array is square
		// print 0=>0 1=>1
		System.out.println("the diagonal elements");
		for (int i = 0; i < array2D.length; i++) {
			System.out.print(array2D[i][i] + " ");
		}

	}

}
