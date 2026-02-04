package com.paceup.day15;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

//------------------ Inherited Annotation Example ------------------

//@Inherited allows subclasses to inherit annotations from their parent class.

@interface MyInterface {} // Custom annotation to declare an annotation type

@Hint("One")
@Hint("Two") // Class A is annotated
class A {}

class B extends A {} // Class B inherits annotation from A

//------------------ Repeatable Annotation Example ------------------

//@Repeatable allows multiple annotations of the same type on a single element.
@Inherited
@Target(ElementType.TYPE)
@Repeatable(Hints.class) //linking annotation to its Container
@interface Hint {
	String value();
}

//Container annotation to hold multiple @Hint annotations.
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Hints {
	Hint[] value(); //array of repeatable type It is okay if this writes @Hint more than once
}

/* Applying repeatable annotations
 * Equivalent to @Hints({@Hint("One"), @Hint("Two")}) => If you see multiple annotations wrap them all up and store them inside this Hints class
 */
@Hint("One")
@Hint("Two") 
class RepeatableExample {}

//------------------ Demo Class ------------------
public class MetaAnnotationExample {
	public static void main(String[] args) {
		// Demonstrate built-in annotations
		Personn p = new Personn();

		// Create sample lists
		List<String> list1 = new ArrayList<>();
		list1.add("abc");
		list1.add("xyz");

		List<String> list2 = new ArrayList<>();
		list2.add(null);
		list2.add("asjsadkjhd");

		// Call methods with annotations
		p.demo(); // Suppressed warning for deprecated method
		p.printAll(list1, list2); // Safe varargs usage

		// Reflection: Retrieve annotations at runtime
		Annotation[] ann = RepeatableExample.class.getAnnotations();
		System.out.println("\nAnnotations present on RepeatableExample class:");
		for (Annotation a : ann) {
			System.out.println("Annotation: " + a);
		}

		Annotation[] ann1 = B.class.getAnnotations();
		System.out.println("\n Annotations on B are:");
		for (Annotation a : ann1) {
			System.out.println("Annotation is "+a);
		}

		// Retrieve individual repeatable annotations
		Hint[] hints = RepeatableExample.class.getAnnotationsByType(Hint.class);
		System.out.println("\nIndividual @Hint annotations:");
		for (Hint h : hints) {
			System.out.println("Hint value: " + h.value());
		}
	}
}

