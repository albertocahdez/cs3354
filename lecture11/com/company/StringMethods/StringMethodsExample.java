package com.company.StringMethods;

public class StringMethodsExample {
	public static void main(String[] args) {
		String s = "  Hello  ";
		
		System.out.println(s.substring(3,5));
		System.out.println(s.equals("Hello"));
		System.out.println(s.equals("  Hello  "));
		System.out.println(s.trim());
		System.out.println(s.stripLeading());
		System.out.println(s.stripTrailing());
	}
}