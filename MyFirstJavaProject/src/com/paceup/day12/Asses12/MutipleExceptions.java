//3. Handle multiple exceptions in different blocks to isolate issues more effectively.
package com.paceup.day12.Asses12;

public class MutipleExceptions {

	public static void main(String[] args) {
		// Block 1: String operation
		try {
			String string = null;
			System.out.println(string.length());
		} catch (NullPointerException e1) {
			System.out.println("Block 1: \nNullPointerException handled: " + e1.getMessage());
		}

		// Block 2: Integer parse operation
		try {
			int num = Integer.parseInt("abc");
			System.out.println(num);
		} catch (NumberFormatException e2) {
			System.out.println("Block 2: \nNumber Format Exception handled: " + e2.getMessage());
		}

		// Block 3: String index operation
		try {
			String aString = "Hello world!";
			System.out.println(aString.charAt(12));
		} catch (Exception e3) {
			System.out.println("String Index out of bound exeception: " + e3.getMessage());
		}

	}

}
