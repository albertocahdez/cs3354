package com.lecture09;

import com.lecture09.compositionExamples.CourseType;
import com.lecture09.compositionExamples.EventType;
import com.lecture09.staticExamples.OnlyStatic;
import com.lecture09.staticExamples.StaticNonStatic;

class App {
	public static void main(String[] args) {
		/* 
		// Using OnlyStatic
		System.out.println("=== Only Static");
		System.out.println("Maximum value: " + OnlyStatic.MAXIMUM_VALUE);
		System.out.println("University: " + OnlyStatic.getUniversity());
  
		// Using StaticNonStatic
		System.out.println("=== Static and Non-static");
		System.out.println("Object count: " + StaticNonStatic.getObjectCount());
		StaticNonStatic sns1 = new StaticNonStatic("");
		System.out.println("Object count: " + StaticNonStatic.getObjectCount());
		StaticNonStatic sns2 = new StaticNonStatic("Blue");
		System.out.println("Object count: " + StaticNonStatic.getObjectCount());
		StaticNonStatic sns3 = new StaticNonStatic("Green");
		System.out.println("Object count: " + StaticNonStatic.getObjectCount());
*/
		// Using SimpleComposition
		CourseType ct = new CourseType();
 
		// Using InitializationComposition
		EventType et = new EventType("Exam 1", 22, 9, 2025);
		
	}
}