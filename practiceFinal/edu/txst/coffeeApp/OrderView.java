package edu.txst.coffeeApp;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

class OrderView extends JFrame {
	public JTextArea display = new JTextArea(10, 30);
	public JLabel totalLabel = new JLabel("Total: $0.00");
	public JButton btnEspresso = new JButton("Espresso ($1.60)");
	public JButton btnHouseBlend = new JButton("House Blend ($0.89)");
	public JCheckBox chkMilk = new JCheckBox("Milk ($0.10)");
	public JCheckBox chkMocha = new JCheckBox("Mocha ($0.20)");
	public JCheckBox chkWhip = new JCheckBox("Whip ($0.30)");
	public JButton btnClear = new JButton("Clear Order");

	public OrderView() {
		setTitle("Simple Coffee Order (No Patterns)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));

		JPanel controls = new JPanel(new GridLayout(0, 1, 5, 5));
		controls.add(new JLabel("Add extras before coffee."));
		controls.add(btnEspresso);
		controls.add(btnHouseBlend);
		controls.add(new JLabel("Extras:"));
		controls.add(chkMilk);
		controls.add(chkMocha);
		controls.add(chkWhip);
		controls.add(btnClear);

		display.setEditable(false);
		add(controls, BorderLayout.WEST);

		JPanel displayPanel = new JPanel(new BorderLayout());
		displayPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		displayPanel.add(totalLabel, BorderLayout.SOUTH);
		totalLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

		add(displayPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}

	public void updateDisplay(BeverageOrder order) {
		StringBuilder sb = new StringBuilder("Order Details:\n");
		// Directly iterating over the public list
		for (int i = 0; i < order.items.size(); i++) {
			BeverageItem item = order.items.get(i);
			sb.append("- ").append(item.toString()).append(" ($")
					.append(String.format("%.2f", item.getPrice())).append(")\n");
		}
		display.setText(sb.toString());
		totalLabel.setText(String.format("Total: $%.2f", order.getTotalOrderCost()));
	}
}
