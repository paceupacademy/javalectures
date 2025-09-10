package com.paceup.day20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Welcome to Java Lambdas!");
        
        printMessage.andThen(s -> System.out.println("Length of message : "+s.length())).accept("Welcome to Java Lambdas!");
        
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob", "David", "Arjun");
        //Using lambda expression with Consumer
        names.forEach(n -> System.out.print(n+" "));
        
        //Using Consumer Explicitly
        Consumer<String> display = n -> System.out.print(n+" ");
        names.forEach(display);
    }
}
