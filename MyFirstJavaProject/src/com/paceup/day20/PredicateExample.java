package com.paceup.day20;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(7)); // false
    }
}
