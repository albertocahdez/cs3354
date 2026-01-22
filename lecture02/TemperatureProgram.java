import java.util.Scanner;

public class TemperatureProgram {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int degrees;

		// Read degrees Fahrenheit
		System.out.print("Enter the degrees Fahrenheit: ");
		degrees = keyboard.nextInt();
		// Classify degrees value
		if ( degrees <= 32 ) {
			System.out.println("Freezing");
		} else if ( degrees <= 50 ) {
			System.out.println("Cold");
		} else if ( degrees <= 85 ) {
			System.out.println("Warm");
		} else {
			System.out.println("Hot");
		}
		// Close keyboard
		keyboard.close();
	}
}
