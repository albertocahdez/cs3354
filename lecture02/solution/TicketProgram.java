import java.util.Scanner;

public class TicketProgram {
	public static void main(String[] args) {
		final int TICKET_COST = 15;	// This is a constant
		Scanner keyboard = new Scanner(System.in);	// Create an object to read the input from the keyboard
		int tickets;	// integer variable
		double total;	// double variable
		
		System.out.print("Enter the number of tickets: ");	// print a message
		tickets = keyboard.nextInt();	// read the number of tickets from user input
		total = tickets * TICKET_COST;	// compute total
		System.out.println("Total is $ " + total);	// display total
		keyboard.close();	// close keyboard
	}
}