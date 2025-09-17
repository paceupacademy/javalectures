package com.paceup.day22;

//Generic Interface allows us to define methods using type of parameters like <T>, <K,V> 
interface Pair<K, V> {
	K getKey(); // method to return key

	V getValue(); // method to return value
}

//Implementation of Generic Interface
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
		Pair<String, Integer> pair = new KeyValuePair<>("Age", 25);
		Pair<Integer, String> pair2 = new KeyValuePair(2, "Alex");
		System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
		System.out.println("Id: " + pair2.getKey() + ", Name: " + pair2.getValue());
	}
}
