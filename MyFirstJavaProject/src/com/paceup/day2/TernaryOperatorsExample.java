package com.paceup.day2;

class TernaryOperatorsExample
{
	public static void main (String[] args) 
	{

		int a = 20, b = 10, c = 30, result;

		// result holds max of three
		// numbers
		result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
		System.out.println("Max of three numbers = "+ result);
	}
}
/*
 * (a>b -> true)?(a>c) -> false :c=30:(b>c->false) :c =30
 */