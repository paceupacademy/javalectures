package com.paceup.Polymorphism;
class Student {
    String name;
    int age;

    // Constructor 1: Default constructor
    Student() {
        this.age = 0;
    }

    // Constructor 2: Parameterized constructor
    Student(String name) {
        this.name = name;
        this.age = 5;
    }

    // Constructor 3: Parameterized constructor with two arguments
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        display();
        
    }
    void display() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
    
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Student s1 = new Student();  // Calls default constructor
        Student s2 = new Student("Alice");  // Calls constructor with name
        Student s3 = new Student("Bob", 22);  // Calls constructor with name and age

        s1.display(); // Outputs: Name: Unknown, Age: 0
        s2.display(); // Outputs: Name: Alice, Age: 0
        s3.display(); // Outputs: Name: Bob, Age: 22
    }
}
