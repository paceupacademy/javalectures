package com.paceup.ExceptionHandling;

/**
 * CustomExceptionExample:
 * -----------------------
 * 
 * Exception Basics:
 * - Exceptions are events that disrupt normal program flow.
 * - Java provides built-in exceptions (e.g., ArithmeticException, NullPointerException).
 * - You can also define your own exceptions by extending Exception or RuntimeException.
 * 
 * Custom Exception:
 * - Extending Exception creates a checked exception (must be declared with throws).
 * - Extending RuntimeException creates an unchecked exception (runtime only).
 * - Custom exceptions are useful for domain-specific error handling (e.g., InvalidAgeException).
 * 
 * Keywords:
 * - throw: Used to explicitly throw an exception.
 * - throws: Declares that a method may throw an exception, so the caller must handle it.
 * - try-catch: Used to handle exceptions gracefully.
 * - finally: Executes cleanup code regardless of exception occurrence.
 * 
 * In this example:
 * - InvalidAgeException is a custom checked exception.
 * - checkAge() method throws InvalidAgeException if age < 18.
 * - Nested try-catch demonstrates handling at different levels.
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Pass message to Exception class constructor
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            // Inner try-catch block
            try {
                checkAge(15); // Throws InvalidAgeException
            } catch (InvalidAgeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            // Valid age → no exception
            checkAge(24);

        } catch (Exception e) {
            // Outer catch block (handles any other exceptions)
            System.out.println("Outer Exception caught: " + e.getMessage());
        }
    }

    /**
     * Method to validate age.
     * @param age Age of the person
     * @throws InvalidAgeException if age < 18
     */
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Manually throwing custom exception
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        System.out.println("Age is valid.");
    }
}
