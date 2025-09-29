package com.company.abstraction;

public interface Animal {
	String DEFAULT_MESSAGE = "Hello";
	public void animalSound(); // interface method (does not have a body)
	public default void run() { // interface method (does not have a body)
		System.out.println("Animal is running.");
	}
}
