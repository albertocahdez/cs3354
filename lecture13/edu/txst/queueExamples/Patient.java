package edu.txst.queueExamples;

class Patient {
	String name;
	int severity; // 1 (Minor) to 5 (Critical)

	public Patient(String name, int severity) {
		this.name = name;
		this.severity = severity;
	}

	@Override
	public String toString() {
		return name + " (Severity: " + severity + ")";
	}
}
