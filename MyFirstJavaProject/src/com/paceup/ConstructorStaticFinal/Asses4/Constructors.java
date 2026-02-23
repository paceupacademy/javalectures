//Write a class with default and parameterized constructors.

package com.paceup.ConstructorStaticFinal.Asses4;

class Constructors {

	// Default constructors
	public Constructors() {
		System.out.println("This is Default Constructors...");
	}

	// Parameterized constructors
	Constructors(int m) {
		System.out.println("This is Parameterized Constructors...");
		System.out.println("Parameterized Constructors value: " + m);
	}

	public static void main(String[] args) {
		Constructors dc = new Constructors();
		Constructors cc = new Constructors(10);
	}

}
