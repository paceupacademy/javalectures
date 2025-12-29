package com.paceup.day4;

public class StaticVariableExample {
	// static variable
    static int a = m1(); //a=20
    int num =10;
    
    public StaticVariableExample() {
    	System.out.println("\nnum:"+num+" a:"+a);
		a = a+ 15; //a=35
		num++; //num=11
	}
    
    // static block run first when the class is loaded even before constructor
    static {
        System.out.println("Inside static block");
    }
    
    void display() {
    	System.out.println("num:"+this.num);
    	System.out.println("a:"+this.a);
    }
    
    // static method
    static int m1() { //non-static variable are not accessible
    	
    	System.out.println("from m1");
        return 20;
    }
    
    // static method(main !!)
    public static void main(String[] args)
    {
    	System.out.println("from main method\n");
       System.out.println("Static Value of a : "+a); //20
       
       
       StaticVariableExample s = new StaticVariableExample();
       System.out.println("Value of a: "+s.a+" Num: "+s.num+"\n");
       //s.display();
       
       StaticVariableExample s1 = new StaticVariableExample();
       System.out.println("Value of a: "+s1.a+" Num: "+s1.num);
       
       int a = 7;
       
       int m = m1();
       System.out.println("\nValue for static m1(): "+m);
       
       //s1.display();
    }
}
