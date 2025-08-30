package com.paceup.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Wildcard means unknown type
public class UpperBoundWildcardExample {
    public static void printNumbers(List<? extends Number> list) { //UpperBound Wildcard
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void printList(List<?> list) { //Unbounded Wildcard
    	for (Object obj : list) { //iterates over each element by using Object class
    		System.out.print(obj + " ");
    	}
    	System.out.println();
    }
    //accepts a list of integer or its superclass
    public static void addNumbers(List<? super Integer> list) { //Lowerbound Wildcard
    	list.add(100);
    	list.add(300);
    	list.add(205);
    	
    	printList(list);
    }

    public static void main(String[] args) {
    	
    	//UperBound Wildcard
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        System.out.println("Printing using UpperBound");
        printNumbers(intList);
        printNumbers(doubleList);
        
        
        System.out.println("\nPrinting using Unbound");
        //Unbound Wildcard
        List<String> strList = Arrays.asList("Apple", "Banana", "Cherry");
        printList(strList);
        
        printList(intList);
        
        System.out.println("\n Printing using LowerBound");
        //LowerBoundWildcard
        List<Number> numList = new ArrayList<>(); //type Number(superclass of Integer)
        
        addNumbers(numList);
        if(numList.getFirst() instanceof Number) {
        	System.out.println("numList has Number elements\n");
        }
        
        List<Object> objList = new ArrayList<>(); //type Object <superclass)
        addNumbers(objList);
        if(objList.getFirst() instanceof Object) {
        	System.out.println("objList had Object elements");
        }
    }
       
}

// Object -> Number -> Integer
// Vehicle -> Car -> Sedan