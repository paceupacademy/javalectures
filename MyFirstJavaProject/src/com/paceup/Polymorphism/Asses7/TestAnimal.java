//2. Create a superclass Animal with a method sound(), and override it in subclasses Dog and Cat.
package com.paceup.Polymorphism.Asses7;

class Animal {
	void sound() {
		System.out.println("Animal Sound...");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("Dog barks...");
	}
}

class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("Cat meow...");
	}
}

public class TestAnimal {
	public static void main(String[] args) {

		Animal an = new Animal();
		an.sound();

		Animal dg = new Dog();
		dg.sound();

		Animal ca = new Cat();
		ca.sound();
	}

}
