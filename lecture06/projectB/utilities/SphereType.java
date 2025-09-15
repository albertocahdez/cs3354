package utilities;

public class SphereType extends CircleType{
	public double getVolumen() {
		return ( 4 / 3.0 ) * Math.PI * Math.pow(radius, 3);
	}
	@Override
	public double getArea() {
		// return 4 * Math.PI * Math.pow(radius,2);
		return 4 * super.getArea();
	}
	public SphereType(double radius) {
		setRadius(radius);
		System.out.println("Sphere surface area: " + getArea());
		//super(radius);
	}
}
