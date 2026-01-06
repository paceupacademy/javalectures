//1. Write a program demonstrating single inheritance with classes Vehicle and Car.
package com.paceup.day6.Asses6;

class Vehicle {
	String name;

	public void ride() { // parent class
		System.out.println("Brands of Vehicals.");
	}
}

class Car extends Vehicle { // child class of vehicals
	public void brand() {
		System.out.println(name + " is vehical brand.");
	}
}

public class Single_Inheritance {

	public static void main(String[] args) {
		Car ca = new Car();
		 ca.name = "TATA"; //Accessing the parent class fields
		 ca.name = "AUDI";
		 ca.ride(); //Accessing the parent class method
		 ca.brand();
	}

}
