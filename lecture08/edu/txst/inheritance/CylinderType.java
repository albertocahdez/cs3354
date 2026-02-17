package edu.txst.inheritance;

public class CylinderType extends CircleType {
	private double height;

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public double getVolume() {
		return super.getArea() * height;
	}

	// super.getArea (CircleType)
	// this.getArea or getArea (CylinderType)

	@Override
	public double getArea() { // area of surface of the cylinder
		return super.getArea() * 2 + height * Math.PI * radius * 2;
	}

	public CylinderType() {
		super();
	}

	public CylinderType(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public static void main(String[] args) {
		CylinderType cylinder = new CylinderType(10, 5);
		System.out.println("Volume: " + cylinder.getVolume());
		System.out.println("Surface area: " + cylinder.getArea());
	}
}
