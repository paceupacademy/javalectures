//8. Demonstrate both abstract and concrete methods in a real-world example like Appliance with TV and Fridge.
package com.paceup.AbstractionAndInterfaces.Asses8_and_Asses9;

abstract class Appliance {
	abstract void start(); // abstract method

	void plugIn() { // concrete method
		System.out.println("Appliance is plugged in");
	}
}

class TV extends Appliance { // subclass of appliance

	@Override
	void start() {
		System.out.println("We can start TV using remote.");
	}
}

class Fridge extends Appliance { // subclass of appliance

	@Override
	void start() {
		System.out.println("We can open fridge door manually.");
	}
}

public class ReadWordAbstractEX {
	public static void main(String[] args) {
		Appliance tv = new TV();
		Appliance fg = new Fridge();

		tv.plugIn(); // concrete method
		tv.start(); // abstract method

		fg.plugIn(); // concrete method
		fg.start(); // abstract method
	}

}
