//10. Write a Java program using interface with default methods and override them in implementing class.

package com.paceup.Polymorphism.Asses7;

 interface Bike {
	 default void ride() {
	 }
}

class Activa implements Bike{
	@Override
	public void ride() {
		System.out.println("Riding Activa.");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		Bike objBike = new Activa();
		objBike.ride();
	}

}
