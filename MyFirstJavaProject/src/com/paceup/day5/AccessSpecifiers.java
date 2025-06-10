package com.paceup.day5;
import com.paceup.day4.FinalVariable;
import com.paceup.day5.EncapsulationExample;

public class AccessSpecifiers {
	// Instance Variable (belongs to each object)
    private int instanceVar = 10;
	/*
	 * FinalVariable f = new FinalVariable(); int demo = f.var; EncapsulationExample
	 * e = new EncapsulationExample(); int sal= e.id;
	 */
    // Static Variable (shared among all instances)
    static int staticVar = 100;

    // Constructor demonstrating parameter scope
    public AccessSpecifiers(int instanceVar) {
        
        // Parameter Scope 
        // using 'this' to refer to instance variable
        this.instanceVar = instanceVar;
    }

    // Method to demonstrate local, parameter, and block scope
    public void showScopes(int paramVar) {
        
        // Local Variable 
        // only accessible in this method
        int localVar = 20;

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
        System.out.println("Method Parameter: " + paramVar);
        System.out.println("Local Variable: " + localVar);

        // Block Scope (variable only accessible inside this block)
        if (localVar > 10) {
            int blockVar = 5;
            System.out.println("Block Variable: " + blockVar);
        }

        // Uncommenting below line would cause an error: blockVar out of scope
        // System.out.println(blockVar);
    }

    public static void main(String[] args) {
    	AccessSpecifiers obj = new AccessSpecifiers(50);
        obj.showScopes(30);
    }
}
