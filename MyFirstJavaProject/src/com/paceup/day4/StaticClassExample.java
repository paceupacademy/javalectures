package com.paceup.day4;

public class StaticClassExample {
	public static int count = 0;
    public int id;
    private static int outerstaticVariable = 5;

    public StaticClassExample() {
        count++;
        id = count;
        outerstaticVariable++;
    }

    public static void printCount() {
        System.out.println("Number of instances: " + count);
    }

    public void printId() {
        System.out.println("Instance ID: " + id);
    }
    
    static class Example{
    	void display() {
    		System.out.println("Outer static variable: "+outerstaticVariable);
    	}
    }

    public static void main(String[] args) {
    	StaticClassExample g1 = new StaticClassExample();
    	StaticClassExample g2 = new StaticClassExample();
    	StaticClassExample g3 = new StaticClassExample();
    	
    	StaticClassExample.Example stobj = new StaticClassExample.Example();

        g1.printId();
        g2.printId();
        g3.printId();

        printCount();
        
        stobj.display();
    }
}
