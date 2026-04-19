package com.paceup.Collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

class Person{
	int age;
	String name;
	Person(int age, String name){
		this.age= age;
		this.name=name;
	}
	
	@Override
	public String toString(){
		return "Age= "+this.age+" Name= "+this.name;
		
	}
}
public class ArrayListExample {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	
    	List<Person> list1 = new ArrayList<>(); //valid
    	
    	Person p1 = new Person(23,"Raj");
    	Person p2 =  new Person(25,"Sima");
    	list1.add(p1);
    	list1.add(p2);
    	System.out.println("List of Persons: \n"+list1);
    	
    	//List<> l =  new List(); //invalid
    	
        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println(" Arraylist: "+list);

        /*
         * Elements are stored in the order they are inserted => Maintaining Order
         *  Adding elements 
         */
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(" Arraylist: "+list);
        list.add("Watermelon");
        list.add(2, "Orange");
        

        System.out.println(" Arraylist: "+list);
        
        // Accessing elements
        System.out.println("Last element: " + list.get(list.size()-1));

        // Removing an element
        boolean result = list.remove("Orange");
        
        System.out.println(" Arraylist: "+list+ " Orange is removed?"+result);
        
        System.out.println("Size of arraylist: " + list.size());
        
        list.add("Guava");
        System.out.println("Last element: " + list.get(list.size()-1));
        // Iterating through the list
        for (String fruit : list) {
        	if(fruit.equals("Guava")) {
            System.out.print(fruit+" ");
        	}
        }
        
        System.out.println();
        
        //[Watermelon, Lemon, Guava]
        ArrayList<String> extra = new ArrayList<>(Arrays.asList("Watermelon","Lemon","Guava","Chikoo","Berries","Jamun","Lemon","Grapes"));
        System.out.println("\nExtra \n"+extra);
        list.addAll(extra);

     // Iterating through the list
        for (Object fruit : list) {
        	System.out.print(fruit+" ");
        }
        System.out.println();
        System.out.println("ArrayList: "+list);
        // Checking size
        System.out.println("Size of the list: " + list.size());
        list.add("abc");
        list.add("xyz");
        list.add("1");
        
        System.out.println("Size of the list: " + list.size());
        Field field = ArrayList.class.getDeclaredField("elementData");
        
        field.setAccessible(true);
        Object[] internalArray = (Object[]) field.get(list);
        
        /*
         * When 11th element is added to ArrayList 
         * Capacity increases using formula
         * newCapacity = oldCapacity + (oldCapacity/2) => 10 + 10/2
         * newCapacity = 10+5 =15
         * when we are adding 16th element
         * newcapacity = 15 + (15/2) = 22
         */
        System.out.println("Capacity: "+internalArray.length);
        
        //System.out.println(internalArray);
        
        
        
        for(Object obj:internalArray) {
        	System.out.print(obj+" ");
        }
        System.out.println();
        
        //to make it thread safe
        Collections.synchronizedList(list);
        
        System.out.println(list);
    }
}

