//4. Read annotation values at runtime using reflection.
package com.paceup.ReflectionAnnotations.Asses15;

@AssesAnnotation(age = 25, name = "JARVIS")
class AnnotatedClass {
}

public class ReadValueRuntime {

	public static void main(String[] args) {
		Class<?> clazz = AnnotatedClass.class; // get the class object

		if (clazz.isAnnotationPresent(AssesAnnotation.class)) // check annotation present or not
		{
			AssesAnnotation AA = clazz.getAnnotation(AssesAnnotation.class); // retrive the annotation instance

			System.out.println("Name: " + AA.name());
			System.out.println("Age: " + AA.age());
		} else {
			System.out.println("Annotation not found at runtime.");
		}
	}

}
