//4. Write a program that passes an object Student to a method and updates its name.

package com.paceup.day8.Asses8;

class StudentTest {
	String name;
}

public class Test {
	static void update(StudentTest s) { // Method that updates the student's name
		s.name = "HULK"; // modifying object field
	}

	public static void main(String[] args) {

		StudentTest student = new StudentTest();
		student.name = "LOKI";
		System.out.println("Before update: " + student.name);
		update(student); // passing object to method

		System.out.println("After update: " + student.name);

	}
}
