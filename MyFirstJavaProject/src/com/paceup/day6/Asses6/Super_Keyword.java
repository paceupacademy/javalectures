//3. Use the 'super' keyword to call superclass constructors and methods.
package com.paceup.day6.Asses6;

class Super_class {
	Super_class() { // parent class constructors
		System.out.println("This is Super class constructors...");
	}

	void view() {
		System.out.println("super class method...");
	}
}

class Subclass extends Super_class {
	Subclass() { // Child class constructors
		super(); // call superclass constructors
	}

	void display() {
		super.view(); // call superclass method
		System.out.println("This is sub-class constructors..");

	}
}

public class Super_Keyword {

	public static void main(String[] args) {
		Subclass sb = new Subclass();
		sb.display();

	}

}
