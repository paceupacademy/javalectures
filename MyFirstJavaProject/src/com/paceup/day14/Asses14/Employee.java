//2. Write a program to serialize a list of custom Employee objects.

package com.paceup.day14.Asses14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialversionUID = 1L;
	String Name;
	String Emp_ID;
	String Depart;
	transient int Salary;

	public Employee(String Name, String Emp_ID, String Depart, int Salary) {
		this.Name = Name;
		this.Emp_ID = Emp_ID;
		this.Depart = Depart;
		this.Salary = Salary;
	}

	public static void main(String[] args) throws Exception {
		Employee e1 = new Employee("Priya", "3BG", "DTB", 30000000);
		Employee e2 = new Employee("Neha", "75Y", "VAM", 6080000);

		try (FileOutputStream fo = new FileOutputStream("Employee.ser");
				ObjectOutputStream oo = new ObjectOutputStream(fo)) {
			oo.writeObject(e1);
			oo.writeObject(e2);
			System.out.println("Serialization completed...");

		}
		System.out.println("Deserialization Started...");
		try (FileInputStream fi = new FileInputStream("Employee.ser");
				ObjectInputStream oi = new ObjectInputStream(fi)) {
			Employee emp1 = (Employee) oi.readObject();
			Employee emp2 = (Employee) oi.readObject();
			System.out.println("Employee Detail are below,");
			System.out.println("Name: " + emp1.Name + ", EmpID: " + emp1.Emp_ID + ", Salary: " + emp1.Salary);
			System.out.println("Name: " + emp2.Name + ", EmpID: " + emp2.Emp_ID + ", Salary: " + emp2.Salary);

		}
	}
}
