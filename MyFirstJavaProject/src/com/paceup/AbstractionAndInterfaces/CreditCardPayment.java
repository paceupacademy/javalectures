package com.paceup.AbstractionAndInterfaces;

//Implementation 1: Credit Card Payment
public class CreditCardPayment implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing credit card payment of ₹" + amount);
	}
	
}