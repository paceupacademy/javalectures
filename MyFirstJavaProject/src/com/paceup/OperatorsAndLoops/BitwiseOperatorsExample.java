package com.paceup.OperatorsAndLoops;

class BitwiseOperatorsExample {
    public static void main(String[] args) {
        // Bitwise Operators in Java:
        // --------------------------
        // Work directly on bits (binary representation of numbers).
        // Operate at the level of 0s and 1s.

        // Binary literals (prefix 0b means binary):
        // 0b0101 = 5 in decimal
        // 0b0111 = 7 in decimal
        int d = 0b0101; // binary 0101 → decimal 5
        int e = 0b0111; // binary 0111 → decimal 7

        System.out.println("d = " + d + " e = " + e);

        // AND (&): 1 if both bits are 1, else 0
        // 0101 & 0111 = 0101 (decimal 5)
        System.out.println("d & e : " + (d & e));

        // OR (|): 1 if either bit is 1
        // 0101 | 0111 = 0111 (decimal 7)
        System.out.println("d | e : " + (d | e));

        // XOR (^): 1 if bits are different
        // 0101 ^ 0111 = 0010 (decimal 2)
        System.out.println("d ^ e : " + (d ^ e));

        // NOT (~): flips bits (1→0, 0→1)
        // ~0101 → depends on 32-bit representation
        // Result = -6 (because of two’s complement representation)
        System.out.println("~d : " + (~d));

        // LEFT SHIFT (<<): shifts bits left, fills with 0s
        // 0101 << 2 = 0001 0100 (decimal 20)
        // Equivalent to multiplying by 2^2 = 4
        System.out.println("d << 2 : " + (d << 2));

        // RIGHT SHIFT (>>): shifts bits right, keeps sign bit
        // 0101 >> 1 = 0010 (decimal 2)
        System.out.println("d >> 1 : " + (d >> 1));

        // UNSIGNED RIGHT SHIFT (>>>): shifts bits right, fills with 0s
        // For positive numbers, same as >>.
        // For negative numbers, >>> fills with 0s instead of sign bit.
        // Here d=5, so result is 2 (same as >>).
        System.out.println("d >>> 1 : " + (d >>> 1));
    }
}
