//3. Demonstrate the effect of transient keyword in a serializable class.

package com.paceup.day14.Asses14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bank implements Serializable {
	private static final long serialversionUID = 3L;
	String Customer_name = "Rajesh";
	transient long Acc_no = 234134561345l; // skip the account number in serialization for privacy
	String Address = "Unit 223, Laxmi Plaza, New Link Rd, Laxmi Industrial Estate, Andheri(w)";

	public static void main(String[] args) throws Exception {
		Bank b = new Bank();

		try (FileOutputStream fi = new FileOutputStream("Customer.ser");
				ObjectOutputStream oo = new ObjectOutputStream(fi)) {
			oo.writeObject(b);
			System.out.println("Serialized the Customer details..");
		}

		try (FileInputStream fi = new FileInputStream("Customer.ser");
				ObjectInputStream oo = new ObjectInputStream(fi)) {
			Bank b1 = (Bank) oo.readObject();
			System.out.println("Deserialized the customer details are below,");
			System.out.println("Customer Name: " + b1.Customer_name + ", Account Number: " + b1.Acc_no + ", Address: "
					+ b1.Address);
		}
	}
}