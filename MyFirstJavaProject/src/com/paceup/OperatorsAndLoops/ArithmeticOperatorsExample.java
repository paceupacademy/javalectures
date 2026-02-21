package com.paceup.OperatorsAndLoops;

enum Day{
	Monday,
	Tuesday,
	Wednesday
}

class ArithmeticOperatorsExample
{
	public static void main (String[] args) 
	{

		// Arithmetic operators on integers
		int a = 10;
		int b = 3;

		// Arithmetic operators on Strings
		String n1 = "15";
		String n2 = "25";
		// Convert Strings to integers
		int a1 = Integer.parseInt(n1); //String -> integer a1=15
		int b1 = Integer.parseInt(n2); //a2=25
		
		
		a = a+b; //a=10+3 ->13
		
		System.out.println("a + b = " + (a + b)); //13+3->16
		System.out.println("a - b = " + (a - b)); //13-3 -> 10
		System.out.println("a * b = " + (a * b)); //13*3 ->39
		System.out.println("a / b = " + (a / b)); //13/3 ->4.332
		System.out.println("a % b = " + (a % b)); //13%3 ->1
		System.out.println("a1 + b1 = " + (a1 + b1)); //15+25=40
		System.out.println("a = " + (a)); //13+3->16
		
	}
}