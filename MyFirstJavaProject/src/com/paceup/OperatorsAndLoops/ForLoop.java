package com.paceup.OperatorsAndLoops;

public class ForLoop {
	public static void main(String args[]) {
	      
        // for loop to print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
          
            System.out.println("Count: " + i);
        }
        
        System.out.println("Loop has ended.");
        
        //For Loop with False Condition
        for ( int i =10; i<5;i++) {
        	System.out.println("This is never executed");
        }
        
        
        int s = 0;
        int r=7;
        for(int i=1; i<=7; i++) {
        	for(int j=1; j<=7-i;j++) {
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
        
        System.out.println();
        for( ; s<10 ; ) {
        	System.out.print("S"+s+" ");
        	s++;
        }
        
        System.out.println();
        for(int s1=10 ; s1>=0; s1-- ) {
        	System.out.print(s1+" ");
        	
        }
        System.out.println("\ns= "+s);

        // for loop begins
        // and runs till x <= 20
        s=0;
        for (int x = 1; x <= 20; x++) {
            s = s + x; 
        }
        System.out.println("Sum: " + s);
        
        /*
         * s = (n(a+b))/2
         * n=b-a+1
         * 
         * 1-10
         * S = ((10-1+1)(1+10))/2 = (10*11)/2 = 55
         */
        
        //Enhanced For Loop
        String[] names= {"Om","Raj","Kiran"};
        for(String name:names) {
        	System.out.println("Name:"+name);
        }
    }
	
}
