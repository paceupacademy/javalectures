package com.paceup.Generics;

import java.util.ArrayList;

/**
 * AutoboxingExample:
 * ------------------
 * Theoretical Notes:
 * ------------------
 * 1. Autoboxing:
 *    - Automatic conversion of primitive types (int, double, etc.)
 *      into their corresponding wrapper class objects (Integer, Double, etc.).
 *    - Introduced in Java 5 to simplify code.
 *
 * 2. Unboxing:
 *    - Reverse process: converting wrapper class objects back into primitives.
 *    - Example: Integer obj = 10; int num = obj; // unboxing
 *
 * 3. Why Needed:
 *    - Collections (like ArrayList, HashMap) can only store objects, not primitives.
 *    - Autoboxing allows primitives to be added directly without manual conversion.
 *    - Arithmetic operations automatically unbox wrapper objects to primitives.
 *
 * Backend Working:
 * ----------------
 * - int num = 10; Integer boxedNum = num;
 *   → Compiler internally translates to Integer.valueOf(num).
 *
 * - numbers.add(5);
 *   → Compiler internally translates to numbers.add(Integer.valueOf(5)).
 *
 * - int x = numbers.get(0);
 *   → Compiler internally translates to numbers.get(0).intValue().
 */
public class AutoboxingExample {
	public static void main(String[] args) {
		// Example 1: Autoboxing primitive to wrapper
		// Input: 10 (primitive int)
		// Output: Integer object with value 10
		// 10 ---> [Autoboxing] ---> Integer.valueOf(10)
		int num = 10;
		Integer boxedNum = num; 
		System.out.println("Boxed Number: " + boxedNum);

		// Example 2: Adding primitives to a collection (requires objects)
		// Input: [5,15] (primitive ints)
		// Output: [5,15] (stored as Integer objects in ArrayList)
		// [5,15] ---> [Autoboxing] ---> ArrayList<Integer>[5,15]
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(5);  // Autoboxing: int → Integer
		numbers.add(15); // Autoboxing: int → Integer
		System.out.println("Autoboxed List: " + numbers);

		// Example 3: Unboxing (wrapper → primitive)
		// Input: Integer(5) from list
		// Output: 5 (primitive int)
		// Integer(5) ---> [Unboxing: intValue()] ---> 5
		int firstElement = numbers.get(0); 
		System.out.println("Unboxed First Element: " + firstElement);
	}
}

/*
 * Primitive Type WrapperClass
 * int 				Integer
 * float			Float
 * double			Double
 * byte				Byte
 * char				Character
 * long				Long
 * short			Short
 * boolean			Boolean
 * */
