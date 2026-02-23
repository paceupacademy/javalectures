package com.paceup.OperatorsAndLoops;

public class DataTypesExamples {

    // Java Program to Demonstrate Primitive Data Types
    public static void main(String args[]) {

        // char: stores a single character (uses single quotes)
        char a = 'A'; // Unicode value for 'A'

        // int: commonly used for numeric values (range: -2,147,483,648 to 2,147,483,647)
        int i = 900;

        // byte: very small integer type (range: -128 to 127)
        // useful when memory is a constraint
        byte b = 4;

        // short: small integer type (range: -32,768 to 32,767)
        short s = 576;

        // double: default type for decimal numbers (64-bit, high precision)
        double d = 4.355453532d;

        // float: decimal type with less precision than double (32-bit)
        // requires 'f' suffix
        float f = 4.7333434f;

        // long: used for very large integers (range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
        // requires 'L' suffix
        long l = 12121L;

        // boolean: stores true or false values
        boolean remark = true;

        // Printing all values
        System.out.println("char: " + a);
        System.out.println("integer: " + i);
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("long: " + l);
        System.out.println("Boolean: " + remark);
    }
}
