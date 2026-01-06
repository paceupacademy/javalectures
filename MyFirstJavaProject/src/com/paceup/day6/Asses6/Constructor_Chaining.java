//4. Show constructor chaining using super() and this().
package com.paceup.day6.Asses6;

class A {
	A(String name) { // parent class constructors
		System.out.println("A name: " + name);
	}
}

class B extends A {
	B() { // child class constructors
		this("XYZ"); // calls B(STring)
		System.out.println("Name created.");
	}

	B(String name) {
		super(name); // calls A(STring)
		System.out.println("B constructors called...");
	}
}

public class Constructor_Chaining {

	public static void main(String[] args) {
		B obj = new B();

	}

}
