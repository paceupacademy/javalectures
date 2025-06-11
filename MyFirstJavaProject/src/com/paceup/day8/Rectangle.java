package com.paceup.day8;

//Implementation 2: Rectangle
public class Rectangle implements Shape {
 private double length, width;

 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 @Override
 public double calculateArea() {
     return length * width;
 }

 @Override
 public double calculatePerimeter() {
     return 2 * (length + width);
 }
}