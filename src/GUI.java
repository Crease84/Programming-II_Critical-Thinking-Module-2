import javax.swing.*;
import java.awt.event.*;

public class GUI {
/*
* Christopher Cabrera
* CSC372 / Programming II
* November 23th, 2025
* 
* This program demonstrates a bank account system through a GUI system
*  deposits and withdrawals, and shows balances.
*/
	private static JFrame frame;
	
	private static JPanel initPanel;
	private static JPanel mainPanel;
	
	private static JTextField firstNameText;
	private static JTextField lastNameText;
	private static JTextField balanceText;
	
	private String userFirstName;
	private String userLastName;
	private double userBalance;
	
	BankAccount myAccount = new BankAccount();
	
	public GUI() {
		
		initPanel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Banking App");
		frame.setSize(290, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(initPanel);
		
		initPanel.setLayout(null);
		
		JLabel header1 = new JLabel("Welcome to Bank 'R' Us");
		header1.setBounds(60, 5, 165, 25);
		initPanel.add(header1);
		
		JLabel firstNameLabel = new JLabel("First name:");
		firstNameLabel.setBounds(10, 30, 80, 25);
		initPanel.add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last name:");
		lastNameLabel.setBounds(10, 60, 80, 25);
		initPanel.add(lastNameLabel);
		
		firstNameText = new JTextField();
		firstNameText.setBounds(80, 30, 165, 25);
		initPanel.add(firstNameText);
		
		lastNameText = new JTextField();
		lastNameText.setBounds(80, 60, 165, 25);
		initPanel.add(lastNameText);
		
		JLabel balance = new JLabel("Balance:");
		balance.setBounds(10, 90, 80, 25);
		initPanel.add(balance);
		
		balanceText = new JTextField();
		balanceText.setBounds(80, 90, 165, 25);
		initPanel.add(balanceText);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(100, 120, 80, 25);
		initPanel.add(nextButton);
		
		mainPanel = new JPanel();
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFirstName = firstNameText.getText();
				userLastName = lastNameText.getText();
				userBalance = Double.parseDouble(balanceText.getText());
				
				myAccount.update(userFirstName, userLastName, userBalance);
				myAccount.printSummary();
				
				goToMainPanel();
				
			}
		});
		
		JButton withdraw = new JButton("Withdraw");
		withdraw.setBounds(20, 80, 100, 25);
		mainPanel.add(withdraw);
		
		JButton deposit = new JButton("Deposit");
		deposit.setBounds(150, 80, 100, 25);
		mainPanel.add(deposit);
		
		JTextField moneyText = new JTextField();
		moneyText.setBounds(95, 35, 115, 25);
		mainPanel.add(moneyText);
		
		JLabel money = new JLabel("Enter Amount:");
		money.setBounds(10, 35, 80, 25);
		mainPanel.add(money);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(100, 120, 80, 25);
		mainPanel.add(exit);
		
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double userMoney = Double.parseDouble(moneyText.getText());
				
				if (!myAccount.withdraw(userMoney)) {
					JOptionPane.showMessageDialog(frame, "Insufficient funds");
				}
				else {
					String formatted = String.format("%.2f", myAccount.getBalance());
					JOptionPane.showMessageDialog(frame, "Money withdrawn\n" + "Balance: $" + formatted);
				}
				moneyText.setText("");
				
			}
		});
		
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double userMoney = Double.parseDouble(moneyText.getText());
				String formatted = String.format("%.2f", myAccount.getBalance());
				JOptionPane.showMessageDialog(frame, "Money deposited\n" + "Balance: $" + formatted);
				
				myAccount.deposit(userMoney);
				moneyText.setText("");
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String formatted = String.format("%.2f", myAccount.getBalance());
				JOptionPane.showMessageDialog(frame, "Final Balance: $" + formatted);
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();

	}
	
	public void goToMainPanel() {
		mainPanel.setLayout(null);
		JLabel welcome = new JLabel("Welcome " + userFirstName + " " + userLastName);

        mainPanel.add(welcome);
		welcome.setBounds(10, 5, 200, 25);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(mainPanel);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
	}


}
