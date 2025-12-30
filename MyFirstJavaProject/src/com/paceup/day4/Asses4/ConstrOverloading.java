//Program with constructor overloading.

package com.paceup.day4.Asses4;

public class ConstrOverloading {

	ConstrOverloading(){ 
		System.out.println("Default Constructor called!");
	}
	
	ConstrOverloading(int a){
		System.out.println("a: " +a);
	}
	
	ConstrOverloading(int a, String name){
		System.out.println("a & name :"+a +"," + name);
	}
	
	public static void main(String[] args) {
		ConstrOverloading o1 = new ConstrOverloading();
		ConstrOverloading o2 = new ConstrOverloading(10);
		ConstrOverloading o3 = new ConstrOverloading(15, "JARVIS");

	}

}
