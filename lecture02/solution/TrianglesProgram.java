import java.util.Scanner;

public class TrianglesProgram {
	public static void main(String[] args) {
		final int GAP_SIZE = 2;
		Scanner keyboard = new Scanner(System.in);
		int size;

		// read size
		System.out.println("Enter the size of the triangle [3-5]: ");
		size = keyboard.nextInt();
		// draw top triangles
		for (int row = 0; row < size; row++) {
			//// draw white spaces
			for (int column = 0; column < size - row - 1; column++) {
				System.out.print(" ");
			}
			//// draw first triangle stars
			for (int column = 0; column < row + 1; column++) {
				System.out.print("*");
			}
			//// draw vertical gap
			for (int column = 0; column < GAP_SIZE; column++) {
				System.out.print(" ");
			}
			//// draw second triangle stars
			for (int column = 0; column < row + 1; column++) {
				System.out.print("*");
			}
			// move to next line
			System.out.println();
		}
		// draw horizontal gap
		for (int column = 0; column < GAP_SIZE / 2; column++) {
			System.out.println();
		}
		// draw bottom triangles
		for (int row = 0; row < size; row++) {
			//// draw white spaces
			for (int column = 0; column < row; column++) {
				System.out.print(" ");
			}
			//// draw third triangle stars
			for (int column = size; column > row; column--) {
				System.out.print("*");
			}
			//// draw vertical gap
			for (int column = 0; column < GAP_SIZE; column++) {
				System.out.print(" ");
			}
			//// draw fourth triangle stars
			for (int column = size; column > row; column--) {
				System.out.print("*");
			}

			// WRITE YOUR CODE HERE

			// move to next line
			System.out.println();
		}
	}
}
