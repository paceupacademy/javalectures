package com.paceup.day15;

//Custom Annotation
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Retention(RetentionPolicy.RUNTIME) //retain at runtime
@Target(ElementType.METHOD) //restricts annotation to methods only
@interface MyAnnotation {
	String value();
}

public class AnnotationExample {
	@MyAnnotation(value = "Hello, Annotation!")
	public void myMethod() {
		System.out.println("Method executed.");
	}

	public static void main(String[] args) throws Exception {
		AnnotationExample obj = new AnnotationExample();
		Method method = obj.getClass().getMethod("myMethod"); //get the method

		if (method.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class); //check if annotation is present
			System.out.println("Annotation Value: " + annotation.value()); //fetch and print the annotation value

		}
	}
}
