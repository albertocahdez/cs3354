package edu.txst.inheritance;

public class CircleType {
	protected double radius;

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public CircleType() {
		this.radius = 0.0;
	}

	public CircleType(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}
