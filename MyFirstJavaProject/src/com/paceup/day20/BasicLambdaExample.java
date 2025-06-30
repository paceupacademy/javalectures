package com.paceup.day20;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class BasicLambdaExample {
    public static void main(String[] args) {
        // Lambda expression
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!"); //name is our input parameter to lambda expression
        greeting.sayHello("Alice");
    }
}
