package edu.txst.nestedClasses;

public class OuterClass {
	private String outerField = "Outer field";

	class InnerClass {

		public void accessMembers() {
			System.out.println(outerField);
		}
	}

	static class StaticNestedClass {

		public void displayMessage() {
			System.out.println("This message is from a static nested classs.");
		}
	}

	public static void main(String[] args) {
		OuterClass.StaticNestedClass staticObject = new OuterClass.StaticNestedClass();
		staticObject.displayMessage();

		OuterClass outerObject = new OuterClass();
		OuterClass.InnerClass innerObject = outerObject.new InnerClass();
		innerObject.accessMembers();
	}
}
