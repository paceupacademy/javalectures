package com.paceup.day12;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class CustomExceptionExample {
	public static void main(String[] args) {
		try {
			try {
				checkAge(15);
			} catch (InvalidAgeException e) {
				System.out.println("Exception caught: " + e.getMessage());
			}
			checkAge(24);
		}
		catch(Exception e) {
			System.out.println("Outer Exception caught: " + e.getMessage());
		}
	}

	public static void checkAge(int age) throws InvalidAgeException { //might throw an exception and caller must handle it
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above."); //manually throwing an exception
		}
		System.out.println("Age is valid.");
	}
}

