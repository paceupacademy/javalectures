package com.paceup.day12;

public class ExceptionExample {

	public static void main(String[] args) {

		// Write a Java program to handle ArithmeticException and
		// ArrayIndexOutOfBoundsException using two catch blocks

		try {
			int x = 10, y = 0;
			int result = x / y;
			System.out.println(result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		try {
			int[] array = { 1, 2, 3, 4, 5, 6 };
			System.out.println(array[7]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		// Handle multiple exceptions in different blocks to isolate issues more
		// effectively.
		try {
			int x = 10, y = 0;
			int result = x / y;
			System.out.println(result);
			String str = null;
			System.out.println(str.charAt(50));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
