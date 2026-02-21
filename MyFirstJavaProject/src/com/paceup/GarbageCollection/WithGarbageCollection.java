package com.paceup.GarbageCollection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * WithGarbageCollection:
 * ----------------------
 * 
 * Garbage Collection:
 * - Automatic memory management in Java.
 * - Removes objects that are no longer reachable (no references pointing to them).
 * - Helps prevent memory leaks and optimizes performance.
 * 
 * finalize():
 * - A method called by GC before reclaiming an object.
 * - Deprecated after Java 9 (not recommended).
 * - Alternative: use try-with-resources or explicit cleanup methods.
 * 
 * Ways to make objects eligible for GC:
 * 1. Nullifying references → obj = null;
 * 2. Reassigning references → obj = new Object();
 * 3. Objects created inside methods → eligible after method ends.
 * 4. Island of isolation → objects referencing each other but not reachable from program.
 * 
 * Key Point:
 * - Calling System.gc() or Runtime.getRuntime().gc() only *suggests* GC to run.
 * - JVM decides when actual garbage collection happens.
 */
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

    // finalize() is deprecated after Java 9
    @Override
    protected void finalize() throws Throwable {
        System.out.println("\nBefore cleanup called");
    }

    public void show() {
        System.out.println("Id=" + ID + "\tName=" + name + "\tAge=" + age);
    }

    public static void showNextId() {
        System.out.println("Next employee id will be = " + nextId);
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
        System.out.println();
        Employee1.showNextId();

        System.out.println();

        // Managing intern employees using try-with-resources alternative approach
        manageInterns();

        Employee1.showNextId();

        // Making e1 eligible for GC
        e1 = null; // nullifying reference
        System.gc(); // Request garbage collection (not guaranteed)
        e2.show();
    }

    private static void manageInterns() {
        Employee1 x = new Employee1("GFG4", 23);
        Employee1 y = new Employee1("GFG5", 21);

        x.show();
        y.show();
        System.out.println();
        Employee1.showNextId();
        System.out.println();

        // Nullifying references → eligible for GC
        x = null;
        y = null;       
        System.out.println("Intern objects are no longer needed.");

        // Example with Integer object
        Integer i = new Integer(7);
        i = null; // object becomes unreachable
        Runtime.getRuntime().gc(); // request GC
        System.out.println(" " + i); // prints null
    }
}
