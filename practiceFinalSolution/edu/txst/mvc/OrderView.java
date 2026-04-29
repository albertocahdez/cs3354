package edu.txst.mvc;

import javax.swing.*;
import java.awt.*;
import edu.txst.beverage.Beverage;

class OrderView extends JFrame {
	private JTextArea orderDisplay = new JTextArea(10, 30);
	private JLabel totalLabel = new JLabel("Total: $0.00");

	// UI Components for the Controller to access
	public JButton btnEspresso = new JButton("Espresso ($1.60)");
	public JButton btnHouseBlend = new JButton("House Blend ($0.89)");
	public JCheckBox chkMilk = new JCheckBox("Milk ($0.10)");
	public JCheckBox chkMocha = new JCheckBox("Mocha ($0.20)");
	public JCheckBox chkWhip = new JCheckBox("Whip ($0.30)");
	public JButton btnClear = new JButton("Clear Order");

	public OrderView() {
		setTitle("Starbuzz Coffee Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));

		// Controls Panel
		JPanel controls = new JPanel(new GridLayout(0, 1, 5, 5));
		controls.setBorder(BorderFactory.createTitledBorder("Place Order"));
		controls.add(new JLabel("Add extras before coffee."));
		controls.add(btnEspresso);
		controls.add(btnHouseBlend);
		controls.add(new JLabel("Extras:"));
		controls.add(chkMilk);
		controls.add(chkMocha);
		controls.add(chkWhip);
		controls.add(btnClear);

		// Display Panel
		orderDisplay.setEditable(false);
		JPanel displayPanel = new JPanel(new BorderLayout());
		displayPanel.add(new JScrollPane(orderDisplay), BorderLayout.CENTER);
		displayPanel.add(totalLabel, BorderLayout.SOUTH);
		totalLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

		add(controls, BorderLayout.WEST);
		add(displayPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}

	public void updateView(BeverageOrder order) {
		StringBuilder sb = new StringBuilder("Current Order Items:\n");
		sb.append("----------------------------\n");

		// Using the Iterator Pattern to traverse the model
		for (Beverage b : order) {
			sb.append(String.format("- %s ($%.2f)\n", b.getDescription(), b.cost()));
		}

		orderDisplay.setText(sb.toString());
		totalLabel.setText(String.format("Total: $%.2f", order.getTotalCost()));
	}
}
