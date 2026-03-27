package com.paceup.Generics;

/**
 * GenericMethodExample:
 * ---------------------
 * Theoretical Notes:
 * ------------------
 * 1. Generic Method:
 *    - Declared with type parameters (e.g., <T>).
 *    - Works with any type of data without rewriting code.
 *
 * 2. Type Parameter <T>:
 *    - Acts as a placeholder for the actual type.
 *    - Compiler replaces <T> with the actual type at compile time.
 *
 * 3. Advantages:
 *    - Code reusability: one method works for multiple data types.
 *    - Type safety: prevents runtime ClassCastException.
 *    - Cleaner code: no explicit casting required.
 *
 * Backend Working:
 * ----------------
 * - Compiler ensures type safety by replacing T with the actual type.
 * - Example: printArray(Integer[]) → T = Integer.
 * - Example: printArray(String[]) → T = String.
 */
public class GenericMethodExample {
	// Generic Method
	public static <T> void printArray(T[] array) { 
		// Works with any type of array (Integer[], String[], Double[], etc.)
		for (T element : array) { 
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example 1: Integer array
		// Input: [1,2,3,4]
		// Output: "1 2 3 4"
		// [1,2,3,4] ---> [printArray(T=Integer)] ---> "1 2 3 4"
		Integer[] intArray = {1, 2, 3, 4};
		System.out.print("Integer Array: ");
		printArray(intArray);

		// Example 2: String array
		// Input: ["A","B","C"]
		// Output: "A B C"
		// ["A","B","C"] ---> [printArray(T=String)] ---> "A B C"
		String[] stringArray = {"A", "B", "C"};
		System.out.print("String Array: ");
		printArray(stringArray);
	}
}
