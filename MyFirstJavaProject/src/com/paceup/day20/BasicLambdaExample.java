package com.paceup.day20;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

@FunctionalInterface
interface MyInterface {
	void show();
}

public class BasicLambdaExample {
    public static void main(String[] args) {
        // Lambda expression
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!"); //name is our input parameter to lambda expression
        greeting.sayHello("Alice");
        
        MyInterface obj = () -> System.out.println("Sum of 5 & 3 is: "+(5+3));
        obj.show();
    }
}
