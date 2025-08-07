package com.paceup.day16;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
	
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        System.out.println("Set is Empty: "+set.isEmpty()); //Checks if the set is empty.
       
        
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate, won't be added
        System.out.println(set); // Output: [Apple, Banana]
        
        set.remove("Apple");
        System.out.println(set);
        
        System.out.println(set.contains("Dog")); 
        set.add("Apple");
        set.add("Lemons");
        set.add("Watermelon");
        set.add("Cherry");
        
        System.out.println("Size of set is : "+set.size());
        System.out.println("Set is Empty: "+set.isEmpty()); //Checks if the set is empty.
        
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
        set.clear(); //Removes all elements from the set.
        System.out.println("\n"+set); // Output: []
    }
}

