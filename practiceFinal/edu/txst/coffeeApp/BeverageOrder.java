package edu.txst.coffeeApp;

import java.util.List;
import java.util.ArrayList;

class BeverageOrder {
	// Direct access to the list (No Iterator pattern)
	public List<BeverageItem> items = new ArrayList<>();

	public void addItem(BeverageItem item) {
		items.add(item);
	}

	public void clear() {
		items.clear();
	}

	public double getTotalOrderCost() {
		double total = 0;
		for (BeverageItem item : items) {
			total += item.getPrice();
		}
		return total;
	}
}
