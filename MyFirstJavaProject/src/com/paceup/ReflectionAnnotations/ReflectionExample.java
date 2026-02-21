package com.paceup.ReflectionAnnotations;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.annotation.*;

/**
 * ReflectionExample:
 * ------------------
 * Demonstrates how Reflection works in Java with classes, fields, methods, and annotations.
 *
 * Key Concepts:
 * -------------
 * 1. @Documented:
 *    - Marks annotation for inclusion in Javadoc.
 *
 * 2. @Retention(RUNTIME):
 *    - JVM retains annotation metadata at runtime.
 *    - Reflection APIs can read annotation values.
 *
 * 3. @Target(TYPE):
 *    - Restricts usage of annotation to classes/interfaces/enums.
 *
 * 4. Reflection:
 *    - Allows runtime inspection of classes, fields, methods, and constructors.
 *    - Can override access checks (setAccessible(true)) to access private fields.
 *    - Methods can be invoked dynamically using invoke().
 *
 * Backend Working:
 * ----------------
 * - Compiler attaches metadata (annotations, fields, methods) to class files.
 * - JVM loads classes dynamically at runtime.
 * - Reflection APIs allow inspection and modification of class structure.
 * - Private fields can be accessed by overriding access checks.
 * - Methods can be invoked dynamically without compile-time knowledge.
 *
 * Expected Output (simplified):
 * -----------------------------
 * All fields of Person Class are:
 * Name of field: name   Value for field: Aishwarya
 * Name of field: age    Value for field: 30
 *
 * All fields of Person Class are:
 * Name of field: name   Value for field: Neha
 * Name of field: age    Value for field: 35
 *
 * All Methods: (list of all declared methods in String class)
 *
 * Public Methods: (list of public methods in String class)
 * (compareTo invoked internally)
 *
 * Constructors: (list of constructors of com.paceup.day15.Person class)
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotationDoc {
    String author();
    String date();
}

class Person {
    protected String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@MyAnnotationDoc(author = "Aishwarya", date = "02-09-2025")
public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Load String class dynamically
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods(); // all declared methods
        Method[] methods1 = clazz.getMethods();        // only public methods

        // Create Person objects
        Person p = new Person("Aishwarya", 30);
        Person p1 = new Person("Neha", 35);

        // Access fields of Person using reflection
        Class<?> c = p.getClass();
        Field[] fields = c.getDeclaredFields();

        System.out.println("All fields of Person Class are: ");
        for (Field f : fields) {
            f.setAccessible(true); // allow access to private field
            System.out.print("Name of field: " + f.getName());
            System.out.print("\tValue for field: " + f.get(p) + "\n");
        }

        Class<?> cl = p1.getClass();
        Field[] fields1 = cl.getDeclaredFields();

        System.out.println("All fields of Person Class are: ");
        for (Field f : fields1) {
            f.setAccessible(true);
            System.out.print("Name of field: " + f.getName());
            System.out.print("\tValue for field: " + f.get(p1) + "\n");
        }

        // Print methods of String class
        System.out.println("\nAll Methods: ");
        for (Method method : methods) {
            System.out.print(method.getName() + ", ");
        }

        System.out.println("\n\nPublic Methods: ");
        for (Method method1 : methods1) {
            System.out.print(method1.getName() + ", ");
            if (method1.getName().equals("compareTo")) {
                Object result = method1.invoke(p.name, p1.name); // p.name.compareTo(p1.name)
                // System.out.println("\nResult: " + result);
            }
        }

        // Print constructors of another class
        Class<?> cls = Class.forName("com.paceup.day15.Person");
        System.out.println("\n\nConstructors:");
        for (var constructor : cls.getDeclaredConstructors()) {
            System.out.println(" " + constructor);
        }
    }
}
