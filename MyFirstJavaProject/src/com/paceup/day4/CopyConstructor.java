package com.paceup.day4;

class CopyConstructorExample {
	int x;
	int y=25;

	CopyConstructorExample(int value) { //Parameterized Constructor
		x = 30;
		y=value;
		System.out.println("Prmeterized Constructor Called!! X value is "+x);
	}

	CopyConstructorExample(CopyConstructorExample obj) { // Copy constructor
		x = obj.x;
		System.out.println(" Copy Constructor called!!! X value is "+x+" Y value is: "+y);
	}
}

public class CopyConstructor {
	public static void main(String[] args) {
		CopyConstructorExample obj1 = new CopyConstructorExample(20);
		CopyConstructorExample obj2 = new CopyConstructorExample(obj1); // Calls the copy constructor
		System.out.println("Value in obj2: " + obj2.x);
	}
}
