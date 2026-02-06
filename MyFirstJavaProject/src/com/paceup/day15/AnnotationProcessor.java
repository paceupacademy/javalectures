package com.paceup.day15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Get Class -> Get Methods -> Check Annotation -> Read Annoations metadata values -> Create Object -> Invoke method via Reflection
 */
public class AnnotationProcessor {
	public static void main(String[] args) {
		// .class gives the Classs object of AnnotatedClass
		Class<AnnotatedClass> obj = AnnotatedClass.class;

		/*
		 *  Check for class-level annotation 
		 *  Is "@MyAnnotationExample" applied on this AnnotatedClass
		 */
		if (obj.isAnnotationPresent(MyAnnotationExample.class)) { //check if annotation is present
			MyAnnotationExample annotation = obj.getAnnotation(MyAnnotationExample.class);
			/*
			 * This retrieves annotation metadata
			 */
			System.out.println("Class Annotation: " + annotation.value() + ", Priority: " + annotation.priority());
		}

////////////////////////////////////////////////////////////////////////////////////

		/*
		 * 1. Loop over all methods
		 * 2. Check if annotation is present
		 * 3. Loads annotation i.e. MyAnnotationExample -> annotation
		 * 3. Read annotation metadata
		 * 4. Print annotation metadata
		 * 5. Creating class object
		 * 6. Invoke annotated method dynamically
		 * 7. Handles reflection exceptions.
		 */
		// Check for method-level annotations
		for (Method method : obj.getDeclaredMethods()) {
			if (method.isAnnotationPresent(MyAnnotationExample.class)) {
				MyAnnotationExample annotation = method.getAnnotation(MyAnnotationExample.class);
				System.out.println("Method: " + method.getName() + ", Value: " + annotation.value() + ", Priority: " + annotation.priority());

				AnnotatedClass obj1 = new AnnotatedClass();
				//obj1.annotatedMethod();
				try {
					/*
					 * Invoking a method using reflection
					 * dynamically execution of methods at runtime using reflection.
					 * executing the method based on annotations w/o directly calling it in code 
					 * obj1.annotatedMethod()
					 */
					method.invoke(obj1);
				} catch (IllegalAccessException e) {
					/*
					 * Method is private or not accesible
					 */
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					/*
					 * Wrong arguments are passed
					 */
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					/*
					 * This wraps the actual exception thrown inside the method	
					 * Actual Exception : Arithmetic Exception
					 * Reflection throws : InvocationTargetException				
					 */
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
