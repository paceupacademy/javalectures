package com.paceup.day12;

//Create and use a custom exception class InvalidAgeException which gets thrown if age < 18.
class InvalidAgeException extends Exception {

	public InvalidAgeException(String message) {
		super(message);
	}
}

public class InvalidAgeExceptionExample {

	public static void main(String[] args) {
		int age = 15;
		try {
			checkAge(age);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}
	}

	public static void checkAge(int age) throws InvalidAgeException {
		if (age >= 18) {
			System.out.println("Age is valid");
		} else {
			throw new InvalidAgeException("Age is less than 18");
		}

	}

}
