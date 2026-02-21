package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * CombinedExample:
 * ----------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Custom Annotation (@interface)**:
 *    - Defined using @interface.
 *    - Can have elements with default values.
 *    - Example: `String info() default "Default Info";`
 *
 * 2. **Meta-Annotations**:
 *    - @Retention(RetentionPolicy.RUNTIME) → annotation available at runtime.
 *    - @Target(ElementType.METHOD) → restricts usage to methods only.
 *
 * 3. **Default Values**:
 *    - If no value is provided, the default is used.
 *    - Example: `@Test` → will use `"Default Info"`.
 *
 * 4. **Reflection**:
 *    - Used to inspect annotations at runtime.
 *    - Steps:
 *      a) Get Class object.
 *      b) Retrieve Method object.
 *      c) Check if annotation is present.
 *      d) Read annotation metadata.
 *      e) Invoke method dynamically.
 *
 * Use Cases:
 * ----------
 * - Testing frameworks (JUnit uses @Test).
 * - Custom metadata-driven logic.
 * - Declarative programming with annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    String info() default "Default Info"; // Default value if none is provided
}

public class CombinedExample {
    // Annotated method with custom value
    @Test(info = "Test Method Annotation")
    public void testMethod() {
        System.out.println("Testing...");
    }

    // Annotated method without passing value (uses default)
    @Test
    public void defaultAnnotatedMethod() {
        System.out.println("Default Annotation Method...");
    }

    public static void main(String[] args) throws Exception {
        CombinedExample obj = new CombinedExample();

        // Process all methods of the class
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                System.out.println("\nMethod: " + method.getName());
                System.out.println("Annotation Info: " + annotation.info());

                // Invoke method via reflection
                method.invoke(obj);
            }
        }
    }
}
