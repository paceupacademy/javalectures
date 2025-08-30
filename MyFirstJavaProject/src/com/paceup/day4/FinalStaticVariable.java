package com.paceup.day4;

import com.paceup.day4.FinalVariable;

public class FinalStaticVariable {
	// a final variable
    // direct initialize
    final int THRESHOLD = 5;
    
    // a blank final variable
    final int CAPACITY;
    
    // another blank final variable
    final int  MINIMUM;
    
    // a final static variable PI
    // direct initialize
    static final double PI = 3.141592653589793;
    
    // a  blank final static  variable
    static final double EULERCONSTANT;
    
    // instance initializer block for 
    // initializing CAPACITY
    {
        CAPACITY = 25;
    }
    
    // static initializer block for 
    // initializing EULERCONSTANT
    static{
        EULERCONSTANT = 2.3;
    }
    
    // constructor for initializing MINIMUM
    // Note that if there are more than one
    // constructor, you must initialize MINIMUM
    // in them also
    public FinalStaticVariable() 
    {
        MINIMUM = -1;
    }
    
    public static void main(String[] args) {
    	FinalStaticVariable fsv =  new FinalStaticVariable();
    	System.out.println("Threshold Value: "+fsv.THRESHOLD);
    	System.out.println("Capacity is: "+fsv.CAPACITY);
    	System.out.println("Minimum Capacity is: "+fsv.MINIMUM);
    	System.out.println("Euler's Constant is: "+EULERCONSTANT);
    	System.out.println("PI value is: "+PI);
    }
}

