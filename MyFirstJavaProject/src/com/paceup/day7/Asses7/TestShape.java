//4. Implement a simple runtime polymorphism example using Shape → Circle, Rectangle.

package com.paceup.day7.Asses7;

class Shape {
	void draw() {
		System.out.println("Drawing a shape...");
	}
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("Drawing a circle...");
	}
}

class Rectangle extends Shape {
	@Override
	void draw() {
		System.out.println("Drawing a rectangle...");
	}
}

public class TestShape {

	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();

		Circle caCircle = new Circle();
		caCircle.draw();

		Rectangle rectangle = new Rectangle();
		rectangle.draw();

	}

}
