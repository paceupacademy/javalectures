//Write a program to demonstrate object eligibility for garbage collection.
package com.paceup.GarbageCollection.Asse11;

public class GarbageCollection {
	String name;
	int age;

	GarbageCollection(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name + "\tAge: " + age);
	}

	public static void main(String[] args) {
		GarbageCollection G1 = new GarbageCollection("ABC", 20);
		G1 = null; // set G1 object as null means it is unreachable now.

		GarbageCollection G2 = new GarbageCollection("XYZ", 20);
		GarbageCollection G3 = new GarbageCollection("PNY", 20);

		System.gc();
		G2.display();
		G3.display();
	}

}
