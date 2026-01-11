//7.Create a class Person with a method updateAge(int age) and demonstrate call by value.int 
package com.paceup.day8.Asses8;

public class PersonAge {
	public static void main(String[] args) {
		int age = 44;
		updateAge(age);
		System.out.println("Original Age: " + age);
	}

	public static void updateAge(int updateage) {
		updateage = 45;
		System.out.println("Updated Age: " + updateage);
	}

}
