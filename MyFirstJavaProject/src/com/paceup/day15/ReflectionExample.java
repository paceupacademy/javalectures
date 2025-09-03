package com.paceup.day15;

import java.lang.reflect.Method;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface  MyAnnotationDoc{
	String author();
	String date();
}

class Person{
	private String name;
	public int age;
	
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
}

@MyAnnotationDoc(author = "Aishwarya", date ="02-09-2025")
public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String"); // loads class at runtime of anytype(wildcard-> <?>)
        Method[] methods = clazz.getDeclaredMethods(); //gets method name for each declared method regardless of access classifiers
        Method[] methods1 = clazz.getMethods(); //return public methods of class
        
        Person p = new Person("Aishwarya",30);
        Person p1 = new Person("Neha",35);
        Class<?> c=p.getClass();
        Field[] fields = c.getDeclaredFields(); // All declared fields (private and public)
        
        System.out.println("All fields of Person Class are: ");
        for (Field f : fields) {
        	f.setAccessible(true); //allow access to private variable
        	System.out.print("Name of field: "+f.getName());
        	System.out.print("\tValue for field: "+f.get(p) +"\n"); //gets value of variable for p(Person) object
        }
        
        Class<?> cl=p1.getClass();
        Field[] fields1 = cl.getDeclaredFields(); // All declared fields (private and public)
        
        System.out.println("All fields of Person Class are: ");
        for (Field f : fields1) {
        	f.setAccessible(true); //allow access to private variable
        	System.out.print("\nName of field: "+f.getName());
        	System.out.print("\tValue for field: "+f.get(p1) +"\n"); //gets value of variable for p(Person) object
        }
        
        System.out.println("\nAll Methods: ");
        for (Method method : methods) {
            System.out.print(method.getName()+ ", ");
        }
        System.out.println("\nPublic Methods: ");
        for(Method method1 : methods1) {
        	System.out.print(method1.getName() +", ");
        }
        
        Class<?> cls =  Class.forName("com.paceup.day15.Person");
        System.out.println("\n Constructors:");
        for(var constructor : cls.getDeclaredConstructors()) {
        	System.out.println(" "+constructor);
        }
    }
}

