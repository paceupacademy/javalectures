package com.paceup.day15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.lang.annotation.*;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retention policy: runtime
@Target({ElementType.METHOD, ElementType.TYPE}) // Applicable to methods and classes
public @interface MyAnnotationExample {
    String value() default "Default Value"; // Element with a default value
    int priority() default 1;              // Another element
}