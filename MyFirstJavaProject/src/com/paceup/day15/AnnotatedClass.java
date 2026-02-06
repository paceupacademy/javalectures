package com.paceup.day15;
/*
 * These values  become metadata attached to class
 */
@MyAnnotationExample(value = "Class Annotation", priority = 5)
public class AnnotatedClass {
	/*
	 * JVM keeps annotation metadata available
	 */
    @MyAnnotationExample(value = "Method Annotation", priority = 2)
    public void annotatedMethod() {
        System.out.println("This method is annotated!");
    }
}
