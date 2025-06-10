package com.paceup.day7;

class Complex {
    private int real, imag;

    // Constructor
    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    // Simulating operator overloading using a method
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    // Displaying the complex number
    void display() {
        System.out.println(this.real + " + " + this.imag + "i");
    }
}

public class OperatorOverLoading {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);

        Complex result = c1.add(c2);  // Using add() instead of "+"
        result.display(); // Outputs: 4 + 6i
    }
}
