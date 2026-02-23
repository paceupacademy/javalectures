//3. Demonstrate method overloading with different data types (int, double, String).

package com.paceup.Polymorphism.Asses7;

public class DemonstrateOverloading {
	int add(int a, int b) {
		return a + b;
	}

	double add(double a, double b) {
		return a + b;
	}

	String add(String a, String b) {
		return a + b;
	}

	public static void main(String[] args) {
		DemonstrateOverloading obj = new DemonstrateOverloading();

		System.out.println("Int Result: " + obj.add(10, 10));
		System.out.println("Double Result: " + obj.add(10.5, 20.5));
		System.out.println("String Result: " + obj.add("Vaishnavi_", "Mahajan"));
	}

}
