package com.paceup.day2;

class BitwiseOperatorsExample
{
	public static void main (String[] args) 
	{
		// Bitwise operators
        int d = 0b1010;
        int e = 0b1100;
        System.out.println("d= "+d+" e= "+e);
        System.out.println("d & e : " + (d & e));
        System.out.println("d | e : " + (d | e));
        System.out.println("d ^ e : " + (d ^ e)); //XOR
        System.out.println("~d : " + (~d)); //NOT
        System.out.println("d << 2 : " + (d << 2)); //LEFT Shift  (multiples of 2)
        System.out.println("e >> 1 : " + (e >> 1));
        System.out.println("e >>> 1 : " + (e >>> 1));
	}
}