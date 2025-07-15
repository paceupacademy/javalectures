package com.paceup.day6;
//Multilevel Inheritance (One -> Two -> Three)
//Parent class One
class One {
	// Method to print 
	public void print1() {
		System.out.println("Week");
	}
	public void demo() {
		System.out.println("Class1 method");
	}
}

//Child class Two inherits from class One
class Two extends One {
	
	public void demo2() {
		System.out.println("Class 2 demo method called");
		super.demo();
	}
	// Method to print
	public void print2() {
		System.out.println("Starts");
	}
}

//Child class Three inherits from class Two
class Three extends Two {
	// Method to print 
	public void print3() {
		System.out.println("Today");
	}
}

//Driver class
public class MultiLevelInheritance {
	public static void main(String[] args) {
		// Creating an object of class Three
		Three third = new Three();

		// Calling method from class One
		third.print1();

		// Calling method from class Two
		third.print2();
		

		// Calling method from class Three
		third.print3();
		
		third.demo2();
	}
}