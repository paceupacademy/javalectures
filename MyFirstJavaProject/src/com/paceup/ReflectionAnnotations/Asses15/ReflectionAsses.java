//1. Use reflection to list all methods and fields of a given class.
package com.paceup.ReflectionAnnotations.Asses15;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee {
	// Declare the fields
	private int id;
	public String Name;
	protected double salary;

	// constructor creation
	public Employee() {
	}

	// public method creation
	public void work() {
		System.out.println("Working..");
	}

	// private method creation
	private void CalculateBonus() {
		System.out.println("Calculatin bonus...");
	}
}

public class ReflectionAsses {
	public static void main(String[] args) {
		// Get class object
		Class<?> clazz = Employee.class;
		System.out.println("Class Name: " + clazz.getName());

		// FIELDS
		System.out.println("Fields: ");
		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			System.out.println("Name: " + f.getName());

		}

		System.out.println("Methods:");
		Method[] methods = clazz.getDeclaredMethods();

		for (Method m : methods) {
			System.out.println("Method Name:" + m.getName());
		}

	}

}
