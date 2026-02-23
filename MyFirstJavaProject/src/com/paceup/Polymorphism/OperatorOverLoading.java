package com.paceup.Polymorphism;

// Complex number class
class Complex {
    private int real, imag;

    // Constructor
    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    // Equivalent to '-' operator overloading
    Complex sub(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    // Equivalent to '+' operator overloading
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    // Displaying the complex number
    void display() {
        System.out.println("Result Complex Number: " + this.real + " + " + this.imag + "i");
    }
}

public class OperatorOverLoading {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4); // 3 + 4i
        c1.display();

        Complex c2 = new Complex(1, 2); // 1 + 2i
        c2.display();

        // Addition
        Complex addData = c1.add(c2); // (3+1) + (4+2)i = 4 + 6i
        addData.display();

        // Subtraction
        Complex result = c1.sub(c2);  // (3-1) + (4-2)i = 2 + 2i
        result.display();

        // String concatenation (operator overloading at object level in Java)
        String s1 = "Hi, ";
        String s2 = "Aishwarya!!";
        System.out.println(s1 + s2); // "Hi, Aishwarya!!"
    }
}
