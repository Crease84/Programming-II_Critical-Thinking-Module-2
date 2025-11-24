/*
 * Represents basic bank account with owner information and a balance
 * Provides methods for updating and viewing account information
 * 
 * Now updated to work with my GUI
 * 
 * @author Christopher Cabrera
 * @version 11/23/2025
 */
public class BankAccount {
	private String firstName;
	private String lastName;
	private double balance;
	
	public BankAccount() {
		this.firstName = "Unknown";
		this.lastName = "Unknown";
		this.balance = 0.0;
	}
	
	public void update(String firstName, String lastName, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		
		System.out.println("Updated!");
	}
	
	public void printSummary() {
		System.out.printf(this.firstName + " " + this.lastName + "\n"
				+ "Balance: $%.2f" + "\n", this.balance);
	}
	
	public void deposit(double money) {
		this.balance = this.balance + money;
		
		System.out.println("Money successfully deposited");
		printBal();
	}
	
	public Boolean withdraw(double money) {
		if ((this.balance - money) > 0) {
			this.balance = this.balance - money;
			System.out.println("Money successfully withdrawn");
			printBal();
			return true;
		}
		else {
			System.out.println("Insufficiant funds");
			return false;
		}
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void printBal() {
		System.out.printf("Balance: $%.2f" + "\n", this.balance);
	}
}
