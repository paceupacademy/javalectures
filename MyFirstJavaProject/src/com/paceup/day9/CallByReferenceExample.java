package com.paceup.day9;

class Person {
    String name;
}

public class CallByReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alice";
        System.out.println("Name before modification: "+person.name+"\n");
        
        modifyObject(person); //Reference(address) to "person" object 
        System.out.println("Name after modification: " + person.name); // Output: Bob
        System.out.println();
        
        modify(person); //Reference address passed
        System.out.println("Name after modification: "+person.name);
    }

    public static void modifyObject(Person p) {
        p.name = "Bob"; // Modifies the object's field person.name=Bob
    }
    
    static void modify(Person p) {
    	p.name="Shraddha"; //->person.name=Shraddha
    	
    	p = new Person(); //Reassignment reference -address update
    	//System.out.println(" "+p.name);
    	p.name = "Aishwarya"; //p.name = Aishwarya
    	System.out.println("Modified Value of new object: "+p.name);
    }
}
