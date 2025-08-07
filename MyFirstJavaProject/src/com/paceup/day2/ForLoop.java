package com.paceup.day2;

public class ForLoop {
	public static void main(String args[]) {
	      
        // for loop to print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
          
            System.out.println("Count: " + i);
        }
        
        System.out.println("Loop has ended.");
        
        
        
        int s = 0;
        int r=5;
        for(int i=1; i<=5; i++) {
        	for(int j=1; j<=5-i;j++) {
        		System.out.print(" ");
        	}
        	for(int k=1; k<=(2*i-1); k++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        for(int i=r-1; i>=1; i--) {
        	for(int j=1; j<=r-i;j++) {
        		System.out.print(" ");
        	}
        	for(int k=1; k<=(2*i-1); k++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        
        for( ; s<10 ; ) {
        	System.out.println("S"+s);
        	s++;
        }
        
        for(int s1=10 ; s1>=0; s1-- ) {
        	System.out.print(s1+" ");
        	
        }

        // for loop begins
        // and runs till x <= 20
        for (int x = 1; x <= 20; x++) {
            s = s + x; 
        }
        System.out.println("Sum: " + s);
    }
	
}
