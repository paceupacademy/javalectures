//Show use of static variables.

package com.paceup.day4.Asses4;

public class StaticVari {

	static int x = 0; // static variables
	int y; // instance variables

	StaticVari() { // constructors
		x++;
		y = x;
		System.out.println("Y is: " + y);

	}

	static void count() { // static method
		System.out.println("Count is: " + x);
	}

	public static void main(String[] args) {
		StaticVari s1 = new StaticVari();
		StaticVari s2 = new StaticVari();
		StaticVari s3 = new StaticVari();
		
		StaticVari.count(); // accessing static method

	}

}
