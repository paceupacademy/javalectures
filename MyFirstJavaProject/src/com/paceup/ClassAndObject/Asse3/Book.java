//Create a class Book with a method to show details.
package com.paceup.ClassAndObject.Asse3;

public class Book {
	 String title;
	 String author;
	 int price;
	 
	 public void BookDetails() {
		 
		 System.out.println("Title: "+title);
		 System.out.println("Author: "+author);
		 System.out.println("Price: "+ price);
	 }
	public static void main(String[] args) {
	
		Book b1 = new Book();
		b1.title= "Bhagavad Gita";
		b1.author = "Maharishi Ved Vyasa";	
		b1.price = 500;
		
		Book b2 = new Book();
		b2.title = "Mahabharata";
		b2.author = "Maharishi Ved Vyasa";
		b2.price = 450;
		
		b1.BookDetails();
		b2.BookDetails();
	}
}
