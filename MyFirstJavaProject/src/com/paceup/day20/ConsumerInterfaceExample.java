package com.paceup.day20;

import java.util.function.Consumer;

public class ConsumerInterfaceExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Welcome to Java Lambdas!");
    }
}
