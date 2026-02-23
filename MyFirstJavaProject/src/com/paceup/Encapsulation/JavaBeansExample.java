package com.paceup.Encapsulation;

// JavaBeansExample class
// ----------------------
// A JavaBean is a reusable software component in Java that follows certain conventions:
// 1. Must be public.
// 2. Must have a no-argument constructor.
// 3. Properties (fields) must be private.
// 4. Must provide public getter and setter methods for accessing properties.
// 5. Should implement Serializable (optional, but common for persistence).
public class JavaBeansExample implements java.io.Serializable {
    
    // Private properties (encapsulated fields)
    private int id;
    private String name;

    // No-argument constructor (required for JavaBeans)
    public JavaBeansExample() {}

    // Getter and Setter for 'id'
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Main method to demonstrate usage
    public static void main(String args[]) {
        // Create a JavaBeansExample object
        JavaBeansExample j = new JavaBeansExample();

        // Set values using setter methods
        j.setId(9);
        j.setName("Daisy");

        // Get values using getter methods
        System.out.println("Id: " + j.getId());
        System.out.println("Name: " + j.getName());
    }
}
