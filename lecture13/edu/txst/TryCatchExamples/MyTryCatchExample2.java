package com.company.TryCatchExamples;

import java.util.Scanner;

public class MyTryCatchExample2 {
    public static void main(String[] args) throws ArithmeticException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int result = 10 / number;
        System.out.println("Result is: " + result);
        System.out.println("Execution completed.");
        scanner.close();
    }
}