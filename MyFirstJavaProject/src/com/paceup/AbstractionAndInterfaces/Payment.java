package com.paceup.AbstractionAndInterfaces;

/*
 * class -> extends -> class and implement -> interface
 * class -> implements -> interface
 * interface -> extends -> interface
 */

//Interface defining the contract
public interface Payment {
	void processPayment(double amount);
	
	default void dfMethod() {
		System.out.println("Default Method called");
	}
	
	static void display() {
		System.out.println("Static Method called");
	}
}