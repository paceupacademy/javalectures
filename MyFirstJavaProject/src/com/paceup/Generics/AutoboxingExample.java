package com.paceup.Generics;

import java.util.ArrayList;

/**
 * AutoboxingExample:
 * ------------------
 * Demonstrates **Autoboxing** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Autoboxing**:
 *    - Automatic conversion of primitive types (int, double, etc.)
 *      into their corresponding wrapper class objects (Integer, Double, etc.).
 *    - Introduced in Java 5 to simplify code.
 *
 * 2. **Unboxing**:
 *    - Reverse process: converting wrapper class objects back into primitives.
 *    - Example: Integer obj = 10; int num = obj; // unboxing
 *
 * 3. **Why Needed**:
 *    - Collections (like ArrayList, HashMap) can only store objects, not primitives.
 *    - Autoboxing allows primitives to be added directly without manual conversion.
 *
 * Backend Working:
 * ----------------
 * - `int num = 10; Integer boxedNum = num;`
 *   → Compiler internally translates to `Integer boxedNum = Integer.valueOf(num);`
 *
 * - `numbers.add(5);`
 *   → Compiler internally translates to `numbers.add(Integer.valueOf(5));`
 *
 * - When retrieving values, unboxing occurs automatically:
 *   → `int x = numbers.get(0);` internally becomes `int x = numbers.get(0).intValue();`
 *
 * Expected Output:
 * ----------------
 * Autoboxed List: [5, 15]
 */
public class AutoboxingExample {
    public static void main(String[] args) {
        // Example 1: Autoboxing primitive to wrapper
        int num = 10;
        Integer boxedNum = num; // Compiler converts to Integer.valueOf(num)
        System.out.println("Boxed Number: " + boxedNum);

        // Example 2: Adding primitives to a collection (requires objects)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);  // Autoboxing: int → Integer
        numbers.add(15); // Autoboxing: int → Integer

        System.out.println("Autoboxed List: " + numbers);

        // Example 3: Unboxing (wrapper → primitive)
        int firstElement = numbers.get(0); // Compiler converts to numbers.get(0).intValue()
        System.out.println("Unboxed First Element: " + firstElement);
    }
}
