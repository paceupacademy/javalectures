package com.paceup.day22;

import java.util.ArrayList;

public class AutoboxingExample {
    public static void main(String[] args) {
        // Autoboxing: Converting primitive data type to Object(WrapperClass Object)
        int num = 10;
        Integer boxedNum = num; // Automatically converts int to Integer

        // Adding primitives to a collection (requires objects)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5); // Autoboxing: int to Integer
        numbers.add(15);

        System.out.println("Autoboxed List: " + numbers);
    }
}
