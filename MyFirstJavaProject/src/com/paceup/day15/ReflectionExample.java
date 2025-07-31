package com.paceup.day15;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

class Person{
	private String name = "Aishwarya";
	public int age = 30;
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String"); // loads class at runtime of anytype(wildcard-> <?>)
        Method[] methods = clazz.getDeclaredMethods(); //gets method name for each declared method regardless of access classifiers
        Method[] methods1 = clazz.getMethods(); //return public methods of class
        
        Person p = new Person();
        Class<?> cl=p.getClass();
        Field[] fields = cl.getDeclaredFields(); // All declared fields (private and public)
        
        System.out.println("All fields of Person Class are: ");
        for (Field f : fields) {
        	f.setAccessible(true); //allow access to private variable
        	System.out.print("Name of field: "+f.getName());
        	System.out.print("\tValue for field: "+f.get(p) +"\n"); //gets value of variable for p(Person) object
        }
        
        System.out.println("\nAll Methods: ");
        for (Method method : methods) {
            System.out.print(method.getName()+ ", ");
        }
        System.out.println("\nPublic Methods: ");
        for(Method method1 : methods1) {
        	System.out.print(method1.getName() +", ");
        }
        
    }
}

