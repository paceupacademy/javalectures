package com.paceup.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generics Examples: ------------------ Theoretical Notes: ------------------
 * 1. Box1<T>: - Simple generic class with a single type parameter. - Provides
 * type safety for storing and retrieving values.
 *
 * 2. MyMap<K,V>: - Generic class with two type parameters (Key, Value). -
 * Mimics behavior of a key-value pair (like entries in a Map).
 *
 * 3. MyList<E>: - Generic class wrapping a List<E>. - Allows adding elements of
 * type E and printing them.
 *
 * 4. Calculator<N extends Number>: - Bounded generics: restricts type parameter
 * to subclasses of Number. - Ensures only numeric types can be used.
 *
 * 5. Pair1<T,U,V>: - Generic class with three type parameters. - Useful for
 * tuples, triples, or utility methods.
 *
 * Backend Working: ---------------- - Compiler replaces type parameters (T, K,
 * V, E, N, etc.) with actual types at compile time. - Provides type safety:
 * prevents runtime ClassCastException. - Eliminates need for explicit casting
 * when retrieving values.
 */
class Box1<T> {
	private T value;

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

class MyMap<K, V> {
	private K key;
	private V value;

	public MyMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

class MyList<E> {
	private List<E> names = new ArrayList<>();

	public void add(E item) {
		names.add(item);
	}

	public void print() {
		System.out.println("MyList: " + names);
	}
}

class Calculator<N extends Number> {
	public double square(N num) {
		return num.doubleValue() * num.doubleValue();
	}

	public double sum(N a, N b) {
		return a.doubleValue() + b.doubleValue();
	}
}

class Pair1<T, U, V> {
	private T first;
	private U second;
	private V third;

	public Pair1(T first, U second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public void print() {
		System.out.println("Pair1 -> T: " + first + ", U: " + second + ", V: " + third);
	}
}

public class GenericClass {
	public static void main(String[] args) {
		// Example 1: Box1<T>
		// Input: "Hello"
		// Output: "Hello"
		// "Hello" ---> [Box1<String>] ---> "Hello"
		Box1<String> box = new Box1<>();
		box.setValue("Hello");
		System.out.println("Box1 Value: " + box.getValue());

		// Example 2: MyMap<K,V>
		// Input: (1,"One")
		// Output: Key=1, Value="One"
		// (1,"One") ---> [MyMap<Integer,String>] ---> Key:1, Value:One
		MyMap<Integer, String> map = new MyMap<>(1, "One");
		System.out.println("MyMap -> Key: " + map.getKey() + ", Value: " + map.getValue());

		// Example 3: MyList<E>
		// Input: ["Alice","Bob"]
		// Output: MyList: [Alice, Bob]
		// ["Alice","Bob"] ---> [MyList<String>] ---> [Alice,Bob]
		MyList<String> myList = new MyList<>();
		myList.add("Alice");
		myList.add("Bob");
		myList.print();

		// Example 4: Calculator<N extends Number>
		// Input: 5
		// Output: 25.0
		// 5 ---> [Calculator.square()] ---> 25.0
		Calculator<Integer> calc = new Calculator<>();
		System.out.println("Square of 5: " + calc.square(5));

		// Input: (10,20)
		// Output: 30.0
		// (10,20) ---> [Calculator.sum()] ---> 30.0
		System.out.println("Sum of 10 and 20: " + calc.sum(10, 20));

		// Example 5: Pair1<T,U,V>
		// Input: ("Suraj",25,"Pune")
		// Output: Pair1 -> T: Suraj, U: 25, V: Pune
		// ("Suraj",25,"Pune") ---> [Pair1<String,Integer,String>] ---> Suraj,25,Pune
		Pair1<String, Integer, String> pair = new Pair1<>("Suraj", 25, "Pune");
		pair.print();
	}
}
