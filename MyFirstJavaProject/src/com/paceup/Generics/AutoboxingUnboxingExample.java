package com.paceup.Generics;

/**
 * AutoboxingUnboxingExample:
 * --------------------------
 * Demonstrates **Autoboxing** and **Unboxing** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Autoboxing**:
 *    - Automatic conversion of primitive types (int, double, etc.)
 *      into their corresponding wrapper class objects (Integer, Double, etc.).
 *    - Example: int → Integer.
 *
 * 2. **Unboxing**:
 *    - Reverse process: converting wrapper class objects back into primitives.
 *    - Example: Integer → int.
 *
 * 3. **Why Needed**:
 *    - Collections (like ArrayList, HashMap) can only store objects, not primitives.
 *    - Autoboxing allows primitives to be added directly without manual conversion.
 *    - Arithmetic operations automatically unbox wrapper objects to primitives.
 *
 * Backend Working:
 * ----------------
 * - `Integer boxedNum = 30;`
 *   → Compiler internally translates to `Integer boxedNum = Integer.valueOf(30);`
 *
 * - `int result = boxedNum + 20;`
 *   → Compiler internally translates to `int result = boxedNum.intValue() + 20;`
 *
 * Expected Output:
 * ----------------
 * Result: 50
 */
public class AutoboxingUnboxingExample {
    public static void main(String[] args) {
        // Example 1: Autoboxing (primitive → wrapper)
        Integer boxedNum = 30; // Compiler converts to Integer.valueOf(30)

        // Example 2: Unboxing during arithmetic operation (wrapper → primitive)
        int result = boxedNum + 20; // Compiler converts to boxedNum.intValue() + 20

        System.out.println("Result: " + result);
    }
}
