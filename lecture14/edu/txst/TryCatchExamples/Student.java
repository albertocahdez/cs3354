package edu.txst.TryCatchExamples;

public class Student {
	private String firstName;
	private String lastName;
	private double gpa;
	private String major;

	public void setFirstName(String firstName) throws InvalidValueException {
		if (firstName == null || firstName.trim().length() == 0)
			throw new InvalidValueException("First name contains an invalid value.");
		this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidValueException {
		if (lastName == null || lastName.trim().length() == 0)
			throw new InvalidValueException("Last name contains an invalid value.");
		this.lastName = lastName;
	}

	public void setGpa(double gpa) throws InvalidValueException {
		if (gpa < 0.0 || gpa > 4.0)
			throw new InvalidValueException("GPA contains an invalid value.");
		this.gpa = gpa;
	}

	public void setMajor(String major) throws InvalidValueException {
		if (major == null || major.trim().length() == 0)
			throw new InvalidValueException("Major contains an invalid value.");
		this.major = major;
	}

	public Student(String firstName, String lastName, double gpa, String major)
			throws InvalidValueException {
		if (firstName == null || firstName.trim().length() == 0)
			throw new InvalidValueException("First name contains an invalid value.");
		if (lastName == null || lastName.trim().length() == 0)
			throw new InvalidValueException("Last name contains an invalid value.");
		if (gpa < 0.0 || gpa > 4.0)
			throw new InvalidValueException("GPA contains an invalid value.");
		if (major == null || major.trim().length() == 0)
			throw new InvalidValueException("Major contains an invalid value.");
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.major = major;
	}

	public static void main(String[] args) {
		try {
			Student student = new Student("Robert", "Morgan", 3.5, "BIO");
			student.setFirstName(null);
			student.setLastName("");
			student.setGpa(4.7);
			student.setMajor(" ");
		} catch (InvalidValueException e) {
			System.out.println(
					"ERROR: An invalid value was used to create or modify an student object. ("
							+ e.getMessage() + ")");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}
}
