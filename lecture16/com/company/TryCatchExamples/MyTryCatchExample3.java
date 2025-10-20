package com.company.TryCatchExamples;

import java.util.Scanner;

public class MyTryCatchExample3 {

    public class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyTryCatchExample3 example = new MyTryCatchExample3();

        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            example.setAge(number);
            System.out.println("Age is " + number);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}