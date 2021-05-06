package Feb25_BankProject;

import java.util.*;
import java.text.NumberFormat;

public class Bank {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//Customer cust = new Customer ("John", "Smith", "Toronto");
		
		//System.out.println(cust);
		
		Account custAccount = new Account (250.75, "John", "Smith", "Toronto");
		
		System.out.println(custAccount);
		
		double amount;
		System.out.println("Enter the amount of deposit:");
		amount = input.nextDouble();
		
		double balance = custAccount.deposit(amount);
		
		NumberFormat money = NumberFormat.getCurrencyInstance();
		System.out.println("Balance is " + money.format(balance));

	}

}
