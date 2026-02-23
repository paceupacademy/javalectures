package com.paceup.OperatorsAndLoops;

class InstanceOfOperatorsExample {
    public static void main(String[] args) {
        // Creating objects
        Person obj1 = new Person();   // obj1 is of type Person
        Person obj2 = new Boy();      // obj2 is of type Boy (child class of Person)

        // instanceof operator:
        // --------------------
        // Used to test whether an object is an instance of a particular class or interface.
        // Returns true if the object is of that type (or subclass), otherwise false.

        // obj1 is created as Person, so:
        System.out.println("obj1 instanceof Person: " + (obj1 instanceof Person)); // true
        System.out.println("obj1 instanceof Boy: " + (obj1 instanceof Boy));       // false
        System.out.println("obj1 instanceof MyInterface: " + (obj1 instanceof MyInterface)); // false

        // obj2 is created as Boy, which:
        // - extends Person (so it is also a Person)
        // - implements MyInterface (so it is also an instance of MyInterface)
        System.out.println("obj2 instanceof Person: " + (obj2 instanceof Person)); // true
        System.out.println("obj2 instanceof Boy: " + (obj2 instanceof Boy));       // true
        System.out.println("obj2 instanceof MyInterface: " + (obj2 instanceof MyInterface)); // true
    }
}

// Supporting classes and interface
class Person {
}

class Boy extends Person implements MyInterface {
}

interface MyInterface {
}
