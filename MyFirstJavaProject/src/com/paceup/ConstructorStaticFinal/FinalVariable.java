package com.paceup.ConstructorStaticFinal;

import com.paceup.Encapsulation.AccessSpecifiers;

public class FinalVariable {
    // Instance variables
    public int var = 100;       // public → accessible everywhere
    private int pvar = 50;      // private → accessible only inside this class

    // Final instance variable → constant, cannot be reassigned
    final double PI = 3.14159;

    // Final method → cannot be overridden in subclasses
    final void sum(int a, int b) {
        System.out.println("Var: " + var + " Pvar: " + pvar);
        int result = a + b;
        System.out.println("Addition result: " + result + " PI: " + PI);
    }

    public static void main(String[] args) {
        // Define a constant variable PI (local final variable)
        final double PI = 3.1415;

        // Create object of FinalVariable
        FinalVariable fv = new FinalVariable();

        // fv.PI cannot be reassigned because it's final
        // PI = 7161743; // Compilation error if uncommented

        // Private variable can be modified inside the same class
        fv.pvar = 60;

        // Call final method
        fv.sum(7, 19);

        // Print local final variable and updated private variable
        System.out.println("Value of PI: " + PI + "\n PVAR changed value is : " + fv.pvar);

        // Demonstrating constructor call with AccessSpecifiers
        AccessSpecifiers as = new AccessSpecifiers(fv.pvar);
    }
}

/*
 * class Demo extends AccessSpecifiers {
 *     void display() {
 *         System.out.println(" " + pubvar);
 *     }
 * }
 */
