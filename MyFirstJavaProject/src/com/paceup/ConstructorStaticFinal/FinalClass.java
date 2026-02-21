package com.paceup.ConstructorStaticFinal;

// Final class → cannot be extended (no subclasses allowed)
final class FinalClass {

    // Normal method inside final class
    void show() {
        System.out.println("This is a final class.");
    }

    // Method demonstrating final parameters and local variables
    void display(final int num1) {
        // 'final' parameter → cannot be reassigned inside method
        final int a = num1; // final local variable assigned once
        final int num = 56; // final local variable assigned once

        System.out.println("\nNum: " + num);
        System.out.println("Num1: " + a);

        int localVar = 60; // normal local variable (can be changed)
    }

    // Method demonstrating final local variable
    void method() {
        final int localVar = 50; // final → cannot be reassigned
        // localVar = 60; // Compilation error if uncommented
        display(localVar); // pass final variable as parameter
    }

    // Final method → cannot be overridden in subclasses
    final int displayn() {
        return 1;
    }

    public static void main(String[] args) {
        FinalClass fc = new FinalClass();

        // Call normal method
        fc.show();

        // Call display with final parameter
        fc.display(5);

        // Call method demonstrating final local variable
        fc.method();

        // Call display again with different value
        fc.display(25);

        // Call final method
        System.out.println(fc.displayn());
    }
}

/* 
// ERROR: Cannot extend a final class
class Subclass extends FinalClass {
    // Compilation error → FinalClass cannot be subclassed
}
*/
