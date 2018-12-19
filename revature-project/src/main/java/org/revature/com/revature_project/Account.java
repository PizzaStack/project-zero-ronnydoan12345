package org.revature.com.revature_project;

public class Account {
	
	String userName;
	String passWord;
	
	
	private double checkingBalance;
	private double savingBalance;
	
	public Account(String userName, String passWord) {
		checkingBalance = 0.00;
		savingBalance =0.00;
		this.userName = userName;
		this.passWord = passWord;
		
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
	 void transferFundsCheckingToSavings(double amount) {
		if(amount<=0 || amount > checkingBalance) {
			System.err.println("Cannot complete transaction!");
		}else {
			savingBalance = savingBalance + amount;
			checkingBalance = checkingBalance - amount;
		}
	}
	
	 void transferFundsSavingToChecking(double amount) {
		if(amount<=0 || amount > savingBalance) {
			System.err.println("Cannot complete transaction.");
		}else {
			checkingBalance = checkingBalance + amount;
			savingBalance = savingBalance - amount;
		}
	}
	
	 void deposit(double amount) {
		if(amount<=0) {
			System.err.println("Cannot enter a negative amount!");
		}else {
			checkingBalance = checkingBalance + amount;

		}
		
	}
	
	 void withdraw(double amount) {
		
		
		if(amount<=0 || amount > checkingBalance) {
			System.err.println("Cannot run this transaction");

		}else {
			checkingBalance = checkingBalance - amount;
		}
		
	}
	
}
