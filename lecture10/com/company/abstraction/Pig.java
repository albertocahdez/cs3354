package com.company.abstraction;

// Pig "implements" the Animal interface
class Pig implements Animal {
	@Override	
  	public void animalSound() {
    	// The body of animalSound() is provided here
    	System.out.println("The pig says: wee wee");
  	}
	@Override
	public void run() {
		// The body of run() is provided here
		Animal.super.run();
    	System.out.println("The pig is running.");
	}

  	public void sleep() { // The body of sleep() is provided here
    	System.out.println("Zzz");
  	}
}