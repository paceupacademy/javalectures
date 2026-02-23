package com.paceup.Inheritance;

class Animal {

	int a;
	// field and method of the parent class
	String name;
	void eat() {
		System.out.println(name+" can eat");
	}
	
}

// inherit from Animal
class Dog extends Animal {

	// new method in subclass
	public void display() {
		System.out.println("My name is " + name+" age is "+a);
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
		labrador.name = "Roh";
		labrador.a =1;
		labrador.display();

		// call method of superclass
		// using object of subclass
		labrador.eat();
		
		int a = (int) 34.65;
		Animal an = new Dog();
		an.name="Animal";
		an.eat();
		//an.display();

	}
}
