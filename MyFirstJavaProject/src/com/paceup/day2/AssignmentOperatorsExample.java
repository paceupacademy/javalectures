package com.paceup.day2;

class AssignmentOperatorsExample
{
 public static void main (String[] args) 
 {
       
	// Assignment operators
     int f = 7;
     System.out.println("f += 3: " + (f += 3)); //f=7+3 =10
     System.out.println("f -= 2: " + (f -= 2)); //f=10-2=8
     System.out.println("f *= 4: " + (f *= 4)); //f=8*4=32
     System.out.println("f /= 3: " + (f /= 3)); //f=32/4=4
     System.out.println("f %= 2: " + (f %= 2)); //f=4%2 =0
     System.out.println("f &= 0b1010: " + (f &= 0b1010));
     System.out.println("f |= 0b1100: " + (f |= 0b1100));
     System.out.println("f ^= 0b1010: " + (f ^= 0b1010));
     System.out.println("f <<= 2: " + (f <<= 2));
     System.out.println("f >>= 1: " + (f >>= 1));
     System.out.println("f >>>= 1: " + (f >>>= 1));
       
 }
}