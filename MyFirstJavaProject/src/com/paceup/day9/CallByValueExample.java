package com.paceup.day9;

public class CallByValueExample {
    public static void main(String[] args) {
        int num = 10;
        modifyValue(num);
        System.out.println("Original value: " + num); // Output: 10
    }

    public static void modifyValue(int value) {
        value = 20; // Changes only the local copy
        System.out.println("After modification: "+value);
        
    }
}
