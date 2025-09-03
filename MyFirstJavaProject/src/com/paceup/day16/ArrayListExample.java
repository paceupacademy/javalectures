package com.paceup.day16;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	
        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println(" Arraylist: "+list);

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(" Arraylist: "+list);
        
        list.add(2, "Orange");
        

        System.out.println(" Arraylist: "+list);
        
        // Accessing elements
        System.out.println("Last element: " + list.get(list.size()-1));

        // Removing an element
        list.remove("Orange");
        
        System.out.println(" Arraylist: "+list);

        // Iterating through the list
        for (String fruit : list) {
            System.out.print(fruit+" ");
        }
        
        System.out.println();
        ArrayList<String> extra = new ArrayList<>(Arrays.asList("Watermelon","Lemon","Guava"));
        list.addAll(extra);

     // Iterating through the list
        for (String fruit : list) {
        	System.out.print(fruit+" ");
        }
        System.out.println();
        System.out.println("ArrayList: "+list);
        // Checking size
        System.out.println("Size of the list: " + list.size());
        
        Field field = ArrayList.class.getDeclaredField("elementData");
        
        field.setAccessible(true);
        Object[] internalArray = (Object[]) field.get(list);
        
        System.out.println("Capacity: "+internalArray.length);
        
        //System.out.println(internalArray);
        
        for(Object obj:internalArray) {
        	System.out.print(obj+" ");
        }
        
        Collections.synchronizedList(list);
        
        System.out.println(list);
    }
}

