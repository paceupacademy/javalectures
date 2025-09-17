package com.paceup.day22;

import java.util.ArrayList;
import java.util.List;

class Box1<T>{
	private T value;

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}

class MyMap<K,V>{
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

class MyList<E>{
	private List<E> names =  new ArrayList<>();
	public void add(E item) {
		names.add(item);
	}
	
	@Override
	public String toString() {
		return names.toString();
	}
}

class Calculator<N extends Number>{
	public double square(N num) {
		return num.doubleValue() * num.doubleValue();
	}
	
	public double add(N a, N b) {
		return a.doubleValue() + b.doubleValue();
	}
}


//Used in Pair, Triple,Tuple, Utility methods
class Pair1<T,U, V>{
	private T t;
	private U u;
	private V v;
	
	public Pair1(T first, U second, V third){
		this.t=first;
		this.u=second;
		this.v = third;
	}
	
	public T getT() {
		return this.t;
	}
	public U getU() {
		return this.u;
	}
	public V getV() {
		return this.v;
	}
	public void setT(T t) {
		this.t = t;
	}
	public void setU(U u) {
		this.u = u;
	}
	public void setV(V v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "(" +t+ ", "+u+", "+v+")";
	}
}
public class GenericClass {

	public static void main(String[] args) {
		Box1<String> stringBox = new Box1<>();
		stringBox.setValue("Hello Generics");
		System.out.println("Message is: "+stringBox.getValue());
		
		Box1<Integer> intBox = new Box1<>();
		intBox.setValue(123);
		System.out.println("Value is: "+intBox.getValue());
		
		MyMap<Integer,String> entry = new MyMap(1, "One");
		System.out.println("Key is "+entry.getKey()+ " Value is "+entry.getValue());

		MyList<String> listData =  new MyList<>();
		listData.add("Aishwarya");
		listData.add("Neha");
		listData.add("Puja");
		
		System.out.println("Names are: "+listData);
		
		Calculator<Integer> intCalc = new Calculator<>();
		System.out.println("Square of 5 = "+intCalc.square(5));
		System.out.println("Sum = "+intCalc.add(5, 10));
		
		Calculator<Double> doubleCalc =  new Calculator<>();
		System.out.println("Square of 3.4 = "+doubleCalc.square(3.4));
		System.out.println("Sum = "+doubleCalc.add(5.6, 87454.3874093));
		
		Pair1<String, Integer, Double> data = new Pair1<>("Score", 5, 88.567);
		System.out.println("Data is "+data);
	}

}

/****
 *   |Box<T>|
 *   |______|
 *   |value |
 *   |------|
 *   |set(T)|
 *   |get() |
 *   --------
 * Box<String> -> T=String 
 * Box<Integer> -> T=Integer
*/