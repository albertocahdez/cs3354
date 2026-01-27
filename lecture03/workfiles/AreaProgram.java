import java.util.Scanner;

public class AreaProgram {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int option;

		do {
			System.out
					.print("=== AREA CALCULATOR ===\n1. Square\n2. Circle\n3. Triangle\n4. Exit\n");
			System.out.print("Enter the desired option[1-4]: ");
			option = keyboard.nextInt();
		} while (option != 4);
		keyboard.close();
	}
}
