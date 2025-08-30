package com.paceup.day5;

//Java Program which demonstrate Encapsulation
class Account {

	// Private data members (encapsulated)
	private long accNo; // Account number
	private String name;
	private String email;
	private float amount;
	
	// Public getter and setter methods (controlled access)
	/**
	 * @return the accNo
	 */
	public long getAccNo() {
		return this.accNo;
	}
	/**
	 * @param accNo the accNo to set
	 */
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return this.amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	
	
}

public class EncapsulationExample {
	// protected int salary =7000;
	// int id =1;
	public static void main(String[] args) {
		// Create an Account object
		Account acc = new Account();

		// Set values using setter methods (controlled access)
		acc.setAccNo(90482098491L);
		acc.setName("ABC");
		acc.setEmail("abc@gmail.com");
		acc.setAmount(100000f);

		// Get values using getter methods
		System.out.println("Account Number: " + acc.getAccNo());
		System.out.println("Name: " + acc.getName());
		System.out.println("Email: " + acc.getEmail());
		System.out.println("Amount: " + acc.getAmount());
	}
}
