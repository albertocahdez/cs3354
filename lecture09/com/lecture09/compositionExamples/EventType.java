package com.lecture09.compositionExamples;

public class EventType {
	private String title;
	private DateType eventDate;

	public EventType(String title, int day, int month, int year) {
		eventDate = new DateType(day, month, year);
		this.title = title;
	}
}
