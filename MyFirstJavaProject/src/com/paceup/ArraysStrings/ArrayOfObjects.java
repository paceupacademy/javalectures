package com.paceup.ArraysStrings;

class Student{
	public int rollNo;
	public String name;
	
	Student(int rollNo, String name){
		this.rollNo = rollNo;
		this.name =  name;
	}
}
public class ArrayOfObjects {

	public static void main(String[] args) {
		Student[] arr;
		arr = new Student[5];
		
		arr[0]= new Student(1,"amit");
		arr[1]= new Student(2,"Pooja");
		
		for(int i=0; i<2;i++) {
			System.out.println("Element at "+i+" : ( "+arr[i].rollNo+" "+arr[i].name+" )");
		}
	}

}
