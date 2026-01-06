//5. Create a base class and derive three child classes, demonstrating hierarchical inheritance.
package com.paceup.day6.Asses6;

class Base {
	void display() {
		System.out.println("This is Base class....");
	}
}

class Derived_A extends Base {
	void display_A() {
		System.out.println("This is Derived_A class....");
	}
}

class Dervied_B extends Base {
	void display_B() {
		System.out.println("This is Derived_B class....");
	}
}

class Dervied_C extends Base {
	void display_C() {
		System.out.println("This is Derived_C class....");
	}
}

class SubDervied extends Derived_A {
	void display_sub() {
		System.out.println("This is SubDerived class....");
	}
}

public class Hierarchical_Inheritance {

	public static void main(String[] args) {
		
		Derived_A obj1 = new Derived_A();
		obj1.display();
		System.out.println("\n");
		
		Dervied_B obj2 = new Dervied_B();
		obj2.display_B();
		System.out.println("\n");
		
		
		Dervied_C obj3 = new Dervied_C();
		obj3.display();
		System.out.println("\n");
		
		SubDervied obj4 = new SubDervied();
		obj4.display();
		obj4.display_A();
		obj4.display_sub();
		
	}

}
