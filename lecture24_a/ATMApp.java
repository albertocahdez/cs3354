import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Container;

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
	private JPanel topPanel, centerPanel, keyPad, bottomPanel;
	private JTextField inputBox;
	private JTextArea messageBox;
	private JButton buttonA, buttonB, buttonC;
	private ATM theATM;

	public ATMApp(ATM atm) {
		// setup
		theATM = atm;

		// JFrame
		setTitle("ATM");
		setSize(new Dimension(500,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
 
		// set panels
		setTopPanel();
 		setCenterPanel();
		setBottomPanel();
	
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
			ATM theATM = new ATM(theBank);
			
			SwingUtilities.invokeLater(() -> new ATMApp(theATM));
		}
		catch(IOException e)
		{  
			System.out.println("Error opening accounts file.");
			return;
		}
	}
	
	private void setTopPanel() {
		// inputBox
		topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputBox = new JTextField();
		inputBox.setPreferredSize(new Dimension(200,40));
		inputBox.setHorizontalAlignment(JTextField.RIGHT);
		inputBox.setEnabled(false);
		topPanel.add(inputBox);
	}

	private void setCenterPanel() {
		// keyPad
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		keyPad = new JPanel(new GridLayout(0, 3));
		
		for (int i=1; i<10; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.addActionListener( e -> { if ( inputBox.getText().length() <= 6 ) inputBox.setText( inputBox.getText() + button.getText() ); } );
			keyPad.add(button);
		}
		 
		JButton cButton = new JButton("C");
		cButton.addActionListener( e -> inputBox.setText("") );
		keyPad.add(cButton);
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener( e -> { if ( inputBox.getText().length() <= 6 ) inputBox.setText( inputBox.getText() + "0" ); } );
		keyPad.add(zeroButton);
		centerPanel.add(keyPad);
	}

	private void setKeyPadEnable(boolean b) {
		Container c = keyPad;
		for (Component comp : c.getComponents()) {
			comp.setEnabled(b);
		}
	}

	private void setActionButtonsEnable(boolean bA, boolean bB, boolean bC) {
		buttonA.setEnabled(bA);
		buttonB.setEnabled(bB);
		buttonC.setEnabled(bC);
	}

	private void setGUIState(int state) {
		if ( state == ATM.START ) {
			inputBox.setText("");
			setKeyPadEnable(true);
			setActionButtonsEnable(true, false, false);
			messageBox.setText("Enter customer number.\nA = OK");	
		} else if ( state == ATM.PIN ) {
			inputBox.setText("");
			setKeyPadEnable(true);
			setActionButtonsEnable(true, false, false);
			messageBox.setText("Enter PIN.\nA = OK");	
		} else if ( state == ATM.ACCOUNT ) {
			inputBox.setText("");
			setKeyPadEnable(false);
			setActionButtonsEnable(true, true, true);
			messageBox.setText("A = Checking, B = Savings, C = Quit");
		} else if ( state == ATM.TRANSACT ) {
			inputBox.setText("");
			setKeyPadEnable(false);
			setActionButtonsEnable(true, true, true);
			messageBox.setText( "Balance=" + theATM.getBalance() + "\nA=Deposit, B=Withdrawal, C=Cancel.");
		} else if ( state == ATM.TRANSACT_DEPOSIT ) {
			inputBox.setText("");
			setKeyPadEnable(true);
			setActionButtonsEnable(true, true, false);
			messageBox.setText("Enter deposit amount.\nA = OK, B = Cancel");
		} else if ( state == ATM.TRANSACT_WITHDRAW ) {
			inputBox.setText("");
			setKeyPadEnable(true);
			setActionButtonsEnable(true, true, false);
			messageBox.setText("Enter withdrawal amount.\nA = OK, B = Cancel");
		}
	}

	private void setBottomPanel() {
		// messageBox and controls
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel bottomContainer = new JPanel();
		bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
		messageBox = new JTextArea("");
		messageBox.setPreferredSize(new Dimension(250, 80));
		messageBox.setEnabled(false);
		bottomContainer.add(messageBox);
		 
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonA = new JButton("A");
		buttonB = new JButton("B");
		buttonC = new JButton("C");
		
		buttonA.addActionListener(e -> {
			if ( theATM.getState() == ATM.START ) {
				if ( inputBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(this, "No customer number provided.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					theATM.setCustomerNumber( Integer.parseInt(inputBox.getText()) );
					setGUIState(theATM.getState());
				}
			} else if ( theATM.getState() == ATM.PIN ) {
				if ( inputBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(this, "No customer PIN provided.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					theATM.selectCustomer( Integer.parseInt(inputBox.getText()) );
					setGUIState(theATM.getState());
				}
			} else if ( theATM.getState() == ATM.ACCOUNT ) {
				theATM.selectAccount(ATM.CHECKING);
				setGUIState(theATM.getState());
			} else if ( theATM.getState() == ATM.TRANSACT ) {
				theATM.selectTransaction(ATM.TRANSACT_DEPOSIT);
				setGUIState(theATM.getState());
			} else if ( theATM.getState() == ATM.TRANSACT_DEPOSIT || theATM.getState() == ATM.TRANSACT_WITHDRAW ) {
				if ( inputBox.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(this, "No transaction amount provided", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					double amount = Double.parseDouble( inputBox.getText() );
					if ( theATM.getState() == ATM.TRANSACT_DEPOSIT ) {
						theATM.deposit(amount);
					} else {
						theATM.withdraw(amount);
					}
					theATM.back();
					setGUIState(theATM.getState());
				}
				
			}
		});

		buttonB.addActionListener( e -> {
			if ( theATM.getState() == ATM.ACCOUNT ) {
				theATM.selectAccount(ATM.SAVINGS);
				setGUIState(theATM.getState());
			} else if ( theATM.getState() == ATM.TRANSACT ) {
				theATM.selectTransaction(ATM.TRANSACT_WITHDRAW);
				setGUIState(theATM.getState());
			} else if ( theATM.getState() == ATM.TRANSACT_DEPOSIT || theATM.getState() == ATM.TRANSACT_WITHDRAW ) {
				theATM.back();
				setGUIState(theATM.getState());
			}
		});

		buttonC.addActionListener( e -> {
			if ( theATM.getState() == ATM.ACCOUNT ) {
				theATM.back();
				setGUIState(theATM.getState());
			} else if ( theATM.getState() == ATM.TRANSACT ) {
				theATM.back();
				setGUIState(theATM.getState());
			}
		});
		
		buttonsPanel.add(buttonA);
		buttonsPanel.add(buttonB);
		buttonsPanel.add(buttonC);

		setGUIState(ATM.START);
		
		bottomContainer.add(buttonsPanel);
		bottomPanel.add(bottomContainer);
	}


}