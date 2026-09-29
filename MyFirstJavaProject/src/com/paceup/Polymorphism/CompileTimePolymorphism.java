package com.paceup.Polymorphism;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(double a, double b) {
        return (int)(a + b);
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));       // Calls int version
        System.out.println(calc.add(5.3, 10.5));  // Calls double version
    }
}
