package com.lecture09.compositionExamples;

public class CourseType {
	private InstructorType instructor;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}