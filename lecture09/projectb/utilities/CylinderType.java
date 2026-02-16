package utilities;

import utilities.CircleType;

public class CylinderType extends CircleType {
	private double height;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	CylinderType() {
		radius = 1.0;
	}

	CylinderType(double radius) {
		this.radius=radius;
	}

	@Override
	public double getArea() {
		return 2 * ( super.getArea() + super.getArea() / radius * height);
	}

	public double getVolume() {
		return super.getArea() * height;
	}
}
