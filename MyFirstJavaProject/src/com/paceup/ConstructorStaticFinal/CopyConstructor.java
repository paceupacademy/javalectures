package com.paceup.ConstructorStaticFinal;

// Class demonstrating parameterized and copy constructors
class CopyConstructorExample {
    int x;
    int y = 25; // default value

    // Parameterized Constructor:
    // --------------------------
    // Called when you pass an argument while creating object.
    // It initializes 'x' and 'y' with given values.
    CopyConstructorExample(int value) {
        x = 30;        // fixed assignment
        y = value;     // assign parameter to instance variable
        System.out.println("Parameterized Constructor Called!! X value is " 
                           + x + " and Y value is " + y + "\n");
    }

    // Copy Constructor:
    // -----------------
    // Called when you pass another object of the same class.
    // It copies values from the existing object into the new one.
    CopyConstructorExample(CopyConstructorExample obj) {
        x = obj.x; // copy value of x from passed object
        // Note: y is not copied here, so it retains its default value (25)
        System.out.println("Copy Constructor called!!! X value is " 
                           + x + " and Y value is: " + y);
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        // Create object using parameterized constructor
        CopyConstructorExample obj1 = new CopyConstructorExample(20);

        // Create object using copy constructor
        CopyConstructorExample obj2 = new CopyConstructorExample(obj1);

        // Display values of obj2
        System.out.println("\nValue in obj2: " + obj2.x + " and Y value is " + obj2.y);
    }
}
