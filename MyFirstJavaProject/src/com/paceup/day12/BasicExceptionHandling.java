package com.paceup.day12;

public class BasicExceptionHandling {
	public static void main(String[] args) {
		try { //block of code monitored for exceptions
			int result = 10 / 0; // This will throw ArithmeticException
		} catch (ArithmeticException e) { //exception handling is done
			System.out.println("Cannot divide by zero: " + e.getMessage());
		} finally { //executes regardless of any exception
			System.out.println("Execution completed.");
		}
	}
}
