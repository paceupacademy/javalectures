package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * MyJavaDoc Annotation Example:
 * -----------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Custom Annotation (@interface)**:
 *    - Defined using @interface.
 *    - Can have multiple elements (like author, version).
 *
 * 2. **Meta-Annotations**:
 *    - @Documented → Marks annotation for inclusion in Javadoc.
 *    - @Retention(RetentionPolicy.RUNTIME) → Annotation available at runtime.
 *    - @Target → Specifies where annotation can be applied (TYPE, METHOD).
 *
 * 3. **Use Cases**:
 *    - Documentation metadata (author, version, description).
 *    - Frameworks can read these values via reflection.
 *    - Helps in maintaining code history and ownership.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyJavaDoc {
    String author();
    String version();
}

// Example usage of custom annotation
@MyJavaDoc(author = "Aishwarya", version = "1.0")
public class JavaDocExample {

    @MyJavaDoc(author = "Suraj", version = "2.0")
    public void annotatedMethod() {
        System.out.println("Executing annotated method...");
    }

    public static void main(String[] args) throws Exception {
        // Reflection to read annotation metadata
        Class<JavaDocExample> clazz = JavaDocExample.class;

        // Class-level annotation
        if (clazz.isAnnotationPresent(MyJavaDoc.class)) {
            MyJavaDoc annotation = clazz.getAnnotation(MyJavaDoc.class);
            System.out.println("Class Annotation -> Author: " + annotation.author() +
                               ", Version: " + annotation.version());
        }

        // Method-level annotation
        Method method = clazz.getMethod("annotatedMethod");
        if (method.isAnnotationPresent(MyJavaDoc.class)) {
            MyJavaDoc annotation = method.getAnnotation(MyJavaDoc.class);
            System.out.println("Method Annotation -> Author: " + annotation.author() +
                               ", Version: " + annotation.version());
        }

        // Invoke method
        new JavaDocExample().annotatedMethod();
    }
}
