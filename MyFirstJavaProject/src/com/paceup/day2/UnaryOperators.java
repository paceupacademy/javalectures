package com.paceup.day2;

// Java Program to show the use of
// Unary Operators
import java.io.*;

public class UnaryOperators {

	// main function
	public static void main(String[] args)
	{
		// Interger declared
		int a = 10;
		int b = 10;

		// Using unary operators
		System.out.println("Postincrement : " + (a++));
		System.out.println("Preincrement : " + (++a));

		System.out.println("Postdecrement : " + (b--));
		System.out.println("Predecrement : " + (--b));
	}
}
