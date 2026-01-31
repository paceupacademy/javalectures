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
	public void accessMethod() {
		System.out.println("Protected Variable value: "+var);
		showInteger();
	}
}

public class AccessSpecifiers {
	public int pubvar = 35;
	protected int pvar=25;
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
    	instanceVar++;
    }
    
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
        int localVar = 20; //default access specified for variable
        /*
         * \n -> new line
         * \t -> tab
         */
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
    	AccessSpecifiers obj = new AccessSpecifiers(50);
        obj.showScopes(30);
        System.out.println();
        AccessSpecifiers obj2 = new AccessSpecifiers(51);
        obj2.showScopes(31);
        System.out.println();
        AccessSpecifiers obj3 = new AccessSpecifiers();
        obj3.showScopes(32);
        System.out.println();
        AccessSpecifiers obj4 = new AccessSpecifiers();
        obj4.showScopes(33);
        System.out.println();
        
        ChildClass cc = new ChildClass();
        cc.accessMethod();
        System.out.println();
        
        DemoClass dc = new DemoClass();
        dc.displayVar();
    }
}

class DemoClass extends AccessSpecifiers{
	public void displayVar() {
		System.out.println("Local Variable: "+localVar2);
	}
}