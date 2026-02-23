package com.paceup.Generics;

/**
 * UnboxingExample:
 * ----------------
 * Demonstrates **Unboxing** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Autoboxing**:
 *    - Automatic conversion of primitive types (int, double, etc.)
 *      into their corresponding wrapper class objects (Integer, Double, etc.).
 *
 * 2. **Unboxing**:
 *    - Reverse process: converting wrapper class objects back into primitives.
 *    - Example: Integer → int.
 *
 * 3. **Why Needed**:
 *    - Arithmetic operations require primitives.
 *    - Collections store wrapper objects, so unboxing allows direct use in calculations.
 *
 * Backend Working:
 * ----------------
 * - `Integer boxedNum = 20;`
 *   → Compiler internally translates to `Integer boxedNum = Integer.valueOf(20);`
 *
 * - `int result = boxedNum + 10;`
 *   → Compiler internally translates to `int result = boxedNum.intValue() + 10;`
 *   → Unboxing occurs automatically when using wrapper objects in arithmetic.
 *
 * Expected Output:
 * ----------------
 * Unboxed Value: 30
 */
public class UnboxingExample {
    public static void main(String[] args) {
        // Example 1: Autoboxing (primitive → wrapper)
        Integer boxedNum = 20; // Compiler converts to Integer.valueOf(20)

        // Example 2: Unboxing during arithmetic operation (wrapper → primitive)
        int result = boxedNum + 10; // Compiler converts to boxedNum.intValue() + 10

        System.out.println("Unboxed Value: " + result);
    }
}
