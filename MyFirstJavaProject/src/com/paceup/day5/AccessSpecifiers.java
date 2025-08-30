package com.paceup.day5;
import com.paceup.day4.FinalVariable;
import com.paceup.day5.EncapsulationExample;

class ProtectedExample{

    protected int var = 54; //protected variable
    protected void showInteger() {
    	System.out.println("Protected method called!!!");
    }
}

class ChildClass extends ProtectedExample{
	private int instanceVar = 20;
	public void accessMethod() {
		System.out.println("\nProtected Variable value: "+var);
		showInteger();
		
	}
}

public class AccessSpecifiers {
	// Instance Variable (belongs to each object)
    private int instanceVar = 10;
    int localVar2 = 20; //default access specified for variable
	/*
	 * FinalVariable f = new FinalVariable(); int demo = f.var; EncapsulationExample
	 * e = new EncapsulationExample(); int sal= e.id;
	 */
    // Static Variable (shared among all instances)
    static int staticVar = 100;
    
    public AccessSpecifiers() {
    	
    }
    
    // Constructor demonstrating parameter scope
    public AccessSpecifiers(int instanceVar) {
        
        // Parameter Scope 
        // using 'this' to refer to instance variable
        this.instanceVar = instanceVar;
        staticVar = staticVar +35;
    }

    // Method to demonstrate local, parameter, and block scope
    public void showScopes(int paramVar) {
        
        // Local Variable 
        // only accessible in this method
        int localVar = 20; //default access specified for variable

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
        //System.out.println(blockVar);
    }

    public static void main(String[] args) {
    	System.out.println("With Parameterized Constructor!!");
    	AccessSpecifiers obj = new AccessSpecifiers(50);
        obj.showScopes(30);
        
        System.out.println("\nWith Default Constructor");
        AccessSpecifiers as = new AccessSpecifiers();
        as.showScopes(65);
        ChildClass cc = new ChildClass();
        cc.accessMethod();
        DemoClass dc = new DemoClass();
        dc.displayVar();
    }
}

class DemoClass extends AccessSpecifiers{
	public void displayVar() {
		System.out.println("\nLocal Variable value of Parent Class: "+localVar2);
	}
}