package com.paceup.Generics;

/**
 * CustomizedGenericsExample:
 * --------------------------
 * Theoretical Notes:
 * ------------------
 * 1. Generics:
 *    - Allow classes, interfaces, and methods to operate on types specified at runtime.
 *    - Provide type safety (compile-time checking) and eliminate the need for casting.
 *
 * 2. Generic Class (Box<T>):
 *    - `T` is a type parameter (placeholder).
 *    - When creating an object, you specify the actual type (e.g., Box<String>, Box<Integer>).
 *
 * 3. Advantages of Generics:
 *    - Type safety: prevents runtime ClassCastException.
 *    - Code reusability: one class works for multiple data types.
 *    - Cleaner code: no explicit casting required.
 *
 * Backend Working:
 * ----------------
 * - Compiler replaces type parameters (T, K, V, etc.) with actual types at compile time.
 * - Example: Box<String> → compiler enforces only String values.
 * - Example: Box<Integer> → compiler enforces only Integer values.
 */
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
        // Input: "Hello Generics"
        // Output: "Hello Generics"
        // "Hello Generics" ---> [Box<String>] ---> "Hello Generics"
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Generics");
        System.out.println("String Box: " + stringBox.getItem());

        // Example 2: Using Box with Integer type
        // Input: 123
        // Output: 123
        // 123 ---> [Box<Integer>] ---> 123
        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println("Integer Box: " + intBox.getItem());
    }
}
