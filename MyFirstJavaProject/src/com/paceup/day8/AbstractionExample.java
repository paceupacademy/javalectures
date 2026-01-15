package com.paceup.day8;

//Abstract class cannot be instantiated may contain abstract method(w/o body) as well as concrete method(implementation)
abstract class Animal {
	// Abstract method (no body)
	abstract void sound();

	// Concrete method
	void sleep() {
		System.out.println("Sleeping...");
	}
}

//Subclass (inherits from Animal)
class Dog extends Animal {
	public void printName() {
		System.out.println("Name is Champ!!");
	}
	// Providing implementation for the abstract method
	@Override
	void sound() {
		System.out.println("Woof Woof!");
	}
}

public class AbstractionExample {
	public static void main(String[] args) {
		// Cannot instantiate an abstract class
		//Animal animal = new Animal(); // This will cause an error

		// Using a subclass
		Animal myDog = new Dog(); //upcasting
		myDog.sound(); // Calls the overridden method
		myDog.sleep(); // Calls the concrete method
		
		
		Dog dg= new Dog();
		dg.printName(); // Cannot be accessed by Animal class object myDog as this is not created inside Animal Class
	}
}
