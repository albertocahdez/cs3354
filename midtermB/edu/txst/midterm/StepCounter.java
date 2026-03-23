package edu.txst.midterm;

public class StepCounter {
	private int steps;

	public int getSteps() {
		return steps;
	}

	public void increaseSteps() {
		steps++;
	}

	public void resetSteps() {
		steps = 0;
	}

	public StepCounter() {
		steps = 0;
	}
}
