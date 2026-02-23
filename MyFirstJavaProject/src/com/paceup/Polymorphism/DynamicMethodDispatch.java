package com.paceup.Polymorphism;

class Parent {
    private void display() {
        System.out.println("Parent display called");
    }

    void showParentdisplay() {
        display(); // Calls Parent's private display()
        System.out.println("Parent class method called");
    }
}

class Child extends Parent {
    private void display() {
        System.out.println("Child display called");
    }

    void showChildDisplay() {
        display(); // Calls Child's private display()
        System.out.println("Child class method (Overridden)");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.showParentdisplay();  
        // Output:
        // Parent display called
        // Parent class method called

        Child c = new Child();
        c.showChildDisplay();    
        // Output:
        // Child display called
        // Child class method (Overridden)
    }
}
