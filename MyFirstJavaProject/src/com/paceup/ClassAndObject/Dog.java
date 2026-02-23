package com.paceup.ClassAndObject;

// Java Program to Demonstrate the use of a class with instance variables

// Class Declaration
public class Dog { 
    // public → accessible from other packages as well

    // Instance Variables (attributes of Dog objects)
    String name;
    String breed;
    int age;
    String color;

    // Default Constructor:
    // --------------------
    // Called when no arguments are passed while creating a Dog object.
    // Initializes instance variables with default values.
    public Dog() {
        System.out.println("Default Constructor called");
        this.name = "ABC";      // 'this' refers to current object
        this.breed = "Lab";
        this.age = 5;
        this.color = "Golden";
    }

    // Parameterized Constructor:
    // --------------------------
    // Allows setting custom values while creating a Dog object.
    public Dog(String name1, String breed, int age, String color) {
        this.name = name1;   // 'this.name' refers to current object's variable
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // Overloaded Constructor (only name):
    // -----------------------------------
    // Demonstrates constructor overloading (multiple constructors with different parameters).
    public Dog(String name) {
        this.name = name;
    }

    // Getter Methods:
    // ----------------
    // Used to access private/instance variables from outside the class.
    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public int getAge() {
        return this.age;
    }

    public String getColor() {
        return this.color;
    }
}
