package com.paceup.day7;

class Parent {
	private void display() {
		System.out.println("Parent display called");
	}
    void showParentdisplay() {
    	display();
        System.out.println("Parent class method called");
    }
}

class Child extends Parent {
    private void display() {
    	System.out.println("Child display called");
    }
    void showChildDisplay() {
    	display();
        System.out.println("Child class method (Overridden)");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.showParentdisplay();  // Outputs: Parent class method

        Child c = new Child();  // Superclass reference holding a subclass object
        c.showChildDisplay();  // Outputs: Child class method (Polymorphism in action)
    }
}

