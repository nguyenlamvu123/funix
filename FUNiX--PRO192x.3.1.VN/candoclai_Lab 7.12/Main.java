package com.learnJava;

public class Main {
	/**
	 * You job is to create a simple banking application.
	 * There should be a Bank class
	 * It should have an arraylist of Branches
	 * Each Branch should have an arraylist of Customers
	 * The Customer class should have an arraylist of Doubles (transactions)
	 * Customer:
	 * - Name, and the ArrayList of doubles.
	 * Branch:
	 * - Need to be able to add a new customer and initial transaction amount.
	 * - Also needs to add additional transactions for that customer/branch
	 * Bank:
	 * - Add a new branch
	 * - Add a customer to that branch with initial transaction
	 * - Add a transaction for an existing customer for that branch
	 * - Show a list of customers for a particular branch and optionally a list of their transactions
	 * Demonstration autoboxing and unboxing in your code
	 * Hint: Transactions
	 * Add data validation.
	 * e.g. check if exists, or does not exist, etc.
	 * Think about where you are adding the code to perform certain actions
	 */
	public static void main(String[] args) {
		
		Bank bank = new Bank("Biat");
		
		if(bank.addBranch("Branch 1")) {
			System.out.println("Branch 1 created");
		}
		if(!bank.addBranch("Branch 1")) {
			System.out.println("Branch 1 already existS");
		}
		if(bank.addCustomerToBranch("Branch 1", "Tim", 1000.00)) {
			System.out.println("Customer Tim created");
		}
		bank.addCustomerToBranch("Branch 1", "John", 500.00);
		bank.addCustomerToBranch("Branch 1", "Tony", 250.00);
		if(!bank.addCustomerToBranch("Branch 1", "Tim", 1000.00)) {
			System.out.println("Customer Tim already exits");
		}
		
		if(bank.addBranch("Branch 2")) {
			System.out.println("Branch 2 created");
		}
		if(!bank.addBranch("Branch 2")) {
			System.out.println("Branch 2 already existS");
		}
		bank.addCustomerToBranch("Branch 2", "Justin", 45.00);
		bank.addCustomerToBranch("Branch 2", "Rihana", 100.00);
		
		bank.addCustomerTransaction("Branch 1", "Tim", 200.00);
		bank.listCustomer("Branch 1", true);
		

	}

}
