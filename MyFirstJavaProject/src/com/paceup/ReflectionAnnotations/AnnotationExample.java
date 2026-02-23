package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * AnnotationExample:
 * ------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Custom Annotation**:
 *    - Defined using @interface.
 *    - Can have elements (like value, priority).
 *    - Can be restricted to specific targets (class, method, field).
 *
 * 2. **Meta-Annotations**:
 *    - @Documented → Marks annotation for inclusion in Javadoc.
 *    - @Retention → Specifies how long annotation is retained:
 *        - SOURCE: discarded during compilation.
 *        - CLASS: retained in bytecode but not available at runtime.
 *        - RUNTIME: retained in bytecode and available at runtime via reflection.
 *    - @Target → Specifies where annotation can be applied (method, class, field).
 *
 * 3. **Reflection**:
 *    - Annotations can be accessed at runtime using reflection APIs.
 *    - Example: Class.getMethods(), Method.getAnnotation().
 *
 * Use Cases:
 * ----------
 * - Frameworks (Spring, Hibernate) use annotations for configuration.
 * - Custom annotations can be used for logging, validation, or metadata.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime
@Target(ElementType.METHOD)         // Restricts annotation to methods only
@interface MyAnnotation {
    String value(); // Annotation element
}

public class AnnotationExample {
    // Annotated method
    @MyAnnotation(value = "Custom Method Annotation")
    public void myMethod() {
        System.out.println("Executing myMethod...");
    }

    public static void main(String[] args) throws Exception {
        // Using reflection to access annotation metadata
        Method method = AnnotationExample.class.getMethod("myMethod");

        // Check if annotation is present
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value: " + annotation.value());
        }

        // Execute method
        new AnnotationExample().myMethod();
    }
}
