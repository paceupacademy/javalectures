package com.paceup.Generics;

/**
 * CustomizedGenericsExample:
 * --------------------------
 * Demonstrates how to create and use a **Generic Class** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Generics**:
 *    - Allow classes, interfaces, and methods to operate on types specified at runtime.
 *    - Provide type safety (compile-time checking) and eliminate the need for casting.
 *
 * 2. **Generic Class (Box<T>)**:
 *    - `T` is a type parameter (placeholder).
 *    - When creating an object, you specify the actual type (e.g., Box<String>, Box<Integer>).
 *
 * 3. **Advantages of Generics**:
 *    - Type safety: prevents runtime ClassCastException.
 *    - Code reusability: one class works for multiple data types.
 *    - Cleaner code: no explicit casting required.
 *
 * Backend Working:
 * ----------------
 * - `Box<String> stringBox = new Box<>();`
 *   → Compiler replaces `T` with `String` for this object.
 *   → Ensures only String values can be stored/retrieved.
 *
 * - `Box<Integer> intBox = new Box<>();`
 *   → Compiler replaces `T` with `Integer`.
 *   → Ensures only Integer values can be stored/retrieved.
 *
 * Expected Output:
 * ----------------
 * String Box: Hello Generics
 * Integer Box: 123
 */

// Generic Class
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class CustomizedGenericsExample {
    public static void main(String[] args) {
        // Example 1: Using Box with String type
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Generics");
        System.out.println("String Box: " + stringBox.getItem());

        // Example 2: Using Box with Integer type
        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println("Integer Box: " + intBox.getItem());
    }
}
