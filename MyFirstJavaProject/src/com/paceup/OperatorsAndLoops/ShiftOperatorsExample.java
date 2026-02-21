package com.paceup.OperatorsAndLoops;

class ShiftOperatorsExample {
    public static void main(String[] args) {
        // Variable declaration
        int a = 10; // binary representation: 00001010

        // LEFT SHIFT (<<):
        // ----------------
        // Shifts bits to the left, fills with 0s on the right.
        // Each left shift multiplies the number by 2.
        // 00001010 << 1 = 00010100 (decimal 20)
        System.out.println("a << 1 : " + (a << 1));

        // RIGHT SHIFT (>>):
        // -----------------
        // Shifts bits to the right, keeps sign bit (for positive numbers, fills with 0s).
        // Each right shift divides the number by 2.
        // 00001010 >> 1 = 00000101 (decimal 5)
        System.out.println("a >> 1 : " + (a >> 1));
    }
}
