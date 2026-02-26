//Iterate over the TreeMap and print key-value pairs in sorted order.
package com.paceup.Collections.Asse16;
import java.util.Map;
import java.util.TreeMap;

public class CollectionExample4 {

	public static void main(String[] args) {

		TreeMap<Integer, String> TM = new TreeMap<>();
		// TreeMap store data in sorted manner in hashmap no need to sort again
		
		TM.put(3, "Jarvis");
		TM.put(1, "Avengers");
		TM.put(7, "Vision");
		TM.put(4, "Loky");
		TM.put(6, "Thanos");
		TM.put(5, "Hulk");
		TM.put(2, "Iron");
		System.out.println("Key-Value pair in sorted order.");
		
		for (Map.Entry<Integer, String> entry : TM.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + "\t" + "Value: " + value);

		}

	}

}
