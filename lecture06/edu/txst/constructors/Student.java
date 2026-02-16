package edu.txst.constructors;

public class Student {
	private String firstName;
	private String lastName;
	private String major;
	private double gpa;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public Student() {
		this("", "", "", 0.0);
	}

	public Student(String firstName, String lastName, String major, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.gpa = gpa;
	}

	public static void main(String[] args) {
		Student student1 = new Student();
		System.out.println("First name: " + student1.getFirstName());
		System.out.println("Last name: " + student1.getLastName());
		System.out.println("Major: " + student1.getMajor());
		System.out.println("GPA: " + student1.getGpa());
		Student student2 = new Student("Peter", "Parker", "CS", 3.5);
		System.out.println("First name: " + student2.getFirstName());
		System.out.println("Last name: " + student2.getLastName());
		System.out.println("Major: " + student2.getMajor());
		System.out.println("GPA: " + student2.getGpa());
	}
}
