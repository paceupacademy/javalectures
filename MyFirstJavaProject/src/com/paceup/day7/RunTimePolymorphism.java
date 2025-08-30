package com.paceup.day7;

import java.lang.reflect.Method;

class Animal {
    void sound() throws Exception {
        System.out.println("Animal makes a sound");
    }
    private void display() {
    	System.out.println("Display Called!");
    }
}

class Dog extends Animal {
    @Override
    void sound() throws Exception {
        System.out.println("Dog barks");
        Class<?> clazz = Class.forName("com.paceup.day7.Animal"); // loads class at runtime of anytype(wildcard-> <?>)
        Method[] methods = clazz.getDeclaredMethods(); 
        for (Method method : methods) {
            System.out.print(method.getName()+ ", ");
            if(method.getName().equalsIgnoreCase("display")) {
            	method.setAccessible(true);
            	method.invoke(this);
            }
        }        
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) throws Exception  {
        Animal myAnimal = new Dog(); // Upcasting
        myAnimal.sound();           // Calls Dog's sound 
        Animal a1 = new Animal();
        
    }
}
