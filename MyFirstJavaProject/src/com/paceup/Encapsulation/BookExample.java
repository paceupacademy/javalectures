package com.paceup.Encapsulation;

// JavaBean class → Book
// ----------------------
// A JavaBean is a reusable software component that follows certain conventions:
// 1. Must be public.
// 2. Must have a no-argument constructor.
// 3. Properties (fields) must be private.
// 4. Must provide public getter and setter methods.
// 5. Often implements Serializable (for persistence).
class Book implements java.io.Serializable {
    // Private fields (encapsulated data)
    private String title;
    private String author;

    // No-argument constructor (required for JavaBeans)
    public Book() {
        System.out.println("Inside Constructor");
    }

    // Getter and Setter for 'title'
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for 'author'
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}

// Driver class to demonstrate Book JavaBean
public class BookExample {
    public static void main(String[] args) {
        // Create Book object (constructor called)
        Book bk = new Book();

        // Set values using setter methods
        bk.setTitle("Google");
        bk.setAuthor("AD");

        // Get values using getter methods
        System.out.println("Book Title: " + bk.getTitle());
        System.out.println("Book Author: " + bk.getAuthor());
    }
}
