package com.paceup.day4;

public class StaticVariableExample {
	// static variable
    static int a = m1(); //a=20
    int num =10;
    
    public StaticVariableExample() {
		a = a+ 15;
		num++;
	}
    
    // static block run first when the class is loaded even before constructor
    static {
        System.out.println("Inside static block");
    }
    
    // static method
    static int m1() { //non-static variable are not accessible
    	System.out.println("from m1");
        return 20;
    }
    
    // static method(main !!)
    public static void main(String[] args)
    {
       System.out.println("Static Value of a : "+a);
       System.out.println("from main");
       StaticVariableExample s = new StaticVariableExample();
       System.out.println(" Value of a: "+s.a+" Num: "+s.num);
       StaticVariableExample s1 = new StaticVariableExample();
       System.out.println("Value of a: "+s1.a+" Num: "+s1.num);
       int m = m1();
       System.out.println("Value for static m1(): "+m);
    }
}
