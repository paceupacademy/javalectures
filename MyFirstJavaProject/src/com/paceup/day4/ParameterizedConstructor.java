package com.paceup.day4;

class Example {
    int x=5;

    Example(int value) {
        int sum = x + value;
        System.out.println("Parameterized Constructor called! Value: " + x);
        System.out.println("Sum of variables="+sum);
    }
}

public class ParameterizedConstructor {
	public static void main(String[] args) {
        Example obj = new Example(10); // Calls the parameterized constructor
    }
}
