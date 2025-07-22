package com.paceup.day8;

//Implementation 1: Circle
public class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * radius * radius; 
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
}