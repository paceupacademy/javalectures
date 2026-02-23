package com.paceup.OperatorsAndLoops;

import java.util.Scanner;

public class SwitchUserInput {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String day=null;
		System.out.println("Enter one of first three day of week(Monday,Tuesday,Wednesday):");
		day=sc.next();
		switch(day) {
			case "monday":
			case "Monday": 
					System.out.println("Monday entered");
					break;
			case "Tuesday":
					System.out.println("Tuesday Entered");
					break;
			case "Wednesday":
					System.out.println("Wednesday entered");
					break;
			default:
					System.out.println("Wrong day entered");
		
		}
		System.out.println("Exit Switch");

	}

}
