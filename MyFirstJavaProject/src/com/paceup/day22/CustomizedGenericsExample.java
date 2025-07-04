package com.paceup.day22;

//Generic Class
class Box<T> {
 private T item;

 public void setItem(T item) {
     this.item = item;
 }

 public T getItem() {
     return item;
 }
}

public class CustomizedGenericsExample {
 public static void main(String[] args) {
     Box<String> stringBox = new Box<>();
     stringBox.setItem("Hello Generics");
     System.out.println("String Box: " + stringBox.getItem());

     Box<Integer> intBox = new Box<>();
     intBox.setItem(123);
     System.out.println("Integer Box: " + intBox.getItem());
 }
}
