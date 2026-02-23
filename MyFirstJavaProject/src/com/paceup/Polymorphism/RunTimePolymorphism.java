package com.paceup.Polymorphism;

/**
 * Inheritance:
 * - Mechanism where one class (child/subclass) acquires properties and behaviors of another class (parent/superclass).
 * - Promotes code reusability and method overriding.
 * - Syntax: class Child extends Parent
 * 
 * Example:
 * Animal (superclass) → Dog (subclass)
 * Dog inherits methods sound() and age() from Animal.
 * Dog can override sound() to provide its own implementation.
 */
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }

    void age(int a) {
        System.out.println("Age: " + a);
    }
}

// Dog inherits from Animal
class Dog extends Animal {
    // Overriding sound() method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound(); // Calls Animal's sound()
        a.age(5);

        Dog d = new Dog();
        d.sound(); // Calls Dog's overridden sound()
        d.age(3);  // Inherited method from Animal
    }
}
