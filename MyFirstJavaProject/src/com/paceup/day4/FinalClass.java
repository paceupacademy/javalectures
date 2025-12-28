package com.paceup.day4;

final class FinalClass {
    void show() {
        System.out.println("This is a final class.");
    }
    void display(final int num1) {
        final int num = 56; 
    	System.out.println("\nNum: "+num);
    	System.out.println("Num1: "+num1);
    }
    void method() {
        final int localVar = 50;
        //localVar = 60; // Compilation error
        display(localVar);
        //System.out.println("localVar:"+localVar);
        
    }
    
    public static void main(String[] args) {
    	FinalClass fc = new FinalClass();
    	fc.show();
    	fc.display(5);
    	fc.method();
    	fc.display(25);
    }
}

/*class Subclass extends FinalClass{
	
}*/