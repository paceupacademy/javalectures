package com.paceup.OperatorsAndLoops;

public class ContinueExample {
	public static void main(String args[])
	{      
		// For loop for iteration
		for (int i = 0; i <=5; i++)
		{
			// Check condition for continue
			// skip the execution of loop when i==3                  
			if (i == 3)
				continue;

			System.out.print(i + " ");
		}
	}
}
