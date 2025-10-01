package com.company.DefaultObjects;

public class DefaultObjectExample {
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
		@Override
		public String toString() {
			return "[Radius: " + radius + " ]";
		}
	} 

	public static void main(String[] args) {
		CircleType circle = new CircleType(2.5);
		System.out.println(circle);
	}
}
