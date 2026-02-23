//2. Create and apply a custom annotation @Developer with name and date fields.
package com.paceup.day15.Asses15;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // retain at runtime
@Target(ElementType.METHOD) // restricts annotation to methods only
@interface MyAnnotationAsse {
	String name();
	String date();
}

public class Developer {

	@MyAnnotationAsse(name = "Iron Man", date = "23-Feb-2026") // custom annotation called
	public void AnnotationMethod() {
		System.out.println("Method executed");
	}

	public static void main(String[] args) throws Exception {
		Developer d = new Developer(); // object of class
		Method method = d.getClass().getMethod("AnnotationMethod"); // get the method using reflection

		if (method.isAnnotationPresent(MyAnnotationAsse.class)) {
			MyAnnotationAsse MA = method.getAnnotation(MyAnnotationAsse.class); // check if annotation present or not
			System.out.println("Developer Name: " + MA.name() + "\nToday's Date: " + MA.date());
		}

	}

}
