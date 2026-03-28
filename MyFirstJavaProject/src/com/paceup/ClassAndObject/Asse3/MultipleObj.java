//Instantiate multiple objects of Student.
package com.paceup.ClassAndObject.Asse3;

public class MultipleObj {


	String name;
	int age;

	public static void main(String[] args) {
		MultipleObj m1 = new MultipleObj();
		m1.name = "Vaishnavi";
		m1.age = 26;
		
		MultipleObj m2 = new MultipleObj();
		m2.name = "Nisha";
		m2.age = 20;
		
		
		MultipleObj m3 = new MultipleObj();
		m3.name = "Ishita";
		m3.age = 15;
		
		System.out.println("Object_1 Details:");
		System.out.println("Name is: " + m1.name);
		System.out.println("Age is: " + m1.age);
		
		System.out.println("Object_2 Details:");
		System.out.println("Name is: " + m2.name);
		System.out.println("Age is: " + m2.age);

		System.out.println("Object_3 Details:");
		System.out.println("Name is: " + m3.name);
		System.out.println("Age is: " + m3.age);
	}

}