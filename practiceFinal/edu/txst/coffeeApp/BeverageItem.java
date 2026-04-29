package edu.txst.coffeeApp;

// Simple data class representing a single coffee in the order
class BeverageItem {
	String type;
	double basePrice;
	boolean hasMilk;
	boolean hasMocha;
	boolean hasWhip;

	public BeverageItem(String type, double basePrice, boolean milk, boolean mocha, boolean whip) {
		this.type = type;
		this.basePrice = basePrice;
		this.hasMilk = milk;
		this.hasMocha = mocha;
		this.hasWhip = whip;
	}

	public double getPrice() {
		double total = basePrice;
		if (hasMilk)
			total += 0.10;
		if (hasMocha)
			total += 0.20;
		if (hasWhip)
			total += 0.30;
		return total;
	}

	public String toString() {
		String desc = type;
		if (hasMilk)
			desc += ", Milk";
		if (hasMocha)
			desc += ", Mocha";
		if (hasWhip)
			desc += ", Whip";
		return desc;
	}
}
