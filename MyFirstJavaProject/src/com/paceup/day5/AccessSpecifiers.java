package com.paceup.day5;

// Example of protected access
class ProtectedExample {
    protected int var = 54; // protected variable → accessible in same package + subclasses

    protected void showInteger() {
        System.out.println("Protected method called!!!");
    }
}

// Child class extending ProtectedExample
class ChildClass extends ProtectedExample {
    public void accessMethod() {
        // Accessing protected members from parent
        System.out.println("Protected Variable value: " + var);
        showInteger();
    }
}

public class AccessSpecifiers {
    // Public variable → accessible everywhere
    public int pubvar = 35;

    // Protected variable → accessible in same package + subclasses
    protected int pvar = 25;

    // Private variable → accessible only within this class
    private int instanceVar = 10;

    // Default (package-private) variable → accessible only within same package
    int localVar2 = 20;

    // Static variable → shared among all instances
    static int staticVar = 100;

    // Default constructor
    public AccessSpecifiers() {
        instanceVar++;
    }

    // Parameterized constructor demonstrating scope
    public AccessSpecifiers(int instanceVar) {
        // 'this' refers to current object's instance variable
        this.instanceVar = instanceVar;
    }

    // Method demonstrating different scopes
    public void showScopes(int paramVar) {
        // Local variable → exists only inside this method
        int localVar = 20;

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
        System.out.println("Method Parameter: " + paramVar);
        System.out.println("Local Variable: " + localVar);

        // Block scope → variable exists only inside this block
        if (localVar > 10) {
            int blockVar = 5;
            System.out.println("Block Variable: " + blockVar);
        }

        // Uncommenting below line would cause error (blockVar out of scope)
        // System.out.println(blockVar);
    }

    public static void main(String[] args) {
        // Demonstrating constructors and scopes
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

        // Demonstrating protected access via subclass
        ChildClass cc = new ChildClass();
        cc.accessMethod();
        System.out.println();

        // Demonstrating default access via subclass
        DemoClass dc = new DemoClass();
        dc.displayVar();
    }
}

// Subclass accessing default variable
class DemoClass extends AccessSpecifiers {
    public void displayVar() {
        System.out.println("Local Variable (default access): " + localVar2);
    }
}