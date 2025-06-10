package com.paceup.day6;

class Animal3 {
	protected String name;

	protected void display() {
		System.out.println("I am an animal.");
	}
}

class Dog3 extends Animal3 {

	public void getInfo() {
		System.out.println("My name is " + name);
	}
}

class ProtectedMethod {
	public static void main(String[] args) {

		// create an object of the subclass
		Dog3 labrador = new Dog3();

		// access protected field and method
		// using the object of subclass
		labrador.name = "Rocky";
		labrador.display();

		labrador.getInfo();
	}
}
