package com.paceup.Polymorphism;

class Calculator {
    // Overloaded method: accepts int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method: accepts double parameters
    double add(double a, double b) {
        return a + b;
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calls int version → add(int, int)
        System.out.println(calc.add(5, 10));       

        // Calls double version → add(double, double)
        System.out.println(calc.add(5.5, 10.5));  
    }
}
