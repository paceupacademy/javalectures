//6. Write an abstract class Employee with abstract method calculateSalary(). Extend it with Manager and Clerk.
package com.paceup.day8.Asses8_and_Asses9;

abstract class Employee { // abstarct class
	abstract double calculateSalary(); // abstract method

	String name;
	String EmpID;
}

class Manager extends Employee { // Manager class

	double salary;

	Manager(String EmpID, String name, Double salary) { // parameterized constructor

		this.name = name;
		this.EmpID = EmpID;
		this.salary = salary;
	}

	@Override
	double calculateSalary() {
		return salary;
	}

}

class Clerk extends Employee { // clerk class
	double salary;
	double bonus;

	public Clerk(String EmpID, String name, Double salary, double bonus) {
		this.name = name;
		this.EmpID = EmpID;
		this.salary = salary;
		this.bonus = bonus;
	}

	@Override
	double calculateSalary() {
		return bonus + salary;
	}

}

public class AbstractEmployee {
	public static void main(String[] args) {
		Employee e1 = new Manager("1AB", "Raj", 500000.80); // values passed to object
		Employee e2 = new Clerk("5DC", "Sunil", 30000.60, 1579.90);

		System.out.println("Manager Details: " + e1.calculateSalary());
		System.out.println("Clerk details: " + e2.calculateSalary());

	}
}
