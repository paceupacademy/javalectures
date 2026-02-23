package com.paceup.Inheritance;

class Animal2 {

	// method in the superclass
	public void eat() {
		System.out.println("I can eat");
	}
}

// Dog inherits Animal
class Dog2 extends Animal2 {

	// overriding the eat() method
	@Override
	public void eat() {
		System.out.println("I eat dog food");
	}

	// new method in subclass
	public void bark() {
		System.out.println("I can bark");
	}
}
public class MethodOverriding {
	public static void main(String[] args) {

		// create an object of the subclass
		Dog2 labrador = new Dog2();

		// call the eat() method
		labrador.eat();
		labrador.bark();
	}
}
