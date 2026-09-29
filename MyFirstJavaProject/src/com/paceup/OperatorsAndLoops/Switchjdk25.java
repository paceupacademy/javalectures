package com.paceup.OperatorsAndLoops;

public class Switchjdk25 {

	public static void main(String[] args) {
		int day = 3;
		
		String dayName = switch(day) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "Wednesday";
		default -> "Invalid day number";
		};
		
		System.out.println("Day is "+dayName);
		
		int operation =2;
		int a =10;
		int b=5;
		
		int result = switch(operation) {
		case 1 -> a+b;
		case 2 -> {
			int difference = a-b;
			yield difference * 2;
		}
		case 3 -> a*b;
		case 4 -> a/b;
		default -> 0;
		};
		
		System.out.println("Result= "+result);
	}

}
