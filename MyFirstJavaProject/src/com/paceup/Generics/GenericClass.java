package com.paceup.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generics Examples:
 * ------------------
 * Demonstrates different ways to use Generics in Java:
 *
 * 1. **Box1<T>**:
 *    - Simple generic class with a single type parameter.
 *    - Provides type safety for storing and retrieving values.
 *
 * 2. **MyMap<K,V>**:
 *    - Generic class with two type parameters (Key, Value).
 *    - Mimics behavior of a key-value pair (like entries in a Map).
 *
 * 3. **MyList<E>**:
 *    - Generic class wrapping a List<E>.
 *    - Allows adding elements of type E and printing them.
 *
 * 4. **Calculator<N extends Number>**:
 *    - Bounded generics: restricts type parameter to subclasses of Number.
 *    - Ensures only numeric types can be used.
 *
 * 5. **Pair1<T,U,V>**:
 *    - Generic class with three type parameters.
 *    - Useful for tuples, triples, or utility methods.
 *
 * Backend Working:
 * ----------------
 * - Compiler replaces type parameters (T, K, V, E, N, etc.) with actual types at compile time.
 * - Provides type safety: prevents runtime ClassCastException.
 * - Eliminates need for explicit casting when retrieving values.
 *
 * Expected Output:
 * ----------------
 * Box1 Value: Hello
 * MyMap -> Key: 1, Value: One
 * MyList: [Alice, Bob]
 * Square of 5: 25.0
 * Sum of 10 and 20: 30.0
 * Pair1 -> T: Suraj, U: 25, V: Pune
 */

// Generic class with single type parameter
class Box1<T> {
    private T value;

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// Generic class with two type parameters
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

// Generic class wrapping a List
class MyList<E> {
    private List<E> names = new ArrayList<>();

    public void add(E item) {
        names.add(item);
    }

    @Override
    public String toString() {
        return names.toString();
    }
}

// Bounded generics: restricts type to subclasses of Number
class Calculator<N extends Number> {
    public double square(N num) {
        return num.doubleValue() * num.doubleValue();
    }

    public double add(N a, N b) {
        return a.doubleValue() + b.doubleValue();
    }
}

// Generic class with three type parameters (like a tuple/triple)
class Pair1<T, U, V> {
    private T t;
    private U u;
    private V v;

    public Pair1(T first, U second, V third) {
        this.t = first;
        this.u = second;
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
}

// Demo class
public class GenericClass {
    public static void main(String[] args) {
        // Box1 Example
        Box1<String> box = new Box1<>();
        box.setValue("Hello");
        System.out.println("Box1 Value: " + box.getValue());

        // MyMap Example
        MyMap<Integer, String> map = new MyMap<>(1, "One");
        System.out.println("MyMap -> Key: " + map.getKey() + ", Value: " + map.getValue());

        // MyList Example
        MyList<String> list = new MyList<>();
        list.add("Alice");
        list.add("Bob");
        System.out.println("MyList: " + list);

        // Calculator Example
        Calculator<Integer> calc = new Calculator<>();
        System.out.println("Square of 5: " + calc.square(5));
        System.out.println("Sum of 10 and 20: " + calc.add(10, 20));

        // Pair1 Example
        Pair1<String, Integer, String> pair = new Pair1<>("Suraj", 25, "Pune");
        System.out.println("Pair1 -> T: " + pair.getT() + ", U: " + pair.getU() + ", V: " + pair.getV());
    }
}
