package com.company.TryCatchExamples;

import java.util.Scanner;

public class MyTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(scanner.nextLine());
            int result = 10 / number;
            System.out.println("Result is: " + result);
        } catch (ArithmeticException e) {   // Enter a zero to raise this exception
            System.out.println("Error: Cannot divide by zero.");
        } catch (NumberFormatException e) { // Enter a word (such as abc) to raise this exception
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            System.out.println("Execution completed.");
            scanner.close();
        }
    }
}