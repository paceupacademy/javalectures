//2. Write a program to demonstrate abstraction using Vehicle, Car, and Bike classes.
package com.paceup.day8.Asses8;

abstract class Vehical{
	abstract void mileage();
}

class Car extends Vehical{
	@Override
	void mileage() {
		System.out.println("Car avarage mileage is 15-22 km/h");
	}
}

class Bike extends Vehical{

	@Override
	void mileage() {
		System.out.println("Bike avarage mileage is 50-60 km/h");
	}
}

public class AbstractVehical {

	public static void main(String[] args) {
		Vehical v1 = new Car();
		v1.mileage();
		Vehical v2 = new Bike();
		v2.mileage();
		
		

	}

}
