package org.revature.com.revature_project;

import java.sql.SQLException;
import java.util.Scanner;

import org.revature.com.Employee.Employee;

public class App {

	public static void DisplayMenu() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		boolean quit = false;
		do {
			System.out.println("|   Welcome to Ronny's Banking           |");
			System.out.println("|________________________________________|");
			System.out.println("| Select from the following options =)   |");
			System.out.println("|    0    1. Create a single account     |");
			System.out.println("|   -|-   2. Create a joint account      |");
			System.out.println("|    |    3. Log into your account       |");
			System.out.println("|    |    4. Employee                    |");
			System.out.println("|    |    5. Bank Admin                  |");
			System.out.println("|    ^    6. Exit                        |");
			System.out.println("|________________________________________|");

			System.out.print("Select option: ");

			int key = userInput.nextInt();

			switch (key) {
			case 1:
				Account bankaccount = new Account();
				bankaccount.createAccount();
				break;
			case 2:
				Account jointaccount = new Account();
				jointaccount.jointCreate();
				break;
			case 3:
				Account login = new Account();
				login.BankAccountLogin();
				break;
			case 4:
				Employee employee = new Employee();
				employee.UsersApplicationStatus();
				break;
			case 5:
				BankAdmin bankadmin = new BankAdmin();
				bankadmin.ManageAccounts();
				break;
			case 6:
				System.out.println("Ronny's bank says goodbye.");
				quit = true;
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}
		} while (!quit);

	}

	public static void main(String[] args) throws SQLException {
		DisplayMenu();

	}
}
