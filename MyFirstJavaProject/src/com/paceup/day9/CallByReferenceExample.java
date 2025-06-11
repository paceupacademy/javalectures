package com.paceup.day9;

class Person {
    String name;
}

public class CallByReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alice";
        modifyObject(person);
        System.out.println("Name after modification: " + person.name); // Output: Bob
    }

    public static void modifyObject(Person p) {
        p.name = "Bob"; // Modifies the object's field
    }
}
