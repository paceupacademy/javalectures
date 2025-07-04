package com.paceup.day22;

public class UnboxingExample {
    public static void main(String[] args) {
        // Unboxing: Converting Integer to int
        Integer boxedNum = 20;
        //int num = boxedNum; // Automatically converts Integer to int

        // Using unboxed value in arithmetic operations
        int result = boxedNum + 10;
        System.out.println("Unboxed Value: " + result);
    }
}
