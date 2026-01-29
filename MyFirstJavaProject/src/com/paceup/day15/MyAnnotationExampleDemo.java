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

    @SuppressWarnings("deprecation")
    public void demo() {
        // @SuppressWarnings disables compiler warnings for specific cases.
        // Here, we suppress the warning for calling a deprecated method.
        Personn p = new Personn();
        p.oldMethod(); // Warning suppressed
    }

    @FunctionalInterface
    interface Myfunc {
        // @FunctionalInterface ensures only one abstract method is allowed.
        // This makes the interface suitable for lambda expressions.
        void display();
    }
}

// ------------------ Inherited Annotation Example ------------------

// @Inherited allows subclasses to inherit annotations from their parent class.
@Inherited
@interface MyInterface {} // Custom annotation

@MyInterface // Class A is annotated
class A {}

class B extends A {} // Class B inherits annotation from A

// ------------------ Repeatable Annotation Example ------------------

// @Repeatable allows multiple annotations of the same type on a single element.
@Repeatable(Hints.class)
@interface Hint {
    String value();
}

// Container annotation to hold multiple @Hint annotations.
@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}

// Applying repeatable annotations
@Hint("One")
@Hint("Two") // Equivalent to @Hints({@Hint("One"), @Hint("Two")})
class RepeatableExample {}

// ------------------ Demo Class ------------------
public class MyAnnotationExampleDemo {
    public static void main(String[] args) {
        // Demonstrate built-in annotations
        Personn p = new Personn();

        // Create sample lists
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("xyz");

        List<String> list2 = new ArrayList<>();
        list2.add(null);
        list2.add("asjsadkjhd");

        // Call methods with annotations
        p.demo(); // Suppressed warning for deprecated method
        p.printAll(list1, list2); // Safe varargs usage

        // Reflection: Retrieve annotations at runtime
        Annotation[] ann = RepeatableExample.class.getAnnotations();
        System.out.println("\nAnnotations present on RepeatableExample class:");
        for (Annotation a : ann) {
            System.out.println("Annotation: " + a);
        }

        // Retrieve individual repeatable annotations
        Hint[] hints = RepeatableExample.class.getAnnotationsByType(Hint.class);
        System.out.println("\nIndividual @Hint annotations:");
        for (Hint h : hints) {
            System.out.println("Hint value: " + h.value());
        }
    }
}
