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
    Complex sub(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag); 
        /*
         * return new Complex(3 - 1,4 - 2); 
         */
    }

    // Displaying the complex number
    void display() {
        System.out.println("Complex Number: "+this.real + " + " + this.imag + "i"); //4+6i
    }
}

public class OperatorOverLoading {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4); //c1.real = 3 and c1.imag=4
        c1.display();
        System.out.println();
        Complex c2 = new Complex(1, 2);
        c2.display();
        System.out.println();
        Complex result = c1.sub(c2);  // Using add() instead of "+"
        result.display(); // Outputs: 4 + 6i
        
        System.out.println();
        String s1 = "Hi, ";
        String s2 = "Aishwarya!!";
        System.out.println(" "+(s1+s2)); //concatenation object level
    }
}
