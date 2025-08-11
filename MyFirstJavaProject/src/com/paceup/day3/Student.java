package com.paceup.day3;	

class Student {
	  
    // data member (also instance variable)
    int id =1;
  
    // data member (also instance variable)
    String n="Neha";
    
    public void display() {
    	System.out.println("Name is: "+n);
    }
  
    public static void main(String args[]) {
      
        // creating an object of
        // Student
        Student s1 = new Student();
        s1.n ="Ria";
        //String name="Ria";
        s1.display();
        System.out.println(s1.id);
        //System.out.println(s1.n);
        
        Student s2 = new Student();
        //s2.n="Raj";
        s2.display();
    }
}