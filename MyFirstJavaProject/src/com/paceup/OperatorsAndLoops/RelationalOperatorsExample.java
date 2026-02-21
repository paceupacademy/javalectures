package com.paceup.OperatorsAndLoops;

class RelationalOperatorsExample {
    public static void main(String[] args) {

        // Relational (Comparison) Operators:
        // ----------------------------------
        // Used to compare two values.
        // Always return a boolean result: true or false.

        int a = 3;
        int b = 3;
        int c = 5;

        // Greater than (>)
        // Checks if left operand is greater than right operand.
        // 3 > 3 → false
        System.out.println("a > b: " + (a > b));

        // Less than (<)
        // Checks if left operand is less than right operand.
        // 3 < 3 → false
        System.out.println("a < b: " + (a < b));

        // Greater than or equal to (>=)
        // Checks if left operand is greater than or equal to right operand.
        // 3 >= 3 → true
        System.out.println("a >= b: " + (a >= b));

        // Less than or equal to (<=)
        // Checks if left operand is less than or equal to right operand.
        // 3 <= 3 → true
        System.out.println("a <= b: " + (a <= b));

        // Equal to (==)
        // Checks if two values are equal.
        // 3 == 5 → false
        System.out.println("a == c: " + (a == c));

        // Not equal to (!=)
        // Checks if two values are not equal.
        // 3 != 3 → false
        System.out.println("a != b: " + (a != b));
    }
}
