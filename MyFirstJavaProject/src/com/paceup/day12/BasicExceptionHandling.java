package com.paceup.day12;

public class BasicExceptionHandling {
	public static void main(String[] args) {
		/*
		 * String name = null; System.out.println(name.length()); //NullPointerException
		 */		
		/*
		 * Object obj ="Hello"; Integer i = (Integer) obj; //ClassCastException
		 */		
		double data= 10.459d;
		int n = (int) data;
		System.out.println(n);
		
		/*
		 * Runtime r = Runtime.getRuntime(); long maxMem = r.maxMemory();
		 * System.out.println(r.totalMemory());//Current heap size
		 * System.out.println(r.freeMemory()); //free memory allocated in heap size
		 */
		
		//int[] arr = new int[999999999]; //OutOfMemoryError
		/*
		 * String h = "Hello"; System.out.println(h.charAt(10));
		 * //StingIndexOutOfBoundsException
		 */		
		/*
		 * int[] arr = {10,20,30}; System.out.println(arr[5]);
		 * //ArrayIndexOutOfBoundsException
		 */		
		try { //block of code monitored for exceptions or risky code
			int result = 10 / 0; // This will throw ArithmeticException
			
		} catch (Exception e) { //exception handling is done
			System.out.println("Cannot divide by zero: " + e.getMessage());
		} finally { //executes regardless of any exception
			System.out.println("Execution completed.");
		}
	}
}
