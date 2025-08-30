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
			checkAge(10);
		}
		catch(Exception e) {
			System.out.println("Exception occurred "+e.getMessage());
		}
	}

	public static void checkAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above.");
		}
		System.out.println("Age is valid.");
	}
}

