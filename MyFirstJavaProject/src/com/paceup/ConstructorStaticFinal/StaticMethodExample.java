package com.paceup.ConstructorStaticFinal;

public class StaticMethodExample {
    // Static variable:
    // ----------------
    // Belongs to the class, shared across all objects.
    static int a = 10;

    // Instance variable:
    // ------------------
    // Each object has its own copy.
    int b = 20;

    // Static method:
    // --------------
    // Belongs to the class, can be called without creating an object.
    // Can only directly access static members (like 'a').
    static void m1() {
        a = 20; // ✅ allowed, because 'a' is static
        System.out.println("from m1");

        // ❌ Compilation error examples:
        // b = 10; // cannot access instance variable directly
        // m2();   // cannot call instance method directly
        // super.a; // cannot use 'super' in static context
    }

    // Instance method:
    // ----------------
    // Belongs to an object, can access both static and instance members.
    void m2() {
        System.out.println("from m2");
    }

    // Main method:
    // ------------
    // Entry point of program.
    public static void main(String[] args) {
        System.out.println("Inside Main Method");
    }
}
