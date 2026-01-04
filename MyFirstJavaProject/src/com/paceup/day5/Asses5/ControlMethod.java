//5. Show an example where access specifiers control method access between two classes.
package com.paceup.day5.Asses5;

public class ControlMethod {

    public void publicMethod() {
        System.out.println("Public method accessed");
    }

    protected void protectedMethod() {
        System.out.println("Protected method accessed");
    }

    void defaultMethod() {
        System.out.println("Default method accessed");
    }

    private void privateMethod() {
        System.out.println("Private method accessed");
    }

    // Method inside same class
    public void testPrivate() {
        privateMethod(); 
    }
}
