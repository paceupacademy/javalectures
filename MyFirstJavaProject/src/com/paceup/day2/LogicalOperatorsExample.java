package com.paceup.day2;

class LogicalOperatorsExample
{
	public static void main (String[] args) 
	{

		// Logical operators
        boolean x = true;
        boolean y = true;
        boolean z = false;
      
        System.out.println("x && y: " + (x && y)); //true
        System.out.println("x && z: "+ (x && z)); //false
        System.out.println("x || z: " + (x || z)); //true
        System.out.println("!x: " + (!x)); //false
        System.out.println("x: "+x); //true

	}
}