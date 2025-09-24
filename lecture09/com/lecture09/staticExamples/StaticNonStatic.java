package com.lecture09.staticExamples;

public class StaticNonStatic {
	private static int objectCount;
	private String name;

	static {
		objectCount = 0;
	}

	public String getName() {
		return name;
	}
	public static int getObjectCount() {
		return objectCount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StaticNonStatic(String name) {
		if ( name.length() == 0 ) {
			name = "NoName";
		}
		this.name = name;
		objectCount++;
	}
}