package com.paceup.Polymorphism;

class Student {
    String name;
    int age;

    // Constructor 1: Default constructor
    Student() {
        this.name = "Unknown"; // better to initialize name
        this.age = 0;
    }

    // Constructor 2: Parameterized constructor (name only)
    Student(String name) {
        this.name = name;
        this.age = 5; // default age
    }

    // Constructor 3: Parameterized constructor (name + age)
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        display(); // auto-display when constructed
    }

    void display() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Student s1 = new Student();              // Calls default constructor
        Student s2 = new Student("Alice");       // Calls constructor with name
        Student s3 = new Student("Bob", 22);     // Calls constructor with name and age

        s1.display(); // Outputs: Name: Unknown, Age: 0
        s2.display(); // Outputs: Name: Alice, Age: 5
        // s3 already displayed inside constructor → Name: Bob, Age: 22
    }
}
