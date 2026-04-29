package edu.txst.decorator;

import edu.txst.beverage.Beverage;

abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}
