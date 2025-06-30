package com.paceup.day20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Student{
	Student(){
		System.out.println("Student created");
	}
}

public class LambdasWithCollections {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob", "David", "Arjun");

        //sorting using lambdas
        names.sort((a, b) -> a.compareTo(b));
        
        
        System.out.println(names);
        
        // Filter and print names starting with 'A'
        names.stream() //converts list to stream
        	 .map(String::toUpperCase) //Equivalent to name -> convert to upperCase //Intermediate Operation
             .filter(name -> name.startsWith("A")) //extract names starting with 'A' //Intermediated Operation
             .forEach(System.out::println); //prints each extracted name, (::) denotes method reference call //Terminal Operations
        	 
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        long evenCount = nums.stream()
        					  .filter(n->n%2 ==0) //Intermediate Operation
        					  .count(); //Terminal Operations
        
        System.out.println("Even numbers count: "+evenCount);
       
        
        Supplier<Student> con = Student::new; //Lambda Expression for constructor reference
        
       
        
    }
}

