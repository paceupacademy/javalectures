package com.paceup.day10;
//Create ,Get the Length of a String, and Join two Strings
public class StringExample1 {
	public static void main(String[] args) {

		// create a string
		String greet = "Hello! World";
		System.out.println("String: " + greet);

		// get the length of greet
		int length = greet.length();
		System.out.println("Length: " + length);

		// create a string using new
	    String name = new String("Java String");

	    System.out.println("Name:"+name);  // print Java String
		
		// create first string
		String first = "Java ";
		System.out.println("\n\nFirst String: " + first);

		// create second
		String second = "Programming";
		System.out.println("Second String: " + second);

		// join two strings
		String joinedString = first.concat(second);
		System.out.println("Joined String: " + joinedString);

		/* Compare three Strings */

		// create 3 strings
		String first2 = "java programming";
		String second2 = "java programming";
		String third2 = "python programming";

		// compare first and second strings
		boolean result1 = first2.equals(second2);
		System.out.println("\n\nStrings first and second are equal: " + result1);

		// compare first and third strings
		boolean result2 = first2.equals(third2);
		System.out.println("Strings first and third are equal: " + result2);
		
		String s1 = "Good";
		String s2 = "Good";
		String s3 = new String("Good");
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
	}
}
