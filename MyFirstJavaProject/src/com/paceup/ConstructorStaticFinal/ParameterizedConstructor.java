package com.paceup.ConstructorStaticFinal;

// Example class demonstrating a parameterized constructor
class Example {
    int x = 5; // instance variable with default value

    // Parameterized Constructor:
    // --------------------------
    // Called when you pass an argument while creating the object.
    // It initializes the object using the provided value.
    Example(int value) {
        int sum = x + value; // local variable sum = instance variable + parameter
        System.out.println("Parameterized Constructor called! Value of x: " + x);
        System.out.println("Sum of variables = " + sum);
    }
}

public class ParameterizedConstructor {
    public static void main(String[] args) {
        // Creating object with parameterized constructor
        Example obj = new Example(10); // Calls Example(int value)
    }
}
