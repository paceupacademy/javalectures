package com.paceup.day4;

final class FinalClass {
    void show() {
        System.out.println("This is a final class.");
    }
    void display(final int num) {
        //num = 10; // Compilation error
    	System.out.println("Final Variable has: "+num);
    }
    void method() {
        final int localVar = 50;
        //localVar = 60; // Compilation error
        display(localVar);
    }
    
    public static void main(String[] args) {
    	FinalClass fc = new FinalClass();
    	fc.show();
    	fc.method();
    }
}
