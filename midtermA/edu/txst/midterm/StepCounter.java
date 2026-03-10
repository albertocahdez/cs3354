package edu.txst.midterm;

public class StepCounter {
	private int currentSteps;
	private int maxSteps;

	public int getMaxSteps() {
		return maxSteps;
	}

	public int getRemainingSteps() {
		return maxSteps - currentSteps;
	}

	public void increaseSteps() {
		currentSteps++;
		if (currentSteps > maxSteps)
			currentSteps = maxSteps;

	}

	public void decreaseSteps(int amount) {
		currentSteps -= amount;
		if (currentSteps < 0)
			currentSteps = 0;
	}

	public void resetSteps() {
		currentSteps = 0;
	}

	public StepCounter(int maxSteps) {
		if (maxSteps < 1) {
			maxSteps = 1;
		}
		currentSteps = 0;
	}
}
