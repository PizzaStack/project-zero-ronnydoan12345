package org.revature.com.revature_project;

import java.sql.SQLException;
import java.util.Scanner;

public class BankAdmin extends Account {

	public BankAdmin() {

	}

	void ManageAccounts() throws SQLException {
		boolean quit = false;
		@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
		int id;

		String customerTableStatement = "SELECT * FROM customer";
		String jointcustomerTableStatement = "SELECT * FROM jointcustomer";

		do {
			System.out.println("Enter 1 to view customer accounts: ");
			System.out.println("Enter 2 to view joint customer accounts: ");
			System.out.println("Enter 3 manage status of bank accounts.");
			System.out.println("Enter 4 to manage bank accounts");
			System.out.println("Enter 5 to cancel customer accounts: ");
			System.out.println("Enter 6 to cancel joint customer accounts: ");
			System.out.println("Enter 0 to quit.");

			int key = userinput.nextInt();

			switch (key) {
			case 1:
				AccountLookUp(customerTableStatement);
				break;
			case 2:
				AccountLookUp(jointcustomerTableStatement);
				break;
			case 3:
				ManageAccountStatus();
				break;
			case 4:
				BankAccountLogin();
				break;
			case 5:
				System.out.println("Enter customer id number: ");
				id = userinput.nextInt();
				String cancelCustomerAccount = "DELETE FROM customer WHERE id = " + id;
				CancelAccount(cancelCustomerAccount);
				break;
			case 6:
				System.out.println("Enter joint customer id number: ");
				id = userinput.nextInt();
				String cancelJointAccount = "DELETE FROM jointcustomer WHERE id = " + id;
				CancelAccount(cancelJointAccount);
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (!quit);
		System.out.println("You have successfully quitted");
		App.DisplayMenu();
	}

	protected void ManageAccountStatus() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
		String ApprovedStatus = "Approved";
		String DeniedStatus = "Denied";
		int id;

		String displaystatement;

		boolean quit = false;
		do {
			System.out.println("Enter 1 to approve customer accounts.");
			System.out.println("Enter 2 to deny customer accounts.");
			System.out.println("Enter 3 to approve joint customer accounts.");
			System.out.println("Enter 4 to deny joint customer accounts.");
			System.out.println("Enter 0 to quit.");

			int key = userinput.nextInt();

			switch (key) {
			case 1:
				System.out.println("Enter customer id number: ");
				id = userinput.nextInt();
				String approveCustomerStatement = "UPDATE customer SET status= '" + ApprovedStatus + "' WHERE id = "
						+ id;
				displaystatement = "SELECT id,username, status FROM customer WHERE id = " + id;
				StatusUpdate(approveCustomerStatement, displaystatement);
				break;
			case 2:
				System.out.println("Enter customer id number: ");
				id = userinput.nextInt();
				String denyCustomerStatement = "UPDATE customer SET status= '" + DeniedStatus + "' WHERE id = " + id;
				displaystatement = "SELECT id,username, status FROM customer WHERE id = " + id;
				StatusUpdate(denyCustomerStatement, displaystatement);
				break;
			case 3:
				System.out.println("Enter joint customer id number: ");
				id = userinput.nextInt();
				String approveJointStatement = "UPDATE jointcustomer SET status= '" + ApprovedStatus + "' WHERE id = "
						+ id;
				displaystatement = "SELECT id,username, status FROM jointcustomer WHERE id = " + id;
				StatusUpdate(approveJointStatement, displaystatement);
				break;
			case 4:
				System.out.println("Enter joint customer id number: ");
				id = userinput.nextInt();
				String denyJointStatement = "UPDATE jointcustomer SET status= '" + DeniedStatus + "' WHERE id = " + id;
				displaystatement = "SELECT id,username, status FROM jointcustomer WHERE id = " + id;
				StatusUpdate(denyJointStatement, displaystatement);
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (!quit);
		System.out.println("You have successfully quitted");
	}

}
