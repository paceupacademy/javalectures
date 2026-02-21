package com.paceup.ClassAndObject;  

// Class Declaration
class Student {
      
    // Instance variables (data members)
    int id = 1;             // Each Student object has its own id
    String n = "Neha";      // Each Student object has its own name

    // Static variable (shared across all objects of Student class)
    // Here we are creating a Dog object once, and it is shared by all Student objects
    static Dog dog = new Dog("tom", "mudol", 5, "hakf");

    // Instance method (works on individual Student objects)
    public void display() {
        System.out.println("Name is: " + n + " Id: " + id);
        displayDog(); // Calls static method
    }

    // Static method (belongs to class, not individual objects)
    static void displayDog() {
        // By default, toString() prints class name + hashcode unless overridden in Dog class
        System.out.println(dog.toString());
    }
    
    // Main method: entry point of program
    public static void main(String args[]) {
      
        // Local variable inside main
        String name = "Radha";

        // Creating first Student object
        Student s1 = new Student();
        s1.n = "Ria"; // Changing name for s1
        s1.display(); // Prints details of s1 and Dog object

        // Creating second Student object
        Student s2 = new Student();
        s2.n = name;  // Assigning "Radha" to s2's name
        s2.id++;      // Incrementing id (from 1 → 2)
        s2.display(); // Prints details of s2 and Dog object
    }
}
