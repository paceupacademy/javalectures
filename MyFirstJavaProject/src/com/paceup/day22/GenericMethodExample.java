package com.paceup.day22;
//Generics means type of code in java that works with different types of data
public class GenericMethodExample {
    // Generic Method
    public static <T> void printArray(T[] array) { //generic method that will work with any type of data
        for (T element : array) { //works similar to for-each iterates over each element of array of type T
            System.out.print(element + " ");
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4}; //Integer is wrapper class
        String[] stringArray = {"A", "B", "C"};

        System.out.print("Integer Array: ");
        printArray(intArray);
        
        System.out.print("String Array: ");
        printArray(stringArray);
        
    }
}
