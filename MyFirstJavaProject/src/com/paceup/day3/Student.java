package com.paceup.day3;	

class Student {
	  
    // data member (also instance variable)
    int id =1;
  
    // data member (also instance variable)
    String n="Neha";
    static Dog dog= new Dog("tom","mudol",5,"hakf");
    public void display() {
    	System.out.println("Name is: "+n+" Id: "+id);
    	displayDog();
    }
  
    static void displayDog() {
    	System.out.println(dog.toString());
    }
    
    
    public static void main(String args[]) {
      
        // creating an object of
        // Student
    	String name="Radha";
        Student s1 = new Student();
        s1.n ="Ria";
        //String name="Ria";
        s1.display();
        //System.out.println(s1.id);
        //System.out.println(s1.n);
        
        Student s2 = new Student();
        s2.n=name;
        s2.id++;
        s2.display();
        
    }
}