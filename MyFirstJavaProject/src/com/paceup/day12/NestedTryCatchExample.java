package com.paceup.day12;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            int result = 10 / 2; // ArithmeticException
            try {
                System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
           
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Cannot divide by zero.");
        }
    }
}

