//Write a method to display object properties.
package com.paceup.ClassAndObject.Asse3;

public class ObjProp {

	String name;
	int age;

	public void display() {
		System.out.println("Name is: " + name + ", Age: " + age);

	}

	public static void main(String[] args) {
		ObjProp o1 = new ObjProp();
		o1.name = "Tony Stark";
		o1.age = 26;

		ObjProp o2 = new ObjProp();
		o2.name = "Iron Man";
		o2.age = 20;

		ObjProp o3 = new ObjProp();
		o3.name = "Jarvis";
		o3.age = 15;

		o1.display();
		o2.display();
		o3.display();

	}

}