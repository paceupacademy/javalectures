package com.paceup.day7;

class Parent {
    void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child class method (Overridden)");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.show();  // Outputs: Parent class method

        Parent p2 = new Child();  // Superclass reference holding a subclass object
        p2.show();  // Outputs: Child class method (Polymorphism in action)
    }
}

