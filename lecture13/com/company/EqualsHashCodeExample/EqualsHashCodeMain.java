package com.company.EqualsHashCodeExample;

public class EqualsHashCodeMain {
	static class RectangleType {
		private double length;
		private double width;
		
		public RectangleType(double length, double width) {
			this.length = length;
			this.width = width;
		}
		@Override
		public String toString() {
			return "RectangleType[length=" + this.length + ",width=" + this.width + "]";
		}
		@Override
		public int hashCode() {
			return (int)this.length * (int)this.width;
		}
		@Override
		public boolean equals(Object obj) {
			if ( this == obj ) {
				return true;
			} else if ( obj == null ) {
				return false;
			} else if ( obj instanceof RectangleType ) {
				RectangleType r = (RectangleType) obj;
				if ( this.length == r.length && this.width == r.width ) {
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		RectangleType r1 = new RectangleType(2.3,4.3);
		RectangleType r2 = new RectangleType(2.8,4.1);
		RectangleType r3 = r1;

		System.out.println("r1.equals(r2): " + r1.equals(r2));
		System.out.println("r1.equals(r3): " + r1.equals(r3));
		System.out.println("r2.equals(r3): " + r2.equals(r3));
		System.out.println("r1.hashCode(),r2.hashCode(): " + r1.hashCode() + "," + r2.hashCode());
		System.out.println("r1.hashCode(),r3.hashCode(): " + r1.hashCode() + "," + r3.hashCode());
		System.out.println("r2.hashCode(),r3.hashCode(): " + r2.hashCode() + "," + r3.hashCode());
	}
}
