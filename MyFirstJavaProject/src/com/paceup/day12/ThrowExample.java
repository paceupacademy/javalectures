package com.paceup.day12;

/*
 * throws: tells that method might throw an exception
 * throw: used to actually throw an exception
 */

public class ThrowExample {
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        else {
        	System.out.println("Correct Age Entered");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
            checkAge(20);
        }
    }
}
