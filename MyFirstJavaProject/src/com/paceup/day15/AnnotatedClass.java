package com.paceup.day15;

@MyAnnotationExample(value = "Custom Annotation Example", priority = 5)
public class AnnotatedClass {

    @MyAnnotationExample(value = "Method Annotation", priority = 2)
    public void annotatedMethod() {
        System.out.println("This method is annotated!");
    }
}
