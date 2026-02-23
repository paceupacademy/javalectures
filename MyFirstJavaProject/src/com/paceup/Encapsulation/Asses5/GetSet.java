//1. Create a class with private variables and use getter/setter methods.
package com.paceup.Encapsulation.Asses5;

public class GetSet {

	// Private variables
	private String empid;
	private float salary;
	private String name;

	// getter/setter methods
	public String getID() {
		return empid;
	}

	public void setID(String empid) {
		this.empid = empid;
	}

	public String getSalary() {
		return empid;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// create GetSet method object
		GetSet gs = new GetSet();

		// Set values using setter methods
		gs.setID("3XY");
		gs.setName("Iron Man");
		gs.setSalary(100060f);

		// Get values using getter methods
		System.out.println("EMP ID: " + gs.empid);
		System.out.println("EMP Name: " + gs.name);
		System.out.println("EMP Salary: " + gs.salary);
	}

}
