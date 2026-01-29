package com.paceup.day5;

//Java Program which demonstrate Encapsulation
class Account {

	// Private data members (encapsulated)
	private long accNo; // Account number
	private String name;
	private String email;
	private float amount;

	
	public long getAccNo() {
		return this.accNo;
	}



	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}



	public String getName() {
		return this.name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return this.email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public float getAmount() {
		return this.amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public void deposit(float d) {
		this.setAmount(this.getAmount()+d);
	}
}

public class EncapsulationExample{
	// protected int salary =7000;
	// int id =1;
	AccessSpecifiers as =  new AccessSpecifiers();
	int var=as.pubvar;
			
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
		acc.deposit(48475.483748f);
		System.out.println("Updated amount: "+acc.getAmount());
		
		System.out.println();
		
		// Create an Account object
		Account acc1 = new Account();

		// Set values using setter methods (controlled access)
		acc1.setAccNo(90482098492L);
		acc1.setName("XYZ");
		acc1.setEmail("xyz@gmail.com");
		acc1.setAmount(200000f);

		// Get values using getter methods
		System.out.println("Account Number: " + acc1.getAccNo());
		System.out.println("Name: " + acc1.getName());
		System.out.println("Email: " + acc1.getEmail());
		System.out.println("Amount: " + acc1.getAmount());
		
		
		
	}
}
