package com.lecture09.staticExamples;

public class OnlyStatic {
	private static String university;	// static variable
	public static final int MAXIMUM_VALUE=2025;	// static constant value

	static {
		university = "Texas State University";	// initialization of a static variable
	}
	
	public static String getUniversity() {	// static method
		return university;
	}
}