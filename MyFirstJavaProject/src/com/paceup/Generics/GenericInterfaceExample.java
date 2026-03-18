package com.paceup.Generics;

/**
 * GenericInterfaceExample:
 * ------------------------
 * Theoretical Notes:
 * ------------------
 * 1. Generic Interface:
 *    - Allows defining methods with type parameters (e.g., <T>, <K,V>).
 *    - Provides flexibility and type safety for different implementations.
 *
 * 2. Implementation (KeyValuePair<K,V>):
 *    - Implements the generic interface Pair<K,V>.
 *    - Stores key-value pairs of any type.
 *
 * 3. Advantages of Generic Interfaces:
 *    - Type safety: ensures consistent types for keys and values.
 *    - Reusability: one interface works for multiple data types.
 *    - Flexibility: can be implemented differently depending on requirements.
 *
 * Backend Working:
 * ----------------
 * - Compiler replaces type parameters with actual types at compile time.
 * - Example: Pair<String,Integer> → only String keys and Integer values allowed.
 * - Example: Pair<Integer,String> → only Integer keys and String values allowed.
 */
interface Pair<K, V> {
	K getKey();   // method to return key
	V getValue(); // method to return value
}

// Implementation of Generic Interface
class KeyValuePair<K, V> implements Pair<K, V> {
	private K key;
	private V value;

	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() { return key; }
	public V getValue() { return value; }
}

public class GenericInterfaceExample {
	public static void main(String[] args) {
		// Example 1: String key, Integer value
		// Input: ("Age", 25)
		// Output: Key: Age, Value: 25
		// ("Age",25) ---> [Pair<String,Integer>] ---> "Age,25"
		Pair<String, Integer> pair = new KeyValuePair<>("Age", 25);
		System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());

		// Example 2: Integer key, String value
		// Input: (2, "Alex")
		// Output: Id: 2, Name: Alex
		// (2,"Alex") ---> [Pair<Integer,String>] ---> "2,Alex"
		Pair<Integer, String> pair2 = new KeyValuePair<>(2, "Alex");
		System.out.println("Id: " + pair2.getKey() + ", Name: " + pair2.getValue());
	}
}
