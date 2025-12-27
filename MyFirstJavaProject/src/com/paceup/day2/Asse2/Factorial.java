//Calculate factorial using for loop.

package com.paceup.day2.Asse2;

import java.util.Scanner;

public class Factorial {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		if(n<0) {
			System.out.println("Invalid Number!");
		}
		int factorial = 1;
		for(int i = n; i>1; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial is: "+ factorial);
	}

}
