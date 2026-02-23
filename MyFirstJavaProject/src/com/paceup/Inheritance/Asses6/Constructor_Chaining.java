//4. Show constructor chaining using super() and this().
package com.paceup.Inheritance.Asses6;

/*class A {
	A(String name) { // parent class constructors
		System.out.println("Recieved name: " + name+" from B's parameterized cosntructor"); //3rd
	}
}

class B extends A {
	B() { // child class constructors
		this("XYZ"); // calls B(STring)  //1st
		
		System.out.println("Default constructor finished."); //5th
	}

	B(String name) {
		super(name); // calls A(String) //2nd	
		System.out.println("Received name from Default Constructor..."); //4th
		
	} 
}

public class Constructor_Chaining {

	public static void main(String[] args) {
		B obj = new B();

	}

}*/

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
