package com.paceup.day20;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Greet{
	private String name;
	Greet(String name){
		this.name =  name;
	}
	public String greet() {
		return "Hello "+name;
	}
}

public class MethodReferenceExample {
	/****Static Method ***/
	public static void main(String[] args) {
		Function<Integer,String> f = Integer::toHexString; //x->Integer.toHexString(x)
		System.out.println("Integer to HexString for 255:"+f.apply(255)); //ff
		
		/*** Bound Instance Method ***/
		Greet g = new Greet("Neha");
		Supplier<String> s = g::greet;
		System.out.println(s.get());
		
		/*** Unbound Instance Method ***/
		
		Function<String,Integer> len = String::length;
		
		System.out.println("Length of Java: "+len.apply("Java"));
		List<String> names = Arrays.asList("Neha","Ananaya","PUJA","akash","AKASH");
		Comparator<String> sample = String::compareToIgnoreCase;
		names.sort(sample);
		System.out.println(names);
		
		/*** Constructor Array Constructor***/
		
		Supplier<List<String>> newList = ArrayList::new; // ()->new ArrayList()
		Function<Integer, int[]> makeIntArray = int[]::new; // n-> new int[n]
		
		List<String> id = List.of("101", "102","103","104");
		Function<String, Integer> toInt = Integer::valueOf;
		List<Integer> ints =  id.stream()
								.map(toInt)
								.toList();
		System.out.println(ints);
	}
	

	/*PrintStream out = System.out;
	Consumer<String> printer1 = out::println; //s->out.println(s);
	printer1.accept("Hello");*/
	
	
}
