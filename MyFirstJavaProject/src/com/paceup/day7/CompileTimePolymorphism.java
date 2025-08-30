package com.paceup.day7;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));       // Calls int version
        System.out.println(calc.add(5.5, 10.8));  // Calls double version
    }
}
