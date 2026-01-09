//1. Create a class Calculator and overload the add() method for 2 and 3 parameters.
package com.paceup.day7.Asses7;

public class Calculator {

	int add(int a, int b) {
		return a + b;
	}

	float add(float a, float b, float c) {
		return a + b + c;
	}

	public static void main(String[] args) {

		Calculator obj = new Calculator();
		int int_sum = obj.add(10, 20);
		float float_sum = obj.add(20.1f, 30.0f, 10.3f);

		System.out.println("Interger Sum:" + int_sum);
		System.out.println("Float Sum:" + float_sum);
	}

}
