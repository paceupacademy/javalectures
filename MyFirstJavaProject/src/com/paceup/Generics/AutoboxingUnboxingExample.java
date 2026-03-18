package com.paceup.Generics;

/**
 * AutoboxingUnboxingExample:
 * --------------------------
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
 *    - Collections (like ArrayList, HashMap) can only store objects, not primitives.
 *    - Autoboxing allows primitives to be added directly without manual conversion.
 *    - Arithmetic operations automatically unbox wrapper objects to primitives.
 *
 * Backend Working:
 * ----------------
 * - Integer boxedNum = 30;
 *   → Compiler internally translates to Integer.valueOf(30).
 *
 * - int result = boxedNum + 20;
 *   → Compiler internally translates to boxedNum.intValue() + 20.
 */
public class AutoboxingUnboxingExample {
	public static void main(String[] args) {
		// Example 1: Autoboxing (primitive → wrapper)
		// Input: 30 (primitive int)
		// Output: Integer object with value 30
		// 30 ---> [Autoboxing] ---> Integer.valueOf(30)
		Integer boxedNum = 30; 

		// Example 2: Unboxing during arithmetic operation (wrapper → primitive)
		// Input: Integer(30) + 20
		// Output: 50 (primitive int)
		// Integer(30) ---> [Unboxing: intValue()] ---> 30 ---> +20 ---> 50
		int result = boxedNum + 20; 

		System.out.println("Result: " + result);
	}
}
