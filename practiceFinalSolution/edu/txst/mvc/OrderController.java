package edu.txst.mvc;

import edu.txst.beverage.*;
import edu.txst.decorator.*;
import edu.txst.factory.*;

class OrderController {
	private BeverageOrder model;
	private OrderView view;

	public OrderController(BeverageOrder model, OrderView view) {
		this.model = model;
		this.view = view;

		// Attach listeners
		view.btnEspresso.addActionListener(e -> addCoffee("Espresso"));
		view.btnHouseBlend.addActionListener(e -> addCoffee("House Blend"));
		view.btnClear.addActionListener(e -> {
			model.clear();
			view.updateView(model);
		});
	}

	private void addCoffee(String type) {
		// Factory Method
		Beverage b = BeverageFactory.createBeverage(type);

		// Decorator Logic
		if (view.chkMilk.isSelected())
			b = new Milk(b);
		if (view.chkMocha.isSelected())
			b = new Mocha(b);
		if (view.chkWhip.isSelected())
			b = new Whip(b);

		model.addBeverage(b);
		view.updateView(model);

		// Reset checkboxes
		view.chkMilk.setSelected(false);
		view.chkMocha.setSelected(false);
		view.chkWhip.setSelected(false);
	}
}
