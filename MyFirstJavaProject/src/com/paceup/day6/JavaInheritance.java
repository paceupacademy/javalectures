package com.paceup.day6;

class Animal {

	// field and method of the parent class
	String name;
	void eat() {
		System.out.println("I can eat");
	}
}

// inherit from Animal
class Dog extends Animal {

	// new method in subclass
	public void display() {
		System.out.println("My name is " + name);
	}
	
	@Override
	void eat()
	{
		System.out.println("Eating Fruits!!!");
	}
	//System.out.printlin("Message:")
}
public class JavaInheritance {
	public static void main(String[] args) {

		// create an object of the subclass
		Dog labrador = new Dog();

		// access field of superclass
		labrador.name = "Rohu";
		labrador.display();

		// call method of superclass
		// using object of subclass
		labrador.eat();

	}
}
