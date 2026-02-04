package com.paceup.day15;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates built-in annotations and custom annotations in Java.
 */
class Personn {
    @Deprecated
    public void oldMethod() {
        // @Deprecated marks this method as obsolete.
        // Compiler will warn if this method is used.
    	//for runtime reflection
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
        
        new Thread(()-> System.out.println("New Thread created")).start();
    }

    @FunctionalInterface
    interface Myfunc {
        // @FunctionalInterface ensures only one abstract method is allowed.
        // This makes the interface suitable for lambda expressions.
        void display();
    }
}

