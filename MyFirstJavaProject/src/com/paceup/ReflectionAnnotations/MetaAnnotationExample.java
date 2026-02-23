package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MetaAnnotationExample:
 * ----------------------
 * Demonstrates **meta-annotations** in Java:
 *
 * 1. @Inherited → allows subclasses to inherit annotations from parent classes.
 * 2. @Repeatable → allows multiple annotations of the same type on one element.
 * 3. @Retention(RUNTIME) → makes annotations available at runtime via reflection.
 * 4. @Target → restricts where annotation can be applied (TYPE, METHOD, etc.).
 * 5. Reflection → retrieves annotations at runtime using getAnnotations() / getAnnotationsByType().
 *
 * Backend Working:
 * ----------------
 * - When multiple @Hint annotations are applied, the compiler wraps them into a single
 *   container annotation (@Hints).
 * - Because @Hint is marked @Inherited, subclasses (like B) inherit annotations from parent (A).
 * - Reflection APIs allow us to inspect annotations at runtime and print their values.
 *
 * Expected Output:
 * ----------------
 * Annotations present on RepeatableExample class:
 * Annotation: @paceup.ReflectionAnnotations.Hints(value=[@paceup.ReflectionAnnotations.Hint(value=One), @paceup.ReflectionAnnotations.Hint(value=Two)])
 *
 * Annotations on B are:
 * Annotation is @paceup.ReflectionAnnotations.Hints(value=[@paceup.ReflectionAnnotations.Hint(value=One), @paceup.ReflectionAnnotations.Hint(value=Two)])
 *
 * Individual Repeatable Annotations:
 * Hint value: One
 * Hint value: Two
 */

//------------------ Inherited Annotation Example ------------------

// Custom annotation type (not used here, just for demonstration)
@interface MyInterface {}

// Repeatable annotation applied to Class A
@Hint("One")
@Hint("Two")
class A {}

class B extends A {} // Class B inherits annotation from A because @Hint is @Inherited

//------------------ Repeatable Annotation Example ------------------

@Inherited
@Target(ElementType.TYPE)
@Repeatable(Hints.class) // Compiler wraps multiple @Hint into @Hints
@Retention(RetentionPolicy.RUNTIME)
@interface Hint {
    String value();
}

// Container annotation to hold multiple @Hint annotations
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Hints {
    Hint[] value(); // Array of repeatable type
}

// Applying repeatable annotations
@Hint("One")
@Hint("Two")
class RepeatableExample {}

//------------------ Demo Class ------------------
public class MetaAnnotationExample {
    public static void main(String[] args) {
        // Reflection: Retrieve annotations at runtime

        // Get all annotations on RepeatableExample
        Annotation[] ann = RepeatableExample.class.getAnnotations();
        System.out.println("\nAnnotations present on RepeatableExample class:");
        for (Annotation a : ann) {
            System.out.println("Annotation: " + a);
        }

        // Get annotations on subclass B (inherited from A)
        Annotation[] ann1 = B.class.getAnnotations();
        System.out.println("\nAnnotations on B are:");
        for (Annotation a : ann1) {
            System.out.println("Annotation is " + a);
        }

        // Retrieve individual repeatable annotations (unwraps @Hints into @Hint[])
        Hint[] hints = RepeatableExample.class.getAnnotationsByType(Hint.class);
        System.out.println("\nIndividual Repeatable Annotations:");
        for (Hint h : hints) {
            System.out.println("Hint value: " + h.value());
        }
    }
}
