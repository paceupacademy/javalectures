//8. Show that private methods are not overridden by writing a base and derived class example.

package com.paceup.Polymorphism.Asses7;

class Base{
	private void display() {
		System.out.println("Base class display method...");
	}
}

class Derived extends Base{
	 private void display() {
		System.out.println("Dervied class show method...");
	}
}

public class PrivateOverridden {

	public static void main(String[] args) {
		
		Base objBase = new Base();
		//objBase.display(); //Compile Error
		
		Derived objDerived = new Derived();
		//objDerived.display(); //Compile Error
	}

}
