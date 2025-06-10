package com.paceup.day4;

class Example {
    int x;

    Example(int value) {
        x = value;
        System.out.println("Parameterized Constructor called! Value: " + x);
    }
}

public class ParameterizedConstructor {
	public static void main(String[] args) {
        Example obj = new Example(10); // Calls the parameterized constructor
    }
}
