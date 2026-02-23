package com.paceup.OperatorsAndLoops;

class TernaryOperatorsExample {
    public static void main(String[] args) {

        int a = 35, b = 10, c = 30, result;

        // Ternary Operator (?:)
        // ---------------------
        // Syntax: condition ? value_if_true : value_if_false
        // Works like a shorthand if-else statement.
        //
        // Here we are finding the maximum of three numbers (a, b, c).
        // Expression breakdown:
        // (a > b) ? (a > c ? a : c) : (b > c ? b : c)
        //
        // Step 1: Check if a > b
        // Step 2: If true, then check if a > c → if yes, result = a, else result = c
        // Step 3: If false, then check if b > c → if yes, result = b, else result = c

        result = ((a > b) ? (a > c ? a : c) : (b > c ? b : c));

        System.out.println("Max of three numbers = " + result);
    }
}

/*
 * Dry Run Example:
 * ----------------
 * a = 35, b = 10, c = 30
 *
 * Step 1: (a > b) → (35 > 10) → true
 * Step 2: (a > c) → (35 > 30) → true → result = a = 35
 *
 * Final Output:
 * Max of three numbers = 35
 */
