package com.paceup.day9;

/*
 * Primitive -> copy the value -> original value not affected
 * Object -> Copy reference and pass -> object can be modified but reference is not change
 */


class Person {
    String name;
}

public class CallByReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alice";
        modifyObject(person); //Reference(address) to "person" object 
        System.out.println("Name after modification: " + person.name); // Output: Bob
        
        modify(person);
        System.out.println("Name: "+person.name);
    }

    public static void modifyObject(Person p) {
        p.name = "Bob"; // Modifies the object's field
    }
    
    static void modify(Person p) {
    	p.name="Shraddha";
    	p = new Person(); //Reassignment reference -address update
    	p.name = "Aishwarya";
    	System.out.println("Modified Value of new object: "+p.name);
    }
}
