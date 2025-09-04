package com.paceup.day16;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VectorExample {
    public static void main(String[] args) {
        // Create a Vector
        Vector<String> vector = new Vector<>(); //maintains order and synchronized, allows duplicates

        // Add elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        vector.add("Banana");
        vector.add("Orange");
        vector.add("Banana");
        vector.add("Lemons");
        vector.add("Banana");

        // Access elements
        System.out.println("First Element: " + vector.get(0));

        int index =  vector.indexOf("Banana");
        System.out.println("Banana is at "+ index);
        
        int lastindex = vector.lastIndexOf("Banana");
        System.out.println("Banana last index is "+lastindex);
        
        int i =0;
        // Iterate through the Vector
        for (String fruit : vector) {
            System.out.print(fruit+", ");
            
            if(vector.get(i).equals("Banana")) {
            	System.out.println("Index of Banana is : "+i);            	
            }
			i++;
        }
        
        //Using Streams Java 8
        List<Integer> indexval = IntStream.range(0, vector.size())
        		.filter(j->"Banana".equals(vector.get(j)))
        		.boxed()
        		.collect(Collectors.toList());
        
        System.out.println("Index of Banana "+indexval);
        System.out.println("size of vector is : " +vector.size() );
        System.out.println("Capacity of vector is: "+ vector.capacity());

        // Remove an element
        vector.remove("Banana");
        System.out.println("After Removal: " + vector);
        
    }
}

