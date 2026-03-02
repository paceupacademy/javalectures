//Write a program to check if a number is even or odd.

package com.paceup.OperatorsAndLoops.Asse2;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int x = sc.nextInt();
		if(x % 2 ==0) {
			System.out.println("Given number is Even!");
		}else
			System.out.println("Given Number is odd!");
	}

}
