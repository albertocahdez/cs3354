package projectA.miscellaneous;

public class PersonType {
	private String firstName, middleName, lastName;

	public void setName(String firstName) {
		this.firstName = firstName;
	}
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setName(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFullName() {
		String fullName = firstName;
		if (middleName != "" ) fullName += " " + middleName;
		if (lastName != "" ) fullName += " " + lastName;
		return fullName;
	}

	public PersonType(String firstName) {
		this.firstName = firstName;
		this.middleName = "";
		this.lastName = "";
	}
	public PersonType(String firstName, String lastName) {
		this.firstName = firstName;
		this.middleName = "";
		this.lastName = lastName;
	}
	public PersonType(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
}
