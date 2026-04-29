package edu.txst.mvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.txst.beverage.*;

class BeverageOrder implements Iterable<Beverage> {
	private List<Beverage> beverages = new ArrayList<>();

	public void addBeverage(Beverage b) {
		beverages.add(b);
	}

	public void clear() {
		beverages.clear();
	}

	public double getTotalCost() {
		double total = 0;
		for (Beverage b : beverages) {
			total += b.cost();
		}
		return total;
	}

	@Override
	public Iterator<Beverage> iterator() {
		return beverages.iterator();
	}
}
