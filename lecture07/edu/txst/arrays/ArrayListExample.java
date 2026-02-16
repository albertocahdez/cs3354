package edu.txst.arrays;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> countries = new ArrayList<String>(20);
		countries.add("Belgium");
		countries.add("Italy");
		countries.add("Thailand");

		for (String s : countries) {
			System.out.println(s);
		}
	}
}
