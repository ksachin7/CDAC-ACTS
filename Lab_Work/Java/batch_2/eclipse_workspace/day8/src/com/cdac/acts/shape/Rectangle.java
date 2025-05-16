package com.cdac.acts.shape;

public class Rectangle extends Shape {
	private float l;
	private float b;

	public Rectangle(float l, float b) {
		this.l= l;
		this.b= b;
	}
	
	public float calculateArea() {
		return l * b;
	}
	
	public float calculatePerimeter() {
		return 2*(l+b);
	}

	@Override
	public String toString() {
		return "Rectangle [l=" + l + ", b=" + b + "]";
	}
}
