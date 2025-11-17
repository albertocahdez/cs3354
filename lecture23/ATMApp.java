import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class ATMApp extends JFrame {
	JTextField amountBox;
	JTextArea messageBox;
	ATM theATM;
	
	public ATMApp(Bank bank) {
		// setup
		theATM = new ATM(bank);

		// JFrame
		setTitle("ATM");
		setSize(new Dimension(500,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// amountBox
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		amountBox = new JTextField();
		amountBox.setPreferredSize(new Dimension(200,40));
		amountBox.setHorizontalAlignment(JTextField.RIGHT);
		amountBox.setEnabled(false);
		topPanel.add(amountBox);

		// keyPad
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel keyPad = new JPanel(new GridLayout(0, 3));
		
		for (int i=1; i<10; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.addActionListener( e -> { if ( amountBox.getText().length() <= 6 ) amountBox.setText( amountBox.getText() + button.getText() ); } );
			keyPad.add(button);
		}
		JButton cButton = new JButton("C");
		cButton.addActionListener( e -> amountBox.setText("") );
		keyPad.add(cButton);
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener( e -> { if ( amountBox.getText().length() <= 6 ) amountBox.setText( amountBox.getText() + "0" ); } );
		keyPad.add(zeroButton);
		centerPanel.add(keyPad);

		// messageBox and controls
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel bottomContainer = new JPanel();
		bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
		messageBox = new JTextArea("");
		messageBox.setPreferredSize(new Dimension(250, 80));
		messageBox.setEnabled(false);
		messageBox.setText("Enter customer number. A = OK");	
		bottomContainer.add(messageBox);
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton buttonA = new JButton("A");
		buttonA.setEnabled(true);
		JButton buttonB = new JButton("B");
		buttonB.setEnabled(false);
		JButton buttonC = new JButton("C");
		buttonC.setEnabled(false);
		buttonA.addActionListener( e -> {
			if ( theATM.getState() == ATM.START ) {
				if ( amountBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(null, "No customer number provided.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					theATM.setCustomerNumber( Integer.parseInt(amountBox.getText()) );
					messageBox.setText("Enter PIN. A = OK");	
					amountBox.setText("");
					buttonB.setEnabled(false);
					buttonC.setEnabled(false);
				}
			} else if ( theATM.getState() == ATM.PIN ) {
				if ( amountBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(null, "No customer PIN provided.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					theATM.selectCustomer( Integer.parseInt(amountBox.getText()) );
					amountBox.setText("");
					if ( theATM.getState() == ATM.START ) {
						messageBox.setText("Enter customer number. A = OK");	
						buttonB.setEnabled(false);
						buttonC.setEnabled(false);
					} else {
						messageBox.setText("A = Checking, B = Savings, C = Quit");	
						buttonB.setEnabled(true);
						buttonC.setEnabled(true);
					}
				}
			} else if ( theATM.getState() == ATM.ACCOUNT ) {
				theATM.selectAccount(ATM.CHECKING);
				messageBox.setText( "Balance=" + theATM.getBalance() + "\nA=Deposit, B=Withdrawal, C=Cancel.");
			} else if ( theATM.getState() == ATM.TRANSACT ) {
				messageBox.setText("Enter deposit amount. A = OK, B = Cancel");
				theATM.selectTransaction(ATM.TRANSACT_DEPOSIT);
			} else if ( theATM.getState() == ATM.TRANSACT_DEPOSIT || theATM.getState() == ATM.TRANSACT_WITHDRAW ) {
				if ( amountBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(null, "No transaction amount provided", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					double amount = Double.parseDouble( amountBox.getText() );
					if ( theATM.getState() == ATM.TRANSACT_DEPOSIT ) {
						theATM.deposit(amount);
					} else {
						theATM.withdraw(amount);
					}
					theATM.back();
					messageBox.setText( "Balance=" + theATM.getBalance() + "\nA=Deposit, B=Withdrawal, C=Cancel.");
				}
				
			}
		});
		
		buttonsPanel.add(buttonA);
		buttonsPanel.add(buttonB);
		buttonsPanel.add(buttonC);
		bottomContainer.add(buttonsPanel);
		bottomPanel.add(bottomContainer);

		// adding things
		this.add(topPanel, BorderLayout.PAGE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {  
			Bank theBank = new Bank();
			theBank.readCustomers("customers.txt");
			//theATM = new ATM(theBank);
			
			SwingUtilities.invokeLater(() -> new ATMApp(theBank));
		}
		catch(IOException e)
		{  
			System.out.println("Error opening accounts file.");
			return;
		}
	}
}