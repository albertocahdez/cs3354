package edu.txst.listExample;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private double gpa;
	private String major;

	public Student(String firstName, String lastName, double gpa, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.major = major;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null)
			return false;
		else if (obj instanceof Student) {
			Student o = (Student) obj;
			if ((this.firstName == null && o.firstName == null
					|| this.firstName.equals(o.firstName))
					&& (this.lastName == null && o.lastName == null
							|| this.lastName.equals(o.lastName)))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Student o) {
		int comparisonValue = this.firstName.compareTo(o.firstName);
		if (comparisonValue == 0) {
			comparisonValue = this.lastName.compareTo(o.lastName);
		}
		return comparisonValue;
	}

	@Override
	public String toString() {
		return "Student[firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa
				+ ", major=" + major + "]";
	}
}
