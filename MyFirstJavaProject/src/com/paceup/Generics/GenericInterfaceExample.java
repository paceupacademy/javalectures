package com.paceup.Generics;

/**
 * GenericInterfaceExample:
 * ------------------------
 * Demonstrates how to define and implement a **Generic Interface** in Java.
 *
 * Key Concepts:
 * -------------
 * 1. **Generic Interface**:
 *    - Allows defining methods with type parameters (e.g., <T>, <K,V>).
 *    - Provides flexibility and type safety for different implementations.
 *
 * 2. **Implementation (KeyValuePair<K,V>)**:
 *    - Implements the generic interface Pair<K,V>.
 *    - Stores key-value pairs of any type.
 *
 * 3. **Advantages of Generic Interfaces**:
 *    - Type safety: ensures consistent types for keys and values.
 *    - Reusability: one interface works for multiple data types.
 *    - Flexibility: can be implemented differently depending on requirements.
 *
 * Backend Working:
 * ----------------
 * - `Pair<String, Integer> pair = new KeyValuePair<>("Age", 25);`
 *   → Compiler replaces K with String and V with Integer.
 *   → Ensures only String keys and Integer values are allowed.
 *
 * - `Pair<Integer, String> pair2 = new KeyValuePair<>(2, "Alex");`
 *   → Compiler replaces K with Integer and V with String.
 *   → Ensures only Integer keys and String values are allowed.
 *
 * Expected Output:
 * ----------------
 * Key: Age, Value: 25
 * Id: 2, Name: Alex
 */

// Generic Interface allows us to define methods using type parameters
interface Pair<K, V> {
    K getKey();   // method to return key
    V getValue(); // method to return value
}

// Implementation of Generic Interface
class KeyValuePair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) { // accepts any key-value pair and stores it
        this.key = key;
        this.value = value;
    }

    public K getKey() { // returns key of generic type
        return key;
    }

    public V getValue() { // returns value of generic type
        return value;
    }
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        // Example 1: String key, Integer value
        Pair<String, Integer> pair = new KeyValuePair<>("Age", 25);

        // Example 2: Integer key, String value
        Pair<Integer, String> pair2 = new KeyValuePair<>(2, "Alex");

        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        System.out.println("Id: " + pair2.getKey() + ", Name: " + pair2.getValue());
    }
}
