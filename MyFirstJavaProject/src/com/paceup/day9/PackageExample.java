package com.paceup.day9;
import java.lang.Math;

public class PackageExample {
    public static void main(String[] args) {
        int result = Math.addExact(30, 49);
        byte a = Byte.MAX_VALUE;
        byte result1 = a++;
        System.out.println("Result: " + result);
        System.out.println("Maximum Integer Value: "+a);
        System.out.println("Result: "+result1);
    }
}
