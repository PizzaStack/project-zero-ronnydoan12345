package org.revature.com.revature_project;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Account extends BankData {

	void BankAccountLogin() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter s for the single account and enter j for the joint account.");
		String accountchoice = userInput.nextLine();
		System.out.println("Enter the username");
		String username;
		username = userInput.nextLine();

		System.out.println("Enter the password");
		String password;
		password = userInput.nextLine();

		String customertable = String.format(
				"SELECT id, status, username, password, address, phonenumber, socialsecuritynumber, checkingbalance, savingbalance FROM customer WHERE username='%s' AND password = '%s'",
				username, password);
		String jointtable = String.format(
				"SELECT id, address, phonenumber, socialsecuritynumber, jointaddress, jointphonenumber, jointsocialsecuritynumber, checkingbalance, savingbalance FROM jointcustomer WHERE username='%s' AND password = '%s'",
				username, password);

		int singlecheckingindex = 8;
		int singlesavingindex = 9;

		int jointcheckingindex = 8;
		int jointsavingindex = 9;

		if (accountchoice.equals("s")) {
			LogIn(username, password, accountchoice, customertable, singlecheckingindex, singlesavingindex);
		} else if (accountchoice.equals("j")) {

			LogIn(username, password, accountchoice, jointtable, jointcheckingindex, jointsavingindex);

		} else {
			System.out.println("Invalid Choice");

		}
	}

	@Override
	List<Double> Transactions(List<Double> balancelist, int id, String accountchoice) throws SQLException {

		double amount;
		boolean quit = false;
		double checkingbalance = balancelist.get(0);
		double savingbalance = balancelist.get(1);

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);

		do {
			System.out.println("Enter 1 to check the checking balance.");
			System.out.println("Enter 2 to check the saving balance.");
			System.out.println("Enter 3 to Withdraw from checking.");
			System.out.println("Enter 4 to Withdraw from saving.");
			System.out.println("Enter 5 to Deposit to checking .");
			System.out.println("Enter 6 to Deposit to saving .");
			System.out.println("Enter 7 to transfer funds from checking to savings.");
			System.out.println("Enter 8 to transfer funds from savings to checking.");
			System.out.println("Enter 0 to quit.");
			int key = userInput.nextInt();
			switch (key) {
			case 1:
				System.out.println("Your checking balance is: " + checkingbalance);
				break;

			case 2:
				System.out.println("Your saving balance is: " + savingbalance);
				break;

			case 3:
				System.out.println("Now enter the amount you would like to withdraw from checking.");
				amount = userInput.nextDouble();
				if (amount <= 0 || amount > checkingbalance) {
					System.err.println("Cannot run this transaction");

				} else {
					checkingbalance = checkingbalance - amount;
				}
				break;

			case 4:
				System.out.println("Now enter the amount you would like to withdraw from savings.");
				amount = userInput.nextDouble();
				if (amount <= 0 || amount > savingbalance) {
					System.err.println("Cannot run this transaction");

				} else {
					savingbalance = savingbalance - amount;
				}
				break;

			case 5:
				System.out.println("Now enter the amount you would like to deposit to checking.");
				amount = userInput.nextDouble();
				if (amount <= 0) {
					System.err.println("Cannot enter a negative amount!");
				} else {
					checkingbalance = checkingbalance + amount;
				}
				break;

			case 6:
				System.out.println("Now enter the amount you would like to deposit to savings.");
				amount = userInput.nextDouble();
				if (amount <= 0) {
					System.err.println("Cannot enter a negative amount!");
				} else {
					savingbalance = savingbalance + amount;
				}
				break;

			case 7:
				System.out.println("Now enter the amount you would like to transfer from checking to savings.");
				amount = userInput.nextDouble();
				if (amount <= 0 || amount > checkingbalance) {
					System.err.println("Cannot complete transaction!");
				} else {
					savingbalance = savingbalance + amount;
					checkingbalance = checkingbalance - amount;
				}
				break;

			case 8:
				System.out.println("Now enter the amount you would like to transfer from savings to checking.");
				amount = userInput.nextDouble();
				if (amount <= 0 || amount > savingbalance) {
					System.err.println("Cannot complete transaction.");
				} else {
					checkingbalance = checkingbalance + amount;
					savingbalance = savingbalance - amount;
				}
				break;

			case 0:
				quit = true;
				break;

			default:
				System.out.println("You have entered something invalid.");
				break;
			}
		} while (!quit);
		System.out.println("You have successfully quitted.");
		String singlebalancestatement = "UPDATE customer SET checkingbalance= '" + checkingbalance
				+ "',savingbalance = '" + savingbalance + "' WHERE id = " + id;
		String jointbalancestatement = "UPDATE jointcustomer SET checkingbalance= '" + checkingbalance
				+ "',savingbalance = '" + savingbalance + "' WHERE id = " + id;

		String displaysinglestatement = "SELECT username, checkingbalance, savingbalance FROM customer WHERE id = "
				+ id;
		String displayjointstatement = "SELECT username, checkingbalance, savingbalance FROM jointcustomer WHERE id = "
				+ id;

		if (accountchoice.equals("s")) {
			UpdateBalance(singlebalancestatement, displaysinglestatement);
		} else if (accountchoice.equals("j")) {
			UpdateBalance(jointbalancestatement, displayjointstatement);
		} else {
			System.out.println("Invalid Choice");
		}
		return balancelist;

	}

	public Account() {

	}

}
