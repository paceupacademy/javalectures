package com.paceup.day2;

public class WhileExample {
	public static void main(String args[])
	{
		int i = 1, s = 0;
		
		// loop continues until i becomes greater than 10
		while (i <= 10) {

			// add the current value of i to s
			s = s + i; 

			// increment i for the next iteration
			i++;
		}
		System.out.println("Summation of 1-10: " + s);

		int c = 6;

		// Using do-while loop
		do {
			System.out.println("PaceupAcademy: " + c);
			c--;
		} while (c <= 5 && c>0);
	}
}
