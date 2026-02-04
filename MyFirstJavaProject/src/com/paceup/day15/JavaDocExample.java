package com.paceup.day15;

import java.lang.annotation.*;

/*
 * @author Aishwarya
 * @version 1.0
 * */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyJavaDoc{
	String author();
	String version();
}

@MyJavaDoc(author = "Aishwarya", version = "1.0")
public class JavaDocExample {
	/**
	 * Displays a sample message
	 */
	public void show() {
		System.out.println("Inside JavaDocExample");
	}
}
