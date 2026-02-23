package com.paceup.Java8Features;

/**
 * Greeting Functional Interface Example:
 * --------------------------------------
 * In Java 8, **Functional Interfaces** are interfaces that contain exactly one abstract method.
 * They are the foundation of **Lambda Expressions** and **Method References**.
 * 
 * Key Concepts:
 * -------------
 * 1. **Functional Interface**:
 *    - An interface with a single abstract method (SAM).
 *    - Can have default and static methods, but only one abstract method.
 *    - Annotated with `@FunctionalInterface` (optional but recommended).
 * 
 * 2. **Lambda Expressions**:
 *    - Provide a concise way to implement functional interfaces.
 *    - Syntax: `(parameters) -> expression` or `(parameters) -> { statements }`.
 * 
 * 3. **Method References**:
 *    - Shortcut to refer to existing methods instead of writing lambdas.
 *    - Types: `object::instanceMethod`, `Class::staticMethod`, `Class::new` (constructor reference).
 * 
 * 4. **Use Cases**:
 *    - Event handling (e.g., button clicks).
 *    - Iterating collections with `forEach`.
 *    - Passing behavior as parameters (strategy pattern).
 *    - Simplifying code in streams API.
 */
@FunctionalInterface
interface Greeting {
    void sayHello(String name); // Single Abstract Method (SAM)
}

public class BasicLambdaExample {
    public static void main(String[] args) {
        // Example 1: Lambda Expression
        Greeting greetLambda = (name) -> System.out.println("Hello, " + name + "!");
        greetLambda.sayHello("Aishwarya");

        // Example 2: Method Reference (using a static method)
        Greeting greetStatic = BasicLambdaExample::staticHello;
        greetStatic.sayHello("Suraj");

        // Example 3: Method Reference (using an instance method)
        BasicLambdaExample example = new BasicLambdaExample();
        Greeting greetInstance = example::instanceHello;
        greetInstance.sayHello("Java Developer");

        // Example 4: Inline Lambda with more logic
        Greeting greetLogic = (name) -> {
            if (name.isEmpty()) {
                System.out.println("Hello, Stranger!");
            } else {
                System.out.println("Hello, " + name + "! Welcome to Java 8 Features.");
            }
        };
        greetLogic.sayHello("Paceup");
        greetLogic.sayHello("");
    }

    // Static method for method reference
    public static void staticHello(String name) {
        System.out.println("Static Hello to " + name);
    }

    // Instance method for method reference
    public void instanceHello(String name) {
        System.out.println("Instance Hello to " + name);
    }
}
