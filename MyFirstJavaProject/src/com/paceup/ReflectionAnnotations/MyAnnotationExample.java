package com.paceup.ReflectionAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * MyAnnotationExample:
 * --------------------
 * Custom annotation definition with meta-annotations.
 *
 * Key Concepts:
 * -------------
 * 1. @Retention(RetentionPolicy.RUNTIME)
 *    - JVM retains annotation metadata at runtime.
 *    - Reflection APIs can read annotation values.
 *
 * 2. @Target({ElementType.METHOD, ElementType.TYPE})
 *    - Restricts usage of annotation to classes and methods.
 *
 * 3. Elements with Default Values:
 *    - `String value() default "Default Value"`
 *    - `int priority() default 1`
 *    - If no values are provided, defaults are used.
 *
 * Backend Working:
 * ----------------
 * - Compiler attaches annotation metadata to class/method.
 * - JVM retains metadata at runtime (because of RUNTIME policy).
 * - Reflection APIs (Class, Method) can retrieve annotation values.
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface MyAnnotationExample {
    String value() default "Default Value"; 
    int priority() default 1;               
}
