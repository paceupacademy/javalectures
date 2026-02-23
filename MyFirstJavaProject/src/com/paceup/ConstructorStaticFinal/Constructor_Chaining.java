package com.paceup.ConstructorStaticFinal;

// Parent class
class A {
    // Parameterized constructor of class A
    A(String name) {
        // Called when child class passes a string using super(name)
        System.out.println("Received name: " + name + " from B's parameterized constructor"); // Step 3
    }
}

// Child class extending A
class B extends A {
    // Default constructor of class B
    B() {
        // Calls B(String) constructor first using this("XYZ")
        this("XYZ"); // Step 1
        System.out.println("Default constructor finished."); // Step 5
    }

    // Parameterized constructor of class B
    B(String name) {
        // Calls parent class constructor A(String) using super(name)
        super(name); // Step 2
        System.out.println("Received name from Default Constructor..."); // Step 4
    }
}

public class Constructor_Chaining {
    public static void main(String[] args) {
        // Creating object of B
        // This triggers constructor chaining sequence
        B obj = new B();
    }
}
