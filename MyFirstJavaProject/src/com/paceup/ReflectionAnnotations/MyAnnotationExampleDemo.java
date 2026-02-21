package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Key Concepts:
 * -------------
 * 1. @Deprecated:
 *    - Marks a method as obsolete.
 *    - Compiler will warn if this method is used.
 *    - Still executes at runtime, but signals developers to avoid using it.
 *
 * 2. @SafeVarargs:
 *    - Suppresses warnings about using varargs with generics.
 *    - Ensures type safety when passing multiple lists.
 *
 * 3. @SuppressWarnings:
 *    - Disables compiler warnings for specific cases.
 *    - Example: suppressing warnings for calling a deprecated method.
 *
 * 4. @FunctionalInterface:
 *    - Ensures the interface has exactly one abstract method.
 *    - Used in lambda expressions and method references.
 *
 * Backend Working:
 * ----------------
 * - The compiler checks annotations during compilation.
 * - @Deprecated → generates a warning if used.
 * - @SafeVarargs → prevents unsafe varargs warnings.
 * - @SuppressWarnings → tells compiler to ignore specific warnings.
 * - @FunctionalInterface → enforces single abstract method rule.
 *
 * Expected Output:
 * ----------------
 * Deprecated Method Called!!!
 * New Thread created
 * [abc, xyz]
 * [null, asjsadkjhd]
 */
class Personn {
    @Deprecated
    public void oldMethod() {
        // @Deprecated marks this method as obsolete.
        // Compiler will warn if this method is used.
        System.out.println("Deprecated Method Called!!!");
    }

    @SafeVarargs
    public static void printAll(List<String>... lists) {
        // @SafeVarargs suppresses warnings about using varargs with generics.
        // It ensures type safety when passing multiple lists.
        for (List<String> l : lists) {
            System.out.println(" " + l);
        }
    }

    @SuppressWarnings({"checked","deprecation"})
    public void demo() {
        // @SuppressWarnings disables compiler warnings for specific cases.
        // Here, we suppress the warning for calling a deprecated method.
        Personn p = new Personn();
        p.oldMethod(); // Warning suppressed

        // Lambda expression inside Thread
        new Thread(() -> System.out.println("New Thread created")).start();
    }

    @FunctionalInterface
    interface Myfunc {
        void execute(); // Only one abstract method allowed
    }

    // Demo main method
    public static void main(String[] args) {
        Personn p = new Personn();

        // Call demo() → internally calls deprecated method and starts a thread
        p.demo();

        // Create sample lists
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("xyz");

        List<String> list2 = new ArrayList<>();
        list2.add(null);
        list2.add("asjsadkjhd");

        // Call printAll() → prints both lists
        p.printAll(list1, list2);
    }
}
