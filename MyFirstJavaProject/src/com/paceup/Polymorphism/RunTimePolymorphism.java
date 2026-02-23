package com.paceup.Polymorphism;

/**
 * 
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

    // Dog can also have its own methods
    void breed(String b) {
        System.out.println("Breed: " + b);
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        // Parent class reference
        Animal a = new Animal();
        a.sound(); // Animal makes a sound
        a.age(5);

        // Child class reference
        Dog d = new Dog();
        d.sound(); // Dog barks (overridden method)
        d.age(3);  // Inherited method
        d.breed("German Shepherd");

        // Polymorphism: Parent reference pointing to Child object
        Animal ref = new Dog();
        ref.sound(); // Dog barks (runtime polymorphism)
        ref.age(2);
        // ref.breed("Labrador"); // Not accessible via Animal reference
    }
}
