//2. Write a program demonstrating the use of all four access specifiers.
package com.paceup.day5.Asses5;

import com.paceup.day5.AccessSpecifiers;

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

	static class demonstrate extends AccessSpecifiers {

		public void access() {
			System.out.println("Local protected Variable AccessSpecifiers class: " + provar);
			System.out.println("Local public Variable AccessSpecifiers classs: " + pubvar);
		}
	}

	public static void main(String[] args) {
		AccessModi obj = new AccessModi();
		obj.display();

		demonstrate obj2 = new demonstrate();
		obj2.access();

	}

}
