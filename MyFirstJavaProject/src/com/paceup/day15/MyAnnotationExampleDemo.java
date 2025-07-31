package com.paceup.day15;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

class Personn{
	@Deprecated
	public void oldMethod() {
		System.out.println("Deprecated Method Called!!!");
	}
	
	@SafeVarargs
	public static void printAll(List<String>...lists) {
		for(List<String> l:lists) {
			System.out.println(" "+l);
		}
	}
	@SuppressWarnings("deprecation")
	public void demo() {
		Personn p =  new Personn();
		p.oldMethod(); //Warning supressed
	}

	@FunctionalInterface
	interface Myfunc{
		void display(); //only one abstract method is allowed
	}

}
//Inherited Annotation Example
@Inherited
@interface MyInterface {} //superclass customised annotation automatically inherit

@MyInterface //Reflection
class A {}

class B extends A {} //Inheritance 

//Annotation Example Ended

//Repeatable Annotation Example
@Repeatable(Hints.class)
@interface Hint{ //Repeatable Annotation creation
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Hints{ //Container Annotation
	Hint[] value(); //Array to hold multiple hint annotation
}

@Hint("One")
@Hint("Two") //Use multiple annotations
class RepeatableExample{ //@Hints({ @Hint("One"), @Hint("Two")}) //Backend
}

public class MyAnnotationExampleDemo{
	public static void main(String[] args) {
		
		Personn p = new Personn();
		List<String> list1 = new ArrayList<String>();
		list1.add("abc");
		list1.add("xyz");
		p.demo();
		p.printAll(list1);
		
		Annotation[] ann = RepeatableExample.class.getAnnotations(); //gets all annotations present inside class
		for (Annotation a: ann) {
			System.out.println("Annotation: "+a);
		}

		Hint[] hints = RepeatableExample.class.getAnnotationsByType(Hint.class); //retrieve each individual @Hint annotation
		for(Hint h: hints) {
			System.out.println("Hint: " +h.annotationType());
			System.out.println("Hint value :" + h.value()); // Hint value : One
		}
	}
}
