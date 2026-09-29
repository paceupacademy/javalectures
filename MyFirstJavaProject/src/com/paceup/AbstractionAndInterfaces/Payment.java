package com.paceup.AbstractionAndInterfaces;

/*
 * class -> extends -> class and implement -> interface
 * class -> implements -> interface
 * interface -> extends -> interface
 */

//Interface defining the contract
public interface Payment {
	//Abstract Method (Has no body, Not Concrete)
	void processPayment(double amount);
	
	//Default Method(Has body, Is Concrete)
	default void dfMethod() {
		startPayment();
		System.out.println("Default Method called");
	}
	
	//Static Method (Has body, Is concrete)
	static void display() {
		//startPayment();
		System.out.println("Static Method called");
	}
	
	private void startPayment() {
		System.out.println("Starting Payment");
	}
}