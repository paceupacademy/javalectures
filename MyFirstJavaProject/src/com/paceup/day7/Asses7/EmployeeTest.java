//5. Create a method showDetails() in parent class Employee and override it in subclass Manager.
//6. Write a program to call overridden methods using a superclass reference.

package com.paceup.day7.Asses7;

class Employee {
	void showDetails() {
		System.out.println("Employee details:");
	}
}

class Manager extends Employee {
	@Override
	void showDetails() {
		System.out.println("Manager is Details:");
	}
}

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.showDetails();

		Employee e2 = new Manager(); // superclass reference
		e2.showDetails();
	}

}
