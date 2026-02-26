package edu.txst.comparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private double gpa;
	private String major;

	public String getMajor() {
		return major;
	}

	@Override
	public int compareTo(Student o) {
		return Double.compare(this.gpa, o.gpa);
	}

	public Student(String firstName, String lastName, double gpa, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student[firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa
				+ ", major=" + major + "]";
	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Landon", "Newton", 3.25, "BIO"));
		list.add(new Student("Valentina", "Carter", 3.5, "CS"));
		list.add(new Student("Kristian", "Saunders", 3.9, "NUR"));
		list.add(new Student("Ryan", "Robles", 3.1, "BBA"));
		System.out.println("=== Original ordering ===");
		for (Student student : list)
			System.out.println(student);
		Collections.sort(list, new StudentMajorComparator());
		System.out.println("=== Sorted list ===");
		for (Student student : list)
			System.out.println(student);
	}
}
