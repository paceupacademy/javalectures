package com.paceup.day8;

public class InterfaceFullAbstractionExample2 {
    public static void main(String[] args) {
        Shape circle = new Circle(5.7);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
        System.out.println();
        
        Shape c = new Circle(556.877);
        System.out.println("Bigger Circle Area: "+c.calculateArea());
        Circle c1 = new Circle(556.877);
        c1.display();

        System.out.println();
        Shape rectangle = new Rectangle(4.6, 6.8);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
    }
}