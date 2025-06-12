package com.paceup.day5;

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
public class BookExample {
	public static void main(String[] args) {
		Book bk=new Book();
		bk.setTitle("Google");
		bk.setAuthor("AD");
		System.out.println("Book Title:"+bk.getTitle());
		System.out.println("Book Author:"+bk.getAuthor());
	}
}
