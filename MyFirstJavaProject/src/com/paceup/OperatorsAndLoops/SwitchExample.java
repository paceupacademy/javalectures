package com.paceup.OperatorsAndLoops;

public class SwitchExample {
	public static void main (String[] args) {
	      
	      //assigning n as integer value
	      char n = 'b';
	      int i =2;
	      //passing n to switch
	      // it will check n and display output accordingly
	      switch(i) {
	          
	        case 'a': 
	          System.out.println("India");
	          break;
	        case 'b':
	          System.out.println("Second Case");
	          break;
	        default:
	          System.out.println("default case");
	      }
	      System.out.println("Outside Switch!!!");
	    }
}
