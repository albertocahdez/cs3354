package edu.txst.coffeeApp;

class OrderController {
	private BeverageOrder model;
	private OrderView view;

	public OrderController(BeverageOrder model, OrderView view) {
		this.model = model;
		this.view = view;

		// Direct instantiation logic instead of Factory/Decorator
		view.btnEspresso.addActionListener(e -> addCoffee("Espresso", 1.60));
		view.btnHouseBlend.addActionListener(e -> addCoffee("House Blend", 0.89));
		view.btnClear.addActionListener(e -> {
			model.clear();
			view.updateDisplay(model);
		});
	}

	private void addCoffee(String type, double price) {
		// Create the item directly
		BeverageItem newItem = new BeverageItem(type, price, view.chkMilk.isSelected(),
				view.chkMocha.isSelected(), view.chkWhip.isSelected());

		model.addItem(newItem);
		view.updateDisplay(model);

		// Reset checkboxes
		view.chkMilk.setSelected(false);
		view.chkMocha.setSelected(false);
		view.chkWhip.setSelected(false);
	}
}


public class SimpleCoffeeApp {
	public static void main(String[] args) {
		BeverageOrder model = new BeverageOrder();
		OrderView view = new OrderView();
		new OrderController(model, view);
		view.setVisible(true);
	}
}
