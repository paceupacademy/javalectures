//1 Create a program to store student names using an ArrayList and sort them.
package com.paceup.Collections.Asse16;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionExample1 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();

		list.add("Ravi");
		list.add("Aasha");
		list.add("Disha");
		list.add("Aarya");

		Collections.sort(list);
		System.out.println("Name List: " + list);
	}

}
