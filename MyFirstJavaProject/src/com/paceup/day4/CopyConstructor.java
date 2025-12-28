package com.paceup.day4;

class CopyConstructorExample {
	int x;
	int y=25;

	CopyConstructorExample(int value) { //Parameterized Constructor
		x = 30;
		y=value;
		System.out.println("Parmeterized Constructor Called!! X value is "+x+" and  Y value is "+y+"\n");
	}

	CopyConstructorExample(CopyConstructorExample obj) { // Copy constructor
		x = obj.x;
		System.out.println("Copy Constructor called!!! X value is "+x+" and Y value is: "+y);
	}
}

public class CopyConstructor {
	public static void main(String[] args) {
		CopyConstructorExample obj1 = new CopyConstructorExample(20);
		CopyConstructorExample obj2 = new CopyConstructorExample(obj1); // Calls the copy constructor
		System.out.println("\nValue in obj2: " + obj2.x+ "and Y value is "+obj2.y);
	}
}
