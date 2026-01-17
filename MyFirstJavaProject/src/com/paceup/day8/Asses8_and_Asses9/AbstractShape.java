//1. Create an abstract class Shape with an abstract method area(). Implement it in Circle and Rectangle.
package com.paceup.day8.Asses8_and_Asses9;

abstract class Shape {
	abstract double area();
}

class Circle extends Shape {
	double radious;

	Circle(double radious) {
		this.radious = radious;
	}

	@Override
	double area() {
		System.out.println("Circle Area:");
		return Math.PI * radious * radious;
	}
}

class Rectangle extends Shape {
	double length;
	double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		System.out.println("Rectangle Area:");
		return length * width;
	}
}

public class AbstractShape {

	public static void main(String[] args) {
		Shape s1 = new Circle(5);
		Shape s2 = new Rectangle(2, 4);

		System.out.println(s1.area());
		System.out.println(s2.area());
	}

}
