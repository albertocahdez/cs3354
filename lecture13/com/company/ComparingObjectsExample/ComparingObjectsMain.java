package com.company.ComparingObjectsExample;

public class ComparingObjectsMain {
	static class MyObject {
		// empty class
	}
	public static void main(String[] args) {
		MyObject o1 = new MyObject();
		MyObject o2 = new MyObject();
		MyObject o3 = o1;

		System.out.println("o1 == o2 : " + ( o1 == o2 ) );	// references to two different objects
		System.out.println("o1 == o3 : " + ( o1 == o3 ) ); // references to the same object
		System.out.println("o2 == o3 : " + ( o2 == o3 ) ); // references to two different objects
	}
}