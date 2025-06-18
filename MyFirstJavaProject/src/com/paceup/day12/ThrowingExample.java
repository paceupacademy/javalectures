package com.paceup.day12;

public class ThrowingExample {
    public static void main(String[] args) {
        try {
            validateNumber(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        System.out.println("Valid number: " + number);
    }
}

