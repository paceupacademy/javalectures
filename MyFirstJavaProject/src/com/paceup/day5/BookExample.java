package com.paceup.day5;

import com.paceup.day6.ProtectedMethod;

//Implement a JavaBean class with encapsulated fields.
class Book implements java.io.Serializable{
	private String title;
	private String author;
	
	public Book() {
		System.out.println("Inside Constructor");
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}

class Cat extends ProtectedExample {
	
}
public class BookExample {
	public static void main(String[] args) {
		Book bk=new Book();
		bk.setTitle("Google");
		bk.setAuthor("AD");
		
		Book bk1 = new Book();
		bk1.setAuthor("Evan");
		bk1.setTitle("Night");
		System.out.println("Book Title:"+bk.getTitle());
		System.out.println("Book Author:"+bk.getAuthor());
		
		System.out.println("\nBook Title is "+bk1.getTitle()+" by author "+bk1.getAuthor());
		
		//Cat c = new Cat();
		//System.out.println("The color of Cat is "+c.);
	}
}
