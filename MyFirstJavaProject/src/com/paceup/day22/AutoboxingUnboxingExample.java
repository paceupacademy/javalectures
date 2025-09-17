package com.paceup.day22;
//Byte, Short, Integer, Long, Double, Float, Boolean, Character
public class AutoboxingUnboxingExample {
    public static void main(String[] args) {
        Integer boxedNum = 30; // Autoboxing
        int result = boxedNum + 20; // Unboxing during arithmetic operation
        System.out.println("Result: " + result);
    }
}
