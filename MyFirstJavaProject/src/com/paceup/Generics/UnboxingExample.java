package com.paceup.Generics;

/**
 * UnboxingExample:
 * ----------------
 * Theoretical Notes:
 * ------------------
 * 1. Autoboxing:
 *    - Automatic conversion of primitive types (int, double, etc.)
 *      into their corresponding wrapper class objects (Integer, Double, etc.).
 *    - Example: int → Integer.
 *
 * 2. Unboxing:
 *    - Reverse process: converting wrapper class objects back into primitives.
 *    - Example: Integer → int.
 *
 * 3. Why Needed:
 *    - Arithmetic operations require primitives.
 *    - Collections store wrapper objects, so unboxing allows direct use in calculations.
 *
 * Backend Working:
 * ----------------
 * - Integer boxedNum = 20;
 *   → Compiler internally translates to Integer.valueOf(20).
 *
 * - int result = boxedNum + 10;
 *   → Compiler internally translates to boxedNum.intValue() + 10.
 *   → Unboxing occurs automatically when using wrapper objects in arithmetic.
 */
public class UnboxingExample {
	public static void main(String[] args) {
		// Example 1: Autoboxing (primitive → wrapper)
		// Input: 20 (primitive int)
		// Output: Integer object with value 20
		// 20 ---> [Autoboxing] ---> Integer.valueOf(20)
		Integer boxedNum = 20; 

		// Example 2: Unboxing during arithmetic operation (wrapper → primitive)
		// Input: Integer(20) + 10
		// Output: 30 (primitive int)
		// Integer(20) ---> [Unboxing: intValue()] ---> 20 ---> +10 ---> 30
		int result = boxedNum + 10; 

		System.out.println("Unboxed Value: " + result);
	}
}
