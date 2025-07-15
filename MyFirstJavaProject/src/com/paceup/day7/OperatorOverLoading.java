package com.paceup.day7;
//Java doesn't support operator overloading directly(like C++) but we can simulate it using methods
class Complex {
    private int real, imag;

    // Constructor
    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    // Simulating operator overloading using a method
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag); // (4,6)
    }

    // Displaying the complex number
    void display() {
        System.out.println("Complex Number: "+this.real + " + " + this.imag + "i"); //4+6i
    }
}

public class OperatorOverLoading {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        c1.display();
        Complex c2 = new Complex(1, 2);
        c2.display();
        Complex result = c1.add(c2);  // Using add() instead of "+"
        result.display(); // Outputs: 4 + 6i
        
        String s1 = "Hi, ";
        String s2 = "Aishwarya!!";
        System.out.println(" "+(s1+s2)); //concatenation object level
    }
}
