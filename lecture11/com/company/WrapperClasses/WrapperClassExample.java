package com.company.WrapperClasses;

import java.util.ArrayList;

public class WrapperClassExample {
	public static void main(String[] args) {
		ArrayList<Integer> numberList = new ArrayList<Integer>(20);
		numberList.add(5);
		numberList.add(23);
		numberList.add(48);

		for (Integer i : numberList) { 
			System.out.println(i); 
		}
	}
}