package com.paceup.ConstructorStaticFinal;

class FinalStaticVariable {

    // Final instance variable (direct initialization)
    // Cannot be changed once assigned
    final int THRESHOLD = 5;

    // Blank final instance variable (must be initialized later)
    final int CAPACITY;

    // Another blank final instance variable
    final int MINIMUM;

    // Final static variable (direct initialization)
    // Shared across all objects, cannot be changed
    static final double PI = 3.141592653589793;

    // Blank final static variable (must be initialized in static block)
    static final double EULERCONSTANT;

    // Instance initializer block:
    // ---------------------------
    // Used to initialize blank final instance variables.
    {
        CAPACITY = 25;
    }

    // Static initializer block:
    // -------------------------
    // Used to initialize blank final static variables.
    static {
        EULERCONSTANT = 2.3;
    }

    // Constructor:
    // ------------
    // Used to initialize blank final variables.
    // If there are multiple constructors, each must initialize MINIMUM.
    public FinalStaticVariable() {
        MINIMUM = -1;
    }

    public static void main(String[] args) {
        FinalStaticVariable fsv = new FinalStaticVariable();

        // fsv.MINIMUM = 1; // ❌ Error: cannot assign a value to final variable

        System.out.println(fsv.MINIMUM); // Prints -1

        // Calling another class’s static method (example)
        StaticVariableExample.m1();
    }
}
