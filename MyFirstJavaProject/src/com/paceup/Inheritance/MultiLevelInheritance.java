package com.paceup.Inheritance;
//Multilevel Inheritance (One -> Two -> Three)
//Parent class One
class One { //Base Class 1
	// Method to print 
	public void print1() {
		System.out.println("Week");
	}
	public void demo() {
		System.out.println("Class1 demo method called");
	}
	
}

//Child class Two inherits from class One
class Two extends One { //Base Class 2
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
class Three extends Two { //Derived Class
	// Method to print 
	public void print3() {
		System.out.println("Today");
		//super.demo2();
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
		
		System.out.println();
		third.demo2();
	}
}