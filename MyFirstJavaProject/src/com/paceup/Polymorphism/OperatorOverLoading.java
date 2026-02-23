package com.paceup.Polymorphism;
//Java doesn't support operator overloading directly(like C++) but we can simulate it using methods
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
        /*
         * return new Complex(3 - 1,4 - 2); 
         */
    }
    
    // Equivalent to '+' operator overloading
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag); 
        /*
         * return new Complex(3 + 1,4 + 2); 
         */
    }

    // Displaying the complex number
    void display() {
        System.out.println("Result Complex Number: "+this.real + " + " + this.imag + "i"); //4+6i = 4 + 6 * squareroot(-1)
    }
}

public class OperatorOverLoading {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4); //c1.real = 3 and c1.imag=4 => 3+4i
        c1.display();
        
        System.out.println();
        Complex c2 = new Complex(1, 2); //=> 1 +2i
        c2.display();
        
        System.out.println();
        Complex addData = c1.add(c2);
        addData.display();
        
        System.out.println();
        Complex result = c1.sub(c2);  // Using add() instead of "+"
        result.display(); // Outputs: 4 + 6i
        
        
        System.out.println();
        String s1 = "Hi, ";
        String s2 = "Aishwarya!!";
        System.out.println(" "+(s1+s2)); //concatenation object level
    }
}
