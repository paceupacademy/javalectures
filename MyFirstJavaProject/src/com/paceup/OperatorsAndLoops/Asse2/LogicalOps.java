//Demonstrate logical operators in a program.

package com.paceup.OperatorsAndLoops.Asse2;

public class LogicalOps {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		if (a > 5 && b > 10) {
			System.out.println("Both conditions are true");			
		}
		
		if (a > 15 || b > 10) {
			System.out.println("At least one condition is true");
		}
		
		boolean result = a < b;
		System.out.println("Before NOT:"+ result);
		System.out.println("After NOT:"+ !result);
	}

}


