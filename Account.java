package Feb25_BankProject;

import java.text.NumberFormat;

public class Account {
	private double balance;
	private Customer cust;
	
	//constructor
	public Account (double balance, String fName, String lName, String city) {
		this.balance = balance;
		this.cust = new Customer (fName, lName, city);
	}
	
	public double deposit(double amt) {
		balance += amt;
		
		return balance;
	}
	
	public double withdrawal (double amt) {
		if (amt < balance)
			balance -= amt;
		else
			System.out.println("You dont have enough money.");
		
		return balance;
	}
	
	public String toString() {
		String accountString;
		
		NumberFormat money = NumberFormat.getCurrencyInstance();
		accountString = cust.toString();
		accountString += ("\nBalance is " + money.format(balance));
		
		return accountString;
	}
	
}
