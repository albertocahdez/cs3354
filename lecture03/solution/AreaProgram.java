import java.util.Scanner;

/**
 * AreaProgram is an application that can calculate the area of multiple 2D shapes.
 */
public class AreaProgram {
	/**
	 * It executes the full area application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int option;
		double area;

		do {
			System.out
					.print("=== AREA CALCULATOR ===\n1. Square\n2. Circle\n3. Triangle\n4. Exit\n");
			System.out.print("Enter the desired option[1-4]: ");
			option = keyboard.nextInt();
			if (option < 1 || option > 4)
				System.out.println(
						"Error. Invalid input. Provide a valid option between 1 and 4 inclusive.");
			else
				switch (option) {
					case 1:
						System.out.print("--- Area of a Square ---\nEnter the square's lenght: ");
						double length = keyboard.nextDouble();
						area = Math.pow(length, 2);
						System.out.println("Square's area is: " + area);
						break;
					case 2:
						System.out.print("--- Area of a Circle ---\nEnter the cirle's radius: ");
						double radius = keyboard.nextDouble();
						area = Math.pow(radius, 2) * Math.PI;
						System.out.println("Circle's area is: " + area);
						break;
					case 3:
						System.out.print("--- Area of a Triangle ---\nEnter the triangle's base: ");
						double base = keyboard.nextDouble();
						System.out.print(
								"--- Area of a Triangle ---\nEnter the triangle's height measure: ");
						double height = keyboard.nextDouble();
						area = base * height / 2.0;
						System.out.println("Triangles's area is: " + area);
						break;
				}
		} while (option != 4);
		keyboard.close();
	}
}
