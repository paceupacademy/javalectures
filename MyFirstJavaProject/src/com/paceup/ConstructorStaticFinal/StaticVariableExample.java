package com.paceup.ConstructorStaticFinal;

public class StaticVariableExample {
    // Static variable:
    // ----------------
    // Belongs to the class, not to individual objects.
    // Initialized by calling static method m1().
    static int a = m1(); // a = 20

    // Instance variable:
    // ------------------
    // Each object of StaticVariableExample will have its own copy.
    int num = 10;

    // Constructor:
    // ------------
    // Called when a new object is created.
    // Demonstrates how instance and static variables behave differently.
    public StaticVariableExample() {
        System.out.println("\nnum: " + num + " a: " + a);
        a = a + 15;   // static variable updated → shared across all objects
        num++;        // instance variable updated → unique per object
    }

    // Static block:
    // -------------
    // Runs once when the class is loaded into memory, before main() or constructor.
    static {
        System.out.println("Inside static block");
    }

    // Instance method:
    // ----------------
    // Can access both instance and static variables.
    void display() {
        System.out.println("num: " + this.num);
        System.out.println("a: " + this.a);
    }

    // Static method:
    // --------------
    // Belongs to the class, can only access static variables directly.
    static int m1() {
        System.out.println("from m1");
        return 20;
    }

    // Main method:
    // ------------
    // Entry point of program.
    public static void main(String[] args) {
        System.out.println("from main method\n");
        System.out.println("Static Value of a : " + a); // 20

        // First object creation
        StaticVariableExample s = new StaticVariableExample();
        System.out.println("Value of a: " + s.a + " Num: " + s.num + "\n");

        // Second object creation
        StaticVariableExample s1 = new StaticVariableExample();
        System.out.println("Value of a: " + s1.a + " Num: " + s1.num);

        // Local variable inside main
        int a = 7;

        // Calling static method
        int m = m1();
        System.out.println("\nValue for static m1(): " + m);
    }
}
