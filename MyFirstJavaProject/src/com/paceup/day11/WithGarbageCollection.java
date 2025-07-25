package com.paceup.day11;

// Corrected code to count number of employees excluding interns.
class Employee1 {

    private int ID;
    private String name;
    private int age;
    private static int nextId = 1; // Shared among all objects

    public Employee1(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }

    @Override
    protected void finalize() throws Throwable {
    	System.out.println("Before cleanup called");
    }
    
    public void show() {
        System.out.println("Id=" + ID + "\tName=" + name + "\tAge=" + age);
    }

    public static void showNextId() {
        System.out.println("Next employee id will be=" + nextId);
    }
}

public class WithGarbageCollection {
    public static void main(String[] args) {

        Employee1 e1 = new Employee1("GFG1", 56);
        Employee1 e2 = new Employee1("GFG2", 45);
        Employee1 e3 = new Employee1("GFG3", 25);

        e1.show();
        e2.show();
        e3.show();
        Employee1.showNextId();

        // Managing intern employees using try-with-resources alternative approach
        manageInterns();

        Employee1.showNextId();
        
        System.gc();
        
        e1.show();
        //System.runFinalization();
    }

    private static void manageInterns() {
        Employee1 x = new Employee1("GFG4", 23);
        Employee1 y = new Employee1("GFG5", 21);

        x.show();
        y.show();
       // Employee1.showNextId();

        // Explicit cleanup without relying on GC
        x = null;
        y = null;

        // Suggesting manual cleanup but avoiding deprecated finalization
        System.out.println("Intern objects are no longer needed.");
    }
}
