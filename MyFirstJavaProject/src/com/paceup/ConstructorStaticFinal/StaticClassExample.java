package com.paceup.ConstructorStaticFinal;

public class StaticClassExample {
    // Static variable: shared across all objects
    public static int count = 0;

    // Instance variable: unique to each object
    public int id;

    // Private static variable: accessible only within this class
    private static int outerstaticVariable = 5;

    // Constructor:
    // Runs every time a new object is created.
    // Increments count (shared) and assigns id (unique).
    public StaticClassExample() {
        count++;                 // increases shared count
        id = count;              // assigns unique id to each object
        outerstaticVariable++;   // increments shared static variable
    }

    // Static method:
    // Belongs to the class, can be called without creating an object.
    public static void printCount() {
        System.out.println("Number of instances: " + count);
    }

    // Instance method:
    // Belongs to an object, prints its unique id.
    public void printId() {
        System.out.println("Instance ID: " + id);
    }
    
    // Static Nested Class:
    // Can access outer class’s static members directly.
    static class Example {
        void display() {
            System.out.println("Outer static variable: " + outerstaticVariable);
        }
    }

    public static void main(String[] args) {
        // Creating three objects of StaticClassExample
        StaticClassExample g1 = new StaticClassExample();
        StaticClassExample g2 = new StaticClassExample();
        StaticClassExample g3 = new StaticClassExample();
        
        // Creating object of static nested class
        StaticClassExample.Example stobj = new StaticClassExample.Example();

        // Printing IDs of each object
        g1.printId(); // Instance ID: 1
        g2.printId(); // Instance ID: 2
        g3.printId(); // Instance ID: 3

        // Printing total count of objects created
        printCount(); // Number of instances: 3
        
        // Displaying outer static variable from nested class
        stobj.display(); // Outer static variable: 8 (5 initial + 3 increments)
    }
}
