package utilities;

public class CircleType {
	protected double radius;
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return Math.PI * Math.pow(radius,2);
	}
	public CircleType() {
		setRadius(1.0);
	}
	public CircleType(double radius) {
		setRadius(radius);
	}
}
