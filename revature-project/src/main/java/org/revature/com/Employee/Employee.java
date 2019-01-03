package org.revature.com.Employee;

import java.sql.SQLException;
import java.util.Scanner;

import org.revature.com.revature_project.App;
import org.revature.com.revature_project.BankAdmin;

public class Employee extends BankAdmin {

	public Employee() {

	}

	public void UsersApplicationStatus() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		boolean quit = false;
		String viewSingleAccountTable = "SELECT * FROM customer";
		String viewJointAccountTable = "SELECT * FROM jointcustomer";
		do {
			System.out.println("Enter 1 to see single account user details.");
			System.out.println("Enter 2 to see joint account user details.");
			System.out.println("Enter 3 manage status of bank accounts.");
			System.out.println("Enter 0 to quit.");
			int key = userInput.nextInt();
			switch (key) {
			case 1:
				AccountLookUp(viewSingleAccountTable);
				break;
			case 2:
				AccountLookUp(viewJointAccountTable);
				break;
			case 3:
				ManageAccountStatus();
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("You have entered something invalid.");
				break;
			}
		} while (!quit);
		System.out.println("You have successfully quitted");
		App.DisplayMenu();

	}

}
