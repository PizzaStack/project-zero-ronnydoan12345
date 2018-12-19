package org.revature.com.revature_project;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	boolean quit = false;
    	double amount;
		Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter your username for your bank account");
    	String userName = scanner.nextLine();
    	System.out.println("Enter your password for your bank account");
    	String passWord = scanner.nextLine();
    	Account customer = new Account(userName, passWord);
    	
    	System.out.println("Account has been successfully created.");
    	
    	do {
    		System.out.println("Enter 1 to Withdraw.");
        	System.out.println("Enter 2 to Deposit.");
        	System.out.println("Enter 3 to check your checking balance.");
        	System.out.println("Enter 4 to transfer funds from checking to savings.");
        	System.out.println("Enter 5 to transfer funds from savings to checking.");
        	System.out.println("Enter 6 to check your saving balance.");
        	System.out.println("Enter 0 to quit.");
        	int key = scanner.nextInt();
        	switch(key) {
        	case 1:
            	System.out.println("Now enter the amount you would like to withdraw.");
            	amount = scanner.nextDouble();
        		customer.withdraw(amount);
        		break;
        		
        	case 2:
        		System.out.println("Now enter the amount you would like to deposit.");
            	amount = scanner.nextDouble();
        		customer.deposit(amount);
        		break;
        		
        	case 3:
        		System.out.println("Your checking balance is: " + customer.getCheckingBalance());
        		break;
        		
        	case 4:
        		System.out.println("Now enter the amount you would like to transfer.");
        		amount = scanner.nextDouble();
        		customer.transferFundsCheckingToSavings(amount);
        		break;
        	
        	case 5:
        		System.out.println("Now enter the amount you would like to transfer");
        		amount = scanner.nextDouble();
        		customer.transferFundsSavingToChecking(amount);
        		break;
        		
        	case 6:
        		System.out.println("Your saving balance is: " + customer.getSavingBalance());
        		break;	
        		
        	case 0:
        		quit = true;
        		break;
        		
        	default:
        		System.out.println("You have entered something invalid.");
        		break;
        	}
    	}while(!quit);
    	System.out.println("You have successfully quitted.");
    	


    	
    	
    	
    	
//    	System.out.println("Do you want to create a joint account? Enter Y or N");
//    	String jointAccount = scanner.nextLine();
//    	if(jointAccount == "Y") {
//    		JointAccount customerJointAcc = new JointAccount();
//    	}else if (jointAccount == "N") {
//    		return;
//    	}
    	
    	
    	
    }
}
