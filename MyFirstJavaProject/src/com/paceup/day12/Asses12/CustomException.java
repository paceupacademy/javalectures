//2. Create and use a custom exception class InvalidAgeException which gets thrown if age < 18.
package com.paceup.day12.Asses12;

import java.io.IOException;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class CustomException {

	static void agecheck(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("For voting age must be 18 or above the 18");
		}
		System.out.println("Your Eligible for the vote!");

	}

	public static void main(String[] args) {
		try {
			agecheck(17);
		} catch (InvalidAgeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

}
