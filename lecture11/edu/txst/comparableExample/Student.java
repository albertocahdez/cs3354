package edu.txst.comparableExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private double gpa;

	@Override
	public int compareTo(Student o) {
		return Double.compare(this.gpa, o.gpa);
	}

	public Student(String firstName, String lastName, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student[firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa + "]";
	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Landon", "Newton", 3.25));
		list.add(new Student("Valentina", "Carter", 3.5));
		list.add(new Student("Kristian", "Saunders", 3.9));
		list.add(new Student("Ryan", "Robles", 3.1));
		System.out.println("=== Original ordering ===");
		for (Student student : list)
			System.out.println(student);
		Collections.sort(list);
		System.out.println("=== Sorted list ===");
		for (Student student : list)
			System.out.println(student);
	}
}
