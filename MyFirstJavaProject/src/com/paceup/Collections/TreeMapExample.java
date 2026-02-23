package com.paceup.Collections;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 
 * TreeMap:
 * - Implements NavigableMap → SortedMap → Map.
 * - Stores key-value pairs in sorted order of keys (natural ordering or custom comparator).
 * - Does not allow null keys (throws NullPointerException).
 * - Allows multiple null values.
 * - Backed internally by a Red-Black Tree (self-balancing binary search tree).
 * 
 * Internal Working:
 * -----------------
 * - Each entry is stored as a node in a Red-Black Tree.
 * - Keys are sorted according to natural order (Comparable) or a provided Comparator.
 * - Operations like put(), get(), remove() take O(log n) due to tree balancing.
 * 
 * Navigation Methods:
 * -------------------
 * - lowerKey(k): Greatest key < k
 * - floorKey(k): Greatest key ≤ k
 * - ceilingKey(k): Smallest key ≥ k
 * - higherKey(k): Smallest key > k
 * 
 * Representation Example:
 * -----------------------
 * TreeMap<Integer, String> map = {1=Banana, 2=Cherry, 3=Apple}
 * Internally (sorted by key):
 *            (2, Cherry)
 *           /           \
 *   (1, Banana)       (3, Apple)
 */

class StudentMap{
	int rollno;
	String name, address;
	
	public StudentMap(int rollno, String name, String address) {
		this.rollno =  rollno;
		this.name =  name;
		this.address =  address;
	}
	
	public String toString() {
		return this.rollno+" "+this.name+" "+this.address;
	}
	
}
//Comparator class
class SortByRollNo implements Comparator<StudentMap>{
	
	public int compare (StudentMap a, StudentMap b) {
		return Integer.compare(a.rollno, b.rollno);
	}
}

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        // Adding key-value pairs (keys auto-sorted)
        map.put(3, "Apple");
        map.put(1, "Banana");
        map.put(2, "Cherry");

        // Displaying the TreeMap (keys sorted)
        System.out.println("TreeMap: " + map);

        // Accessing elements
        System.out.println("Value for key 2: " + map.get(2));
        
        // Adding more entries (null values allowed, null key not allowed)
        map.put(4, null);
        map.put(6, "Watermelon");
        map.put(7, null);
        map.put(5, "Lemons");
        
        System.out.println("After adding more entries: " + map);
        
        //TreeMap using Comparator
        TreeMap<StudentMap, Integer> tm = new TreeMap<>(new SortByRollNo());
        tm.put(new StudentMap(111, "Aishwarya", "Pune"), 1);
        tm.put(new StudentMap(110, "Shraddha", "Mumbai"), 3);
        tm.put(new StudentMap(112, "Raj", "Delhi"), 2);
        System.out.println("TreeMap of Students by rollNo:\n"+tm);
        

        // Removing an element using corresponding key
        map.remove(1);
        System.out.println("After removal: " + map);

        // Navigation methods
        System.out.println("Greatest key < 5: " + map.lowerKey(5));
        System.out.println("Floor key ≤ 5: " + map.floorKey(5));
        System.out.println("Ceiling key ≥ 5: " + map.ceilingKey(5));
        System.out.println("Higher key > 5: " + map.higherKey(5));
        
        // Entry methods
        System.out.println("\nEntry Methods:");
        System.out.println("SubMap (2 to 7): " + map.subMap(2, true, 7, false));
        System.out.println("Descending Map: " + map.descendingMap());
        System.out.println("Polling First Entry: " + map.pollFirstEntry());
        System.out.println("Map after pollFirstEntry: " + map);
        System.out.println("First Entry: " + map.firstEntry()); //lowest
        System.out.println("Head Map: "+map.headMap(6));
    }
}
