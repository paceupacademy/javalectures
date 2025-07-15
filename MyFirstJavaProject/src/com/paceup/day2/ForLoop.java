package com.paceup.day2;

public class ForLoop {
	public static void main(String args[]) {
	      
        // for loop to print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
          
            System.out.println("Count: " + i);
        }
        
        System.out.println("Loop has ended.");
        
        int s = 0;

        // for loop begins
        // and runs till x <= 20
        for (int x = 1; x <= 20; x++) {
            s = s + x; 
        }
        System.out.println("Sum: " + s);
    }
	
}
