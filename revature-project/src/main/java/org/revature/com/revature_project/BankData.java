package org.revature.com.revature_project;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BankData {

	public BankData() {

	}

	void createAccount() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.println("You selected option 1: Create an account: ");
		String username;
		System.out.println("Enter your username: ");
		username = userInput.next();

		String password;
		System.out.println("Enter your password: ");
		password = userInput.next();

		String address;
		System.out.println("Enter your address: ");
		address = userInput.next();

		int phonenumber;
		System.out.println("Enter your phonenumber: ");
		phonenumber = userInput.nextInt();

		int socialsecuritynumber;
		System.out.println("Enter your ssn: ");
		socialsecuritynumber = userInput.nextInt();

		String status;
		status = "pending";

		DBUtilities dbUtilities = new DBUtilities();
		String sql_stmt = "INSERT INTO customer (username,password,address,phonenumber,socialsecuritynumber,status) VALUES ('"
				+ username + "','" + password + "','" + address + "','" + phonenumber + "','" + socialsecuritynumber
				+ "','" + status + "')";

		dbUtilities.ExecuteSQLStatement(sql_stmt);

		App.DisplayMenu();
	}

	void jointCreate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.println("You selected option 1: Create a joint account: ");
		String username;
		System.out.println("Enter your username: ");
		username = userInput.next();

		String password;
		System.out.println("Enter your password: ");
		password = userInput.next();

		String address;
		System.out.println("Enter your address: ");
		address = userInput.next();

		int phonenumber;
		System.out.println("Enter your phonenumber: ");
		phonenumber = userInput.nextInt();

		int socialsecuritynumber;
		System.out.println("Enter your ssn: ");
		socialsecuritynumber = userInput.nextInt();

		String status;
		status = "pending";

		String jointaddress;
		System.out.println("Enter your joint address: ");
		jointaddress = userInput.next();

		int jointphonenumber;
		System.out.println("Enter your joint phonenumber: ");
		jointphonenumber = userInput.nextInt();

		int jointsocialsecuritynumber;
		System.out.println("Enter your joint social security number: ");
		jointsocialsecuritynumber = userInput.nextInt();

		DBUtilities dbUtilities = new DBUtilities();
		String sql_stmt = "INSERT INTO jointcustomer (username,password,address,phonenumber,socialsecuritynumber,jointaddress,jointphonenumber,jointsocialsecuritynumber,status) VALUES ('"
				+ username + "','" + password + "','" + address + "','" + phonenumber + "','" + socialsecuritynumber
				+ "','" + jointaddress + "','" + jointphonenumber + "','" + jointsocialsecuritynumber + "','" + status
				+ "')";
		dbUtilities.ExecuteSQLStatement(sql_stmt);

		App.DisplayMenu();
	}

	void LogIn(String username, String password, String accountchoice, String tablestatement, int checkingindex,
			int savingindex) throws SQLException {
		DisplayResults(username, password, accountchoice, tablestatement, checkingindex, savingindex);
	}

	private void DisplayResults(String username, String password, String accountchoice, String tablestatement,
			int checkingindex, int savingindex) throws SQLException {
		List<Double> balancelist = new ArrayList<Double>();
		int id = 0;

		try {
			DBUtilities dbUtilities = new DBUtilities();

			String sql_stmt = tablestatement;
			ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);

			if (resultSet.next()) {

				ResultSetMetaData metaData = resultSet.getMetaData();
				int numberOfColumns = metaData.getColumnCount();

				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.println(metaData.getColumnName(i) + ": " + resultSet.getObject(i));
				}
				id = resultSet.getInt(1);

				double checkingbalance = resultSet.getDouble(checkingindex);
				double savingbalance = resultSet.getDouble(savingindex);

				balancelist.add(checkingbalance);
				balancelist.add(savingbalance);

				System.out.println();
			} else {
				System.out.println("No database records foundn");
			}

			dbUtilities.DisconnectFromDB();
		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		} finally {
			Transactions(balancelist, id, accountchoice);
		}
	}

	List<Double> Transactions(List<Double> balancelist, int id, String accountchoice) throws SQLException {
		return null;

	}

	void UpdateBalance(String updatebalancestatement, String displaybalancestatement) throws SQLException {

		DBUtilities dbUtilities = new DBUtilities();

		String sql_stmt = updatebalancestatement;

		dbUtilities.ExecuteSQLStatement(sql_stmt);

		DisplayRecord(displaybalancestatement);

	}

	protected void StatusUpdate(String statusstatement, String displaystatement) throws SQLException {

		DBUtilities dbUtilities = new DBUtilities();

		String sql_stmt = statusstatement;
		dbUtilities.ExecuteSQLStatement(sql_stmt);

		DisplayRecord(displaystatement);

	}

	protected void AccountLookUp(String tablestatement) throws SQLException {

		DisplayRecord(tablestatement);
	}

	private void DisplayRecord(String tablestatement) throws SQLException {
		try {
			DBUtilities dbUtilities = new DBUtilities();

			String sql_stmt = tablestatement;
			ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);
			if (resultSet.next()) {

				ResultSetMetaData metaData = resultSet.getMetaData();
				int numberOfColumns = metaData.getColumnCount();
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.printf("%-30s|", metaData.getColumnName(i));
				}
				System.out.println();

				do {
					for (int i = 1; i <= numberOfColumns; i++) {
						System.out.printf("%-30s|", resultSet.getObject(i));
					}
					System.out.println();
				} while (resultSet.next());

				System.out.println();

			} else {
				System.out.println("No database records found");
			}

			dbUtilities.DisconnectFromDB();
		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		} finally {

		}
	}

	void CancelAccount(String tablestatement) throws SQLException {
		DBUtilities dbUtilities = new DBUtilities();

		String sql_stmt = tablestatement;

		dbUtilities.ExecuteSQLStatement(sql_stmt);

		System.out.println("The Record has successfully being deleted");

	}

}
