package com.company.ArrayClasses;

public class ArrayExample {
	public static class CircleType {
		public double radius;
		public double getRadius() {
			return radius;
		}
		public void setRadius(double radius) {
			this.radius = radius;
		}
		CircleType() {
			radius = 0;
		}
		CircleType(double radius) {
			this.radius = radius;
		}
	} 
	public static void main(String[] args) {
		int n = 8;
		CircleType[] array = new CircleType[n];
		for ( int i = 0; i < n; i++ ) {
			array[i] = new CircleType();
			System.out.println(array[i].getRadius());
		}
	 
		CircleType[] array2 = new CircleType[3];
		for ( int i = 0; i < 3; i++ ) {
			array2[i] = new CircleType(i);
		}

		CircleType[] array3 = {new CircleType(), new CircleType(2), new CircleType()};

	}
}
