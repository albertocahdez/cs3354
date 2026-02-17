package edu.txst.inheritance;

public class SphereType extends CircleType {

	public double getVolume() {
		return 4 / 3.0 * Math.PI * Math.pow(radius, 3);
	}

	@Override
	public double getArea() { // area of sphere's surface
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	public SphereType() {
		super(); // CircleType()
	}

	public SphereType(double radius) {
		super(radius); // CircleType(double)
	}

	public static void main(String[] args) {
		SphereType sphere = new SphereType(10);
		System.out.println("Sphere's volume: " + sphere.getVolume());
		System.out.println("Sphere's surface area: " + sphere.getArea());

		CircleType circle = new CircleType(10);
		System.out.println("Circle's area: " + circle.getArea());

		System.out.println("=========================");

		displayArea(sphere);
	}

	public static void displayArea(CircleType circle) {
		System.out.println("Printing area within a method.");
		System.out.println("Area: " + circle.getArea());
	}
}
