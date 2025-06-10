package com.paceup.day4;

final class FinalClass {
    void show() {
        System.out.println("This is a final class.");
    }
    void display(final int num) {
        num = 10; // Compilation error
    }
    void method() {
        final int localVar = 50;
        localVar = 60; // Compilation error
    }


}

class SubClass extends FinalClass { // Compilation error
}
