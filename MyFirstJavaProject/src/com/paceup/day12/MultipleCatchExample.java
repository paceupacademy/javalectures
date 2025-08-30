package com.paceup.day12;

public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[2]); 
            int sum = numbers[1]/0;
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception occurred."+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other exception occurred: " + e.getMessage());
        }
    }
}

