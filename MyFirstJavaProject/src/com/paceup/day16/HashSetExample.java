package com.paceup.day16;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println("Set is Empty: "+set.isEmpty()); //Checks if the set is empty.
        
        set.add("Apple");
        set.add("Banana");
        
        System.out.println("Size of Set is "+set.size()); // Returns the number of elements in the set.
        
        set.add("Apple"); // Duplicate, won't be added
        System.out.println(set); // Output: [Apple, Banana]
        
        set.remove("Apple"); //Removes the specified element from the set if it is present.
        System.out.println(set); // Output: [Banana] 
        
        System.out.println(set.contains("Apple")); // Checks if the set contains the specified element.
        System.out.println(set.contains("Mango")); // Output: false
        
        System.out.println("Set is Empty: "+set.isEmpty()); // Checks if the set is empty.
        
        set.add("Lemon");
        set.add("Mango");
        
        Iterator<String> iterator = set.iterator(); //Returns an iterator over the elements in the set.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        set.clear(); //Removes all elements from the set.
        System.out.println(set); // Output: []
    }
}

