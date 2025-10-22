package com.company.testing;

public class AssertionExample {
    public static void main(String[] args) {
        int number = 5;

        // Assertion to check if number is positive
        assert number > 0 : "Number is not positive";

        System.out.println("Number is positive: " + number);

        // Let's deliberately fail an assertion
        number = -3;
        assert number > 0 : "Assertion failed: number is not positive";

        System.out.println("This line will not be printed if assertions are enabled.");
    }
} 