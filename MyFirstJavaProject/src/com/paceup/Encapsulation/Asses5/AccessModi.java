//2. Write a program demonstrating the use of all four access specifiers.
package com.paceup.Encapsulation.Asses5;

import com.paceup.Encapsulation.AccessSpecifiers;

public class AccessModi {

	public int a = 10; // public
	protected float b = 20.90f; // protected
	private long c = 34669228895L; // private
	String d = "Name"; // default

	public void display() {
		System.out.println("public a: " + a);
		System.out.println("protected b: " + b);
		System.out.println("private c: " + c);
		System.out.println("default d: " + d);
	}

	
	
/***********************************************************************************************************/
	
	
//Que3. Create two packages and demonstrate access control across them.

	 class Demonstrate extends AccessSpecifiers { //subclass of AccessSpecifiers class also inner class of AccessModi class

		public void access() {
			System.out.println("Local protected Variable AccessSpecifiers class: " + pvar);
			System.out.println("Local public Variable AccessSpecifiers classs: " + pubvar);
		}
	}

	public static void main(String[] args) {
		AccessModi obj = new AccessModi();
		obj.display();

		AccessModi.Demonstrate obj2 = obj.new Demonstrate(); //non-static inner class must be created using and object of its outer class
		obj2.access();

	}
}

