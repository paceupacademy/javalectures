//Implement a program that removes duplicates from list using HashSet.
package com.paceup.Collections.Asse16;

import java.util.*;

public class CollectionExample2 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(4);
		System.out.println("List before the Duplicate removes: " + list);
		// HasSet does not allowed the duplicate elements.
		HashSet<Integer> set = new HashSet<>(list);
		System.out.println("HashSet after removes duplicate: " + set);

	}

}
