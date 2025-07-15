package com.paceup.day2;

// Java Program to show the use of
// Unary Operators
import java.io.*;

public class UnaryOperators {

	// main function
	public static void main(String[] args)
	{
		// Interger declared
		int a = -10;
		int b = 10;

		// Using unary operators
		System.out.println("Postincrement : " + (a++)); //10//a=10+1=11
		System.out.println("Preincrement : " + (++a));  //12
		
		System.out.println("Postdecrement : " + (b--)); //10//b=b-1=9
		System.out.println("Predecrement : " + (--b)); //9-1=8
	}
}
