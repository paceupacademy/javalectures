package com.paceup.ExceptionHandling.Asses12;

public class NestedTryCatch {
	public static void main(String[] args) {
		try {
			System.out.println("Outer try block,");
			try {
				int[] arr = { 10, 20, 30 };
				System.out.println(arr[4]);
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("Inner catch: Array index error handled first,");
			}
			int x = 10 / 0;
		} catch (ArithmeticException e2) {
			System.out.println("Outer catch: Arithmetic error");
		}
		System.out.println("Remaining program continues normally");
	}

}
