package edu.txst.factory;

import edu.txst.beverage.*;

public class BeverageFactory {
	public static Beverage createBeverage(String type) {
		if (type.equalsIgnoreCase("Espresso"))
			return new Espresso();
		if (type.equalsIgnoreCase("House Blend"))
			return new HouseBlend();
		return null;
	}
}
