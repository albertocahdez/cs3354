package edu.txst.mvc;

import javax.swing.SwingUtilities;

public class CoffeeApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BeverageOrder model = new BeverageOrder();
			OrderView view = new OrderView();
			new OrderController(model, view);
			view.setVisible(true);
		});
	}
}
